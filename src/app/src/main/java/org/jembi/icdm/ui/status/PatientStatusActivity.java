package org.jembi.icdm.ui.status;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.activeandroid.query.Select;

import org.jembi.icdm.R;
import org.jembi.icdm.model.Patient;
import org.jembi.icdm.ui.referral.PatientReferralActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PatientStatusActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.patient_status_fullname) TextView mLabelFullName;
    @Bind(R.id.patient_status_reported_date) TextView mLabelDateReported;
    @Bind(R.id.patient_status_diagnosis) TextView mLabelDiagnosis;
    @Bind(R.id.patient_status_therapy) TextView mLabelTherapy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_status_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long patientId = extras.getLong(PatientReferralActivity.PATIENT_ID);
            ArrayList<Patient> patients = new Select().from(Patient.class).where("Id=?", patientId).execute();
            if (patients != null && patients.size() > 0) {
                populate(patients.get(0));
            }
        }
    }

    private void populate(Patient item) {
        mLabelFullName.setText(item.mFirstName + " " + item.mLastName);
    }
}
