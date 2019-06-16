package helen.com.we.schedules;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import helen.com.we.R;
import helen.com.we.base.BaseActivity;
import helen.com.we.base.CallBack;
import helen.com.we.model.BookClass;
import helen.com.we.model.DataSchedules;
import helen.com.we.model.Schedule;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;
import helen.com.we.schedules.adapter.SchdulesPartenAdapter;
import helen.com.we.schedules.adapter.SchedulesAdapter;
import helen.com.we.schedules.presenter.SchedulesContract;
import helen.com.we.schedules.presenter.SchedulesPresenter;
import helen.com.we.util.Utils;

public class SchedulesActivity extends BaseActivity implements SchedulesContract.viewSchedules, SchdulesPartenAdapter.callBackActivity {
    private String id_teacher;
    private String index;

    private ImageView imgAvatar;
    private TextView tvName, tvCountry;
    private RecyclerView rcySchedules;
    private LinearLayoutManager linearLayoutManager;
    private SchdulesPartenAdapter adapter;
    private SchedulesPresenter presenter;
    private List<DataSchedules> dataSchedulesList = new ArrayList<>();
    private int position ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules);
        if (getIntent() != null) {
            id_teacher = getIntent().getStringExtra("id_teacher");
            index = getIntent().getStringExtra("index");
        }

        imgAvatar = findViewById(R.id.img_avatar_teacher_schedules);
        tvName = findViewById(R.id.tv_name_teacher_schedules);
        tvCountry = findViewById(R.id.tv_country_teacher_schedules);
        rcySchedules = findViewById(R.id.rcy_teacher_schedules);
        presenter = new SchedulesPresenter(this);
        presenter.start();
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new SchdulesPartenAdapter(this);
        rcySchedules.setAdapter(adapter);
        rcySchedules.setLayoutManager(linearLayoutManager);
        rcySchedules.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setCallBackActivity(this);
    }

    @Override
    public void init() {
        presenter.getListSchedules(id_teacher, index);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void getListSchedulesSuccess(BaseListResponse<DataSchedules> dataSchedulesBaseListResponse) {
        dataSchedulesList.clear();
        dataSchedulesList.addAll(dataSchedulesBaseListResponse.getData());
        Utils.loadImageAvatar(dataSchedulesBaseListResponse.getData().get(0).getSchedules().get(0).getTeacher().getAvatar(), imgAvatar, this);
        tvName.setText(dataSchedulesBaseListResponse.getData().get(0).getSchedules().get(0).getTeacher().getName());
        tvCountry.setText(dataSchedulesBaseListResponse.getData().get(0).getSchedules().get(0).getTeacher().getCountry().getName());
        adapter.addAll(dataSchedulesList);
    }

    @Override
    public void bookClassSuccess(BaseResponse<BookClass> bookClassBaseResponse) {
        presenter.getListSchedules(id_teacher, index);
        Toast.makeText(this, "" + bookClassBaseResponse.getData().getStatus(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorBook(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerClass(int position, String teacher_id, String schedule_id, String status) {
        presenter.bookingSchedules(teacher_id, schedule_id, status);
    }
}
