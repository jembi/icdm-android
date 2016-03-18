package org.jembi.icdm.ui.viewpatients;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.jembi.icdm.R;
import org.jembi.icdm.ui.registerpatient.RegisterPatientActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewPatientsActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.fab) FloatingActionButton mButtonRegisterPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_patients_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mButtonRegisterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterPatientActivity.class));
            }
        });
    }

}
