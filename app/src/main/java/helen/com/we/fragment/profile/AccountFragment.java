package helen.com.we.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import helen.com.we.R;
import helen.com.we.base.SessionManagerUser;
import helen.com.we.fragment.BaseFragment;
import helen.com.we.fragment.profile.presenter.AccountContract;
import helen.com.we.fragment.profile.presenter.AccountPresenter;
import helen.com.we.model.User;
import helen.com.we.util.Utils;

public class AccountFragment extends BaseFragment implements AccountContract.viewAccount {
    private TextView tvExpired, tvProgressbar;
    private EditText edtUsername, edtMail, edtSkype, edtPhone;
    private AccountPresenter accountPresenter;
    private ProgressBar progressBar;
    private ImageView imgAvatarStudent;

    @Override
    public View provideYourFragmentView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, parent, false);
        //HashMap<String, String> hashMap = SessionManagerUser.getInstance().getUserDetails();
        initView(view);
        accountPresenter = new AccountPresenter(this);
        accountPresenter.start();
        return view;
    }


    private void initView(View view) {
        tvExpired = view.findViewById(R.id.tv_expired);
        edtUsername = view.findViewById(R.id.edt_account_username);
        edtMail = view.findViewById(R.id.edt_account_email);
        edtSkype = view.findViewById(R.id.edt_account_skype);
        edtPhone = view.findViewById(R.id.edt_account_phone);
        tvProgressbar = view.findViewById(R.id.txtProgress);
        progressBar = view.findViewById(R.id.progressBar);
        imgAvatarStudent = view.findViewById(R.id.img_avatar_student);
        Utils.disableEditText(edtUsername);
        Utils.disableEditText(edtSkype);
        Utils.disableEditText(edtMail);
        Utils.disableEditText(edtPhone);
    }

    @Override
    public void init() {
        accountPresenter.getProfile();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAccountSuccess(User user) {
        edtUsername.setText(user.getName());
        edtMail.setText(user.getEmail());
        edtPhone.setText(user.getPhone());
        edtSkype.setText(user.getSkypeId());
        tvProgressbar.setText(String.valueOf(user.getRemainSession()));
        progressBar.setProgress(user.getRemainSession());
        tvExpired.setText(user.getExpiredDate());
        Utils.loadImageAvatar(user.getAvatar(), imgAvatarStudent, getActivity());
    }
}
