package helen.com.we.fragment.booking;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import helen.com.we.R;
import helen.com.we.fragment.BaseFragment;
import helen.com.we.fragment.booking.adapter.BookAllHomeAdapter;
import helen.com.we.fragment.booking.presenter.BookingContract;
import helen.com.we.fragment.booking.presenter.BookingPresenter;
import helen.com.we.model.DataTeachers;
import helen.com.we.model.ScheduleList;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;
import helen.com.we.util.Utils;

public class HomeFragment extends BaseFragment implements BookingContract.viewBooking, View.OnClickListener {
    private RecyclerView recyclerView;
    private BookAllHomeAdapter allHomeAdapter;
    private BookingPresenter bookingPresenter;
    private int index = 0;
    private Toolbar toolbar;
    private TextView btnNext, btnPrevious, tvTitle;
    private List<DataTeachers> dataTeachersList = new ArrayList<>();
    private SwipeRefreshLayout refreshLayout;

    @Override
    public View provideYourFragmentView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking, parent, false);
        initView(view);
        bookingPresenter = new BookingPresenter(this);
        bookingPresenter.getListBooking(String.valueOf(index));
        bookingPresenter.start();

        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.rcy_list_book);
        toolbar = view.findViewById(R.id.toolbar);
        tvTitle = view.findViewById(R.id.tv_toolbar_header);
        btnNext = view.findViewById(R.id.tv_toolbar_next);
        btnPrevious = view.findViewById(R.id.tv_toolbar_back);
        refreshLayout = view.findViewById(R.id.swipe_layout);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        tvTitle.setText(getString(R.string.list_teacher));
        refreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.light_blue_300, R.color.green_400);
        refreshLayout.setOnRefreshListener(() -> {
            bookingPresenter.getListBooking(String.valueOf(index));
        });
    }

    @Override
    public void init() {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getListBookingSuccess(BaseResponse<ScheduleList> dataTeachersBaseListResponse) {
        refreshLayout.setRefreshing(false);
        dataTeachersList.clear();
        dataTeachersList.addAll(dataTeachersBaseListResponse.getData().getDataTeachersList());
        allHomeAdapter = new BookAllHomeAdapter(getActivity(), String.valueOf(index));
        allHomeAdapter.addAll(dataTeachersList);
        recyclerView.setAdapter(allHomeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        //Utils.showDialog(getContext(), R.drawable.icon_success, "Title_Succes", "Home_Fragment");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_toolbar_next: {
                index++;
                Toast.makeText(getActivity(), "" + index, Toast.LENGTH_SHORT).show();
                bookingPresenter.getListBooking(String.valueOf(index));
                break;
            }
            case R.id.tv_toolbar_back: {
                index--;
                Toast.makeText(getActivity(), "" + index, Toast.LENGTH_SHORT).show();
                bookingPresenter.getListBooking(String.valueOf(index));
                break;
            }
        }
    }
}
