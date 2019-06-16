package helen.com.we.fragment.profile.presenter;

import helen.com.we.model.User;

public interface AccountContract {

    interface viewAccount {
        void init();

        void showError(String message);

        void getAccountSuccess(User user);
    }

    interface presenterAccount {
        void start();

        void getProfile();
    }
}
