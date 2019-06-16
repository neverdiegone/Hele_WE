package helen.com.we.fragment.profile.presenter;

import helen.com.we.model.User;
import helen.com.we.network.ApiFunction;
import helen.com.we.network.Callback;
import helen.com.we.network.responses.BaseResponse;

public class AccountPresenter implements AccountContract.presenterAccount {
    private AccountContract.viewAccount mView;

    public AccountPresenter(AccountContract.viewAccount mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void getProfile() {
        ApiFunction.getProfileUser(new Callback<BaseResponse<User>>() {
            @Override
            public void returnResult(BaseResponse<User> userBaseResponse) {
                mView.getAccountSuccess(userBaseResponse.getData());
            }

            @Override
            public void returnError(String message) {

            }

            @Override
            public void returnErrorAll(String message) {
                mView.showError(message);
            }
        });
    }
}
