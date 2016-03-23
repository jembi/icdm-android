package org.jembi.icdm.ui.referral;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.activeandroid.query.Select;

import org.jembi.icdm.model.Patient;
import org.jembi.icdm.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PatientReferralActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.patient_referral_label_referral_case_number) TextView mReferralCaseNumber;

    public static final String PATIENT_ID = "PATIENT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_referral_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long patientId = extras.getLong(PATIENT_ID);
            ArrayList<Patient> patients = new Select().from(Patient.class).where("Id=?", patientId).execute();
            if (patients != null && patients.size() > 0) {
                String referralCaseNumber = patients.get(0).getId().toString();
                mReferralCaseNumber.setText(referralCaseNumber);
            }
        }
    }
}
