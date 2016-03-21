package org.jembi.icdm.ui.registerpatient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.jembi.icdm.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterPatientActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.register_patient_edit_firstname) EditText mEditFirstName;
    @Bind(R.id.register_patient_edit_lastname) EditText mEditLastName;
    @Bind(R.id.register_patient_edit_id_number) EditText mEditIdNumber;
    @Bind(R.id.register_patient_edit_mobile_number) EditText mEditMobileNumber;
    @Bind(R.id.register_patient_edit_referral_reason) EditText mEditReferralReason;
    @Bind(R.id.register_patient_text_dob) TextView mTextDateOfBirth;
    @Bind(R.id.register_patient_button_dob) ImageButton mButtonDateOfBirth;
    @Bind(R.id.register_patient_button_next) Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_patient_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
    }
}
