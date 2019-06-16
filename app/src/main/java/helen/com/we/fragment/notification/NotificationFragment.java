package helen.com.we.fragment.notification;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import helen.com.we.R;
import helen.com.we.fragment.BaseFragment;

public class NotificationFragment extends BaseFragment {

    @Override
    public View provideYourFragmentView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, parent, false);
        return view;
    }
}
