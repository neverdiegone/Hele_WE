package helen.com.we.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import helen.com.we.MainActivity;
import helen.com.we.R;
import helen.com.we.base.BaseActivity;
import helen.com.we.base.SessionManagerUser;
import helen.com.we.login.presenter.LoginContract;
import helen.com.we.login.presenter.LoginPresenter;
import helen.com.we.model.User;
import helen.com.we.util.Utils;

public class LoginActivity extends BaseActivity implements LoginContract.viewLogin, View.OnClickListener {
    private LoginContract.presenterLogin mPrenseter;
    private Button btnLogin;
    private EditText edtUsername, edtPassword;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_login);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin.setOnClickListener(this);
        mPrenseter = new LoginPresenter(this);
        mPrenseter.start();

        imageView = findViewById(R.id.img_logo_login);
        imageView.setImageBitmap(Utils.decodeSampledBitmapFromResource(getResources(), R.drawable.logo, 200, 200));
    }

    @Override
    public void init() {
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(User user) {
        SessionManagerUser.getInstance().createLoginSession(user);
        Toast.makeText(this, "" + SessionManagerUser.getInstance().getUserToken(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login: {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                mPrenseter.loginUser(username, password, "EEEEE", "ANDROID", "en");
                break;
            }
        }
    }
}
