package org.jembi.icdm.ui.registerpatient;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.jembi.icdm.R;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_patient_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPatient();
            }
        });
    }

    private void registerPatient() {
        if (!validateFirstName()) {
            return;
        }

        if (!validateLastName()) {
            return;
        }

        if (!validateIdNumber()) {
            return;
        }

        if (!validateMobile()) {
            return;
        }

        if (!validateReferralReason()) {
            return;
        }

        if (!validateGender()) {
            return;
        }

        if (!validateBirthDate()) {
            return;
        }
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
        if (mEditMobileNumber.getText().toString().trim().isEmpty()) {
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
        return false;
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
