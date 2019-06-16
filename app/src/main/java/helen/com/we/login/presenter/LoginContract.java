package helen.com.we.login.presenter;

import helen.com.we.model.User;

public interface LoginContract {

    interface viewLogin {
        void init();

        void showError(String message);

        void loginSuccess(User user);
    }

    interface presenterLogin {
        void start();

        void loginUser(String email, String password, String fcm_token, String device_type, String lang);
    }
}
