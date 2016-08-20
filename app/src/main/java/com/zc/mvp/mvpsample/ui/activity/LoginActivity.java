package com.zc.mvp.mvpsample.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.zc.mvp.mvpsample.R;
import com.zc.mvp.mvpsample.presenter.LoginPresenter;
import com.zc.mvp.mvpsample.presenter.LoginPresenterImpl;
import com.zc.mvp.mvpsample.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private ProgressBar progressbar;
    private Button submit;
    private TextView username;
    private TextView password;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();

    }

    private void initComponent() {
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);

        assert submit != null;
        submit.setOnClickListener(this);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);

        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void progressVisible(boolean visible) {
        progressbar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void showError(String index, String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                String username = this.username.getText().toString();
                String password = this.password.getText().toString();
                loginPresenter.loginCheck(username, password);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.destroyView();
    }
}
