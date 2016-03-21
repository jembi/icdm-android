package org.jembi.icdm.ui.login;

import android.content.Intent;
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

import org.jembi.icdm.R;
import org.jembi.icdm.ui.view_patients.ViewPatientsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.login_edit_username) EditText mEditUsername;
    @Bind(R.id.login_edit_password) EditText mEditPassword;
    @Bind(R.id.login_button_sign_in) Button mButtonSignIn;
    @Bind(R.id.login_input_layout_username) TextInputLayout mInputLayoutUsername;
    @Bind(R.id.login_input_layout_password) TextInputLayout mInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mEditUsername.addTextChangedListener(new LoginFormTextWatcher(mEditUsername));
        mEditPassword.addTextChangedListener(new LoginFormTextWatcher(mEditPassword));

        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    private void signIn() {
        if (!validateUserName()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        startActivity(new Intent(this, ViewPatientsActivity.class));
        finish();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateUserName() {
        if (mEditUsername.getText().toString().trim().isEmpty()) {
            mInputLayoutUsername.setError(getString(R.string.err_msg_username));
            requestFocus(mEditUsername);
            return false;
        } else {
            mInputLayoutUsername.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (mEditPassword.getText().toString().trim().isEmpty()) {
            mInputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(mEditPassword);
            return false;
        } else {
            mInputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private class LoginFormTextWatcher implements TextWatcher {

        private View view;

        private LoginFormTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.login_edit_username:
                    validateUserName();
                    break;
                case R.id.login_edit_password:
                    validatePassword();
                    break;
            }
        }
    }
}
