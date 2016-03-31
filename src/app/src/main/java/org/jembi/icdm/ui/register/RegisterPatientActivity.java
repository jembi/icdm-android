package org.jembi.icdm.ui.register;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import org.jembi.icdm.api.model.ApiError;
import org.jembi.icdm.api.model.Attributes;
import org.jembi.icdm.api.model.Data;
import org.jembi.icdm.api.model.DataElements;
import org.jembi.icdm.api.model.Parameters;
import org.jembi.icdm.api.model.TrackedEntity;
import org.jembi.icdm.api.utils.ErrorUtils;
import org.jembi.icdm.app.AppApplication;
import org.jembi.icdm.model.Patient;
import org.jembi.icdm.ui.referral.PatientReferralActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    @Bind(R.id.register_patient_edit_referral_date) TextView mEditReferralDate;
    @Bind(R.id.register_patient_button_referral_date) ImageButton mButtonReferralDate;
    @Bind(R.id.register_patient_edit_dob) TextView mEditDateOfBirth;
    @Bind(R.id.register_patient_button_dob) ImageButton mButtonDateOfBirth;
    @Bind(R.id.register_patient_radio_sex) RadioGroup mRadioGroupSex;
    @Bind(R.id.register_patient_radio_male) RadioButton mRadioButtonMale;
    @Bind(R.id.register_patient_radio_female) RadioButton mRadioButtonFemale;
    @Bind(R.id.register_patient_button_next) Button mButtonNext;
    private DatePickerDialog birthDatePickerDialog;
    private DatePickerDialog referralDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_patient_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mEditFirstName.addTextChangedListener(new RegisterPatientFormTextWatcher(mEditFirstName));
        mEditLastName.addTextChangedListener(new RegisterPatientFormTextWatcher(mEditLastName));
        mEditIdNumber.addTextChangedListener(new RegisterPatientFormTextWatcher(mEditIdNumber));
        mEditMobileNumber.addTextChangedListener(new RegisterPatientFormTextWatcher(mEditMobileNumber));
        mEditReferralDate.addTextChangedListener(new RegisterPatientFormTextWatcher(mEditReferralDate));
        mEditReferralReason.addTextChangedListener(new RegisterPatientFormTextWatcher(mEditReferralReason));
        mEditDateOfBirth.addTextChangedListener(new RegisterPatientFormTextWatcher(mEditDateOfBirth));

        createDatePickerDialogForBirthDate();
        createDatePickerDialogForReferralDate();

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPatient();
            }
        });

        mButtonDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Depends on the method createDatePickerDialogForBirthDate
                birthDatePickerDialog.show();
            }
        });

        mButtonReferralDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Depends on the method createDatePickerDialogForReferralDate
                referralDatePickerDialog.show();
            }
        });
    }

    private void createDatePickerDialogForBirthDate() {
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

    private void createDatePickerDialogForReferralDate() {
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Calendar newCalendar = Calendar.getInstance();

        referralDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                mEditReferralDate.setText(dateFormatter.format(newDate.getTime()));
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

        final AppApplication app = (AppApplication) this.getApplication();
        ApiService service = app.getDhis2ApiService();

        TrackedEntity trackedEntity = getTrackedEntity(patient);

        Call<ResponseBody> call = service.addTrackedEntity(trackedEntity);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    // use response data and do some fancy stuff :)
                } else {
                    // parse the response body …
                    ApiError error = ErrorUtils.parseError(response, app);
                    // … and use it to show error information

                    // … or just log the issue like we’re doing :)

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

        if (!validateReferralDate()) {
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
            // // TODO: Refactor this
            // Derive date of birth from id number and populate date of birth field
            String idNumber = mEditIdNumber.getText().toString().trim();
            if (idNumber.length() > 5) {
                String dob = idNumber.substring(0, 6);
                String year = dob.substring(0, 2);
                String month = dob.substring(2, 4);
                String day = dob.substring(4, 6);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
                try {
                    Date date = simpleDateFormat.parse(day + "-" + month + "-" + year);
                    mEditDateOfBirth.setText(dateFormatter.format(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            
            // Derive gender from id number and populate gender field
            if (idNumber.length() > 6) {
                // G  : Gender. 0-4 Female; 5-9 Male.
                String gender = idNumber.substring(6, 7);
                if (new Integer(gender).intValue() < 5)
                    mRadioButtonFemale.setChecked(true);
                else
                    mRadioButtonMale.setChecked(true);
            }
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
            mEditDateOfBirth.setError(getString(R.string.register_patient_err_msg_dob));
            requestFocus(mEditDateOfBirth);
            return false;
        } else {
            mEditDateOfBirth.setError(null);
        }
        return true;
    }

    private boolean validateReferralDate() {
        if (mEditReferralDate.getText().toString().trim().isEmpty()) {
            mEditReferralDate.setError(getString(R.string.register_patient_err_msg_referral_date));
            requestFocus(mEditReferralDate);
            return false;
        } else {
            mEditReferralDate.setError(null);
        }
        return true;
    }

    private Patient getPatient() {
        Calendar newCalendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
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

        try {
            patient.mReferralDate = simpleDateFormat.parse(mEditReferralDate.getText().toString()
                    .trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }

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

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        attribs.setDOB(df.format(patient.mDob));
        attribs.setFirstName(patient.mFirstName);
        attribs.setLastName(patient.mLastName);
        attribs.setGender(patient.mGender);
        attribs.setMobilePhoneNumber(patient.mFon);
        attribs.setNationalIdentityNumber(patient.mNId);

        dataElements.setCHWIdentificationNumber("test 1");
        dataElements.setReferralNumber(patient.getId().toString());
        dataElements.setReferralText(patient.mReferralReason);
        dataElements.setReferralDate(df.format(patient.mReferralDate));

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        String chwName = preferences.getString(getString(R.string.saved_username), "Unknown CHW Name");
        dataElements.setCHWName(chwName);

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
                case R.id.register_patient_button_referral_date:
                    validateReferralDate();
                    break;
            }
        }
    }
}
