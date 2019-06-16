package helen.com.we.login.presenter;

import helen.com.we.model.User;
import helen.com.we.network.ApiFunction;
import helen.com.we.network.Callback;
import helen.com.we.network.responses.BaseResponse;

public class LoginPresenter implements LoginContract.presenterLogin {
    private LoginContract.viewLogin mView;

    public LoginPresenter(LoginContract.viewLogin mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void loginUser(String email, String password, String fcm_token, String device_type, String lang) {
        ApiFunction.postLogin(email, password, fcm_token, device_type, lang, new Callback<BaseResponse<User>>() {
            @Override
            public void returnResult(BaseResponse<User> userBaseResponse) {
                mView.loginSuccess(userBaseResponse.getData());

            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }

            @Override
            public void returnErrorAll(String message) {
                mView.showError(message);
            }
        });
    }
}
