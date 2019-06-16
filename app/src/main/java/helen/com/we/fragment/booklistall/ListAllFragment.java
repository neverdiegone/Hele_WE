package helen.com.we.fragment.booklistall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import helen.com.we.R;
import helen.com.we.fragment.BaseFragment;

public class ListAllFragment extends BaseFragment {
    @Override
    public View provideYourFragmentView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, parent, false);
        return view;
    }
}
