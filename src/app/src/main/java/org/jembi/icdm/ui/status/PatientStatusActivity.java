package org.jembi.icdm.ui.status;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.jembi.icdm.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PatientStatusActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_status_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
    }
}
