package org.jembi.icdm.ui.register;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.jembi.icdm.R;
import org.jembi.icdm.api.ApiService;
import org.jembi.icdm.api.model.Attributes;
import org.jembi.icdm.api.model.Data;
import org.jembi.icdm.api.model.DataElements;
import org.jembi.icdm.api.model.Parameters;
import org.jembi.icdm.api.model.TrackedEntity;
import org.jembi.icdm.app.AppApplication;
import org.jembi.icdm.model.Patient;
import org.jembi.icdm.ui.referral.PatientReferralActivity;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterPatientActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.register_patient_edit_firstname) EditText mEditFirstName;
    @Bind(R.id.register_patient_input_layout_firstname) TextInputLayout mInputLayoutFirstName;
    @Bind(R.id.register_patient_edit_lastname) EditText mEditLastName;
    @Bind(R.id.register_patient_input_layout_lastname) TextInputLayout mInputLayoutLastName;
    @Bind(R.id.register_patient_edit_id_number) EditText mEditIdNumber;
    @Bind(R.id.register_patient_input_layout_id_number) TextInputLayout mInputLayoutIdNumber;
    @Bind(R.id.register_patient_edit_mobile_number) EditText mEditMobileNumber;
    @Bind(R.id.register_patient_input_layout_mobile_number) TextInputLayout mInputLayoutMobileNumber;
    @Bind(R.id.register_patient_edit_referral_reason) EditText mEditReferralReason;
    @Bind(R.id.register_patient_input_layout_referral_reason) TextInputLayout mInputLayoutReferralReason;
    @Bind(R.id.register_patient_input_layout_dob) TextInputLayout mInputLayoutDateOfBirth;
    @Bind(R.id.register_patient_edit_dob) TextView mEditDateOfBirth;
    @Bind(R.id.register_patient_button_dob) ImageButton mButtonDateOfBirth;
    @Bind(R.id.register_patient_radio_sex) RadioGroup mRadioGroupSex;
    @Bind(R.id.register_patient_radio_male) RadioButton mRadioButtonMale;
    @Bind(R.id.register_patient_radio_female) RadioButton mRadioButtonFemale;
    @Bind(R.id.register_patient_button_next) Button mButtonNext;
    private DatePickerDialog birthDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_patient_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        setBirthDate();

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPatient();
            }
        });

        mButtonDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birthDatePickerDialog.show();
            }
        });
    }

    private void setBirthDate() {
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Calendar newCalendar = Calendar.getInstance();

        birthDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                mEditDateOfBirth.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void registerPatient() {

        if (!validateForm())
            return;

        Patient patient = getPatient();
        patient.save();

        postPatientDataToDhis2(patient);

        navigateToPatientReferral(patient.getId());
    }

    private void postPatientDataToDhis2(Patient patient) {

        AppApplication app = (AppApplication) this.getApplication();
        ApiService service = app.getDhis2ApiService();

        TrackedEntity trackedEntity = getTrackedEntity(patient);

        Call<ResponseBody> call = service.addTrackedEntity(trackedEntity);

        call.enqueue(new Callback<ResponseBody>() {


            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("post", "onSuccess");
                Log.i("post", "isSuccess: " + String.valueOf(response.isSuccessful()));
                Log.i("post", String.valueOf(response.code()));
                Log.i("post", response.message());

                try {
                    Log.i("post", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("post", "onFailure");
                Log.i("post", t.getMessage());
            }
        });
    }

    private boolean validateForm() {
        if (!validateFirstName()) {
            return false;
        }

        if (!validateLastName()) {
            return false;
        }

        if (!validateIdNumber()) {
            return false;
        }

        if (!validateMobile()) {
            return false;
        }

        if (!validateReferralReason()) {
            return false;
        }

        if (!validateGender()) {
            return false;
        }

        if (!validateBirthDate()) {
            return false;
        }
        return true;
    }

    private void navigateToPatientReferral(long id) {
        Intent intent = new Intent(this, PatientReferralActivity.class);
        intent.putExtra(PatientReferralActivity.PATIENT_ID, id);
        startActivity(intent);
        finish();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateFirstName() {
        if (mEditFirstName.getText().toString().trim().isEmpty()) {
            mInputLayoutFirstName.setError(getString(R.string.register_patient_err_msg_firstname));
            requestFocus(mEditFirstName);
            return false;
        } else {
            mInputLayoutFirstName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateLastName() {
        if (mEditLastName.getText().toString().trim().isEmpty()) {
            mInputLayoutLastName.setError(getString(R.string.register_patient_err_msg_lastname));
            requestFocus(mEditLastName);
            return false;
        } else {
            mInputLayoutLastName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateIdNumber() {
        if (mEditIdNumber.getText().toString().trim().isEmpty()) {
            mInputLayoutIdNumber.setError(getString(R.string.register_patient_err_msg_id_number));
            requestFocus(mEditIdNumber);
            return false;
        } else {
            mInputLayoutIdNumber.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMobile() {
        Pattern pattern = Pattern.compile("^(\\+27|0)\\d{9}$");
        Matcher matcher = pattern.matcher(mEditMobileNumber.getText().toString().trim());

        if (!matcher.matches()) {
            mInputLayoutMobileNumber.setError(getString(R.string.register_patient_err_msg_mobile));
            requestFocus(mEditMobileNumber);
            return false;
        } else {
            mInputLayoutMobileNumber.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateReferralReason() {
        if (mEditReferralReason.getText().toString().trim().isEmpty()) {
            mInputLayoutReferralReason.setError(getString(R.string.register_patient_err_msg_referral_reason));
            requestFocus(mEditReferralReason);
            return false;
        } else {
            mInputLayoutReferralReason.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateGender() {
        if (mRadioGroupSex.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, getResources().getString(R.string.register_patient_err_msg_gender), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validateBirthDate() {
        if (mEditDateOfBirth.getText().toString().trim().isEmpty()) {
            mInputLayoutDateOfBirth.setError(getString(R.string.register_patient_err_msg_dob));
            requestFocus(mEditDateOfBirth);
        } else {
            mInputLayoutDateOfBirth.setErrorEnabled(false);
        }
        return true;
    }

    private Patient getPatient() {
        Calendar newCalendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Patient patient = new Patient();
        patient.mFirstName = mEditFirstName.getText().toString().trim();
        patient.mLastName = mEditLastName.getText().toString().trim();
        patient.mNId = mEditIdNumber.getText().toString().trim();
        patient.mFon = mEditMobileNumber.getText().toString().trim();
        patient.mReferralReason = mEditReferralReason.getText().toString().trim();

        try {
            patient.mDob = simpleDateFormat.parse(mEditDateOfBirth.getText().toString().trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Male:  1
        // Female:  2
        String gender = "2";
        if (mRadioButtonMale.isChecked()) {
            gender = "1";
        }
        patient.mGender = gender;
        patient.mReferralDate = newCalendar.getTime();

        return patient;
    }

    private TrackedEntity getTrackedEntity(Patient patient) {

        Calendar newCalendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        TrackedEntity trackedEntity = new TrackedEntity();
        trackedEntity.setUrl("http://admin:district@107.170.125.158:8080/");
        trackedEntity.setProgram("Zgp0gjXASHW");
        trackedEntity.setProgramStage("iAkiVnzJ1Ii");
        trackedEntity.setTrackedEntity("T1CAqiqCs5Z");

        Data data = new Data();
        Parameters parameters = new Parameters();
        Attributes attribs = new Attributes();
        DataElements dataElements = new DataElements();

        parameters.setOrgUnit("Fws0A9spb9F");
        parameters.setEventOrgUnit("Fws0A9spb9F");
        parameters.setProgramDate(simpleDateFormat.format(newCalendar.getTime()));
        parameters.setEventDate(simpleDateFormat.format(newCalendar.getTime()));

        attribs.setDOB(simpleDateFormat.format(patient.mDob));
        attribs.setFirstName(patient.mFirstName);
        attribs.setLastName(patient.mLastName);
        attribs.setGender(patient.mGender);
        attribs.setMobilePhoneNumber(patient.mFon);
        attribs.setNationalIdentityNumber(patient.mNId);

        dataElements.setCHWIdentificationNumber("test 1");
        dataElements.setReferralNumber(patient.getId().toString());
        dataElements.setReferralText(patient.mReferralReason);
        dataElements.setReferralDate(simpleDateFormat.format(patient.mReferralDate));
        dataElements.setCHWName("Clive Test");

        data.setDataElements(dataElements);
        data.setAttributes(attribs);
        data.setParameters(parameters);
        trackedEntity.setData(data);

        return trackedEntity;
    }

    private class RegisterPatientFormTextWatcher implements TextWatcher {

        private View view;

        private RegisterPatientFormTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.register_patient_edit_firstname:
                    validateFirstName();
                    break;
                case R.id.register_patient_edit_lastname:
                    validateLastName();
                    break;
                case R.id.register_patient_edit_id_number:
                    validateIdNumber();
                    break;
                case R.id.register_patient_edit_mobile_number:
                    validateMobile();
                    break;
                case R.id.register_patient_edit_referral_reason:
                    validateReferralReason();
                    break;
                case R.id.register_patient_edit_dob:
                    validateBirthDate();
                    break;
            }
        }
    }
}
