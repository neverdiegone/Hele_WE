package helen.com.we.schedules.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import helen.com.we.R;
import helen.com.we.base.CallBack;
import helen.com.we.base.WeRecyclerAdapter;
import helen.com.we.model.DataSchedules;
import helen.com.we.util.Utils;

public class SchdulesPartenAdapter extends WeRecyclerAdapter<DataSchedules> {
    private SchedulesAdapter schedulesAdapter;
    private CallBack.Booking callBooking;
    private Context contextFagment;
    private callBackActivity callBackActivity;

    public void setCallBackActivity(SchdulesPartenAdapter.callBackActivity callBackActivity) {
        this.callBackActivity = callBackActivity;
    }

    public SchdulesPartenAdapter(Context contextFagment) {
        this.contextFagment = contextFagment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_partern_booking, viewGroup, false);
        return new ViewHolder(view, viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).init(dataSet.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        protected TextView tvDate;
        protected TextView tvDateTime;
        protected RecyclerView rcyTeacher;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            callBooking = (position, teacher_id, schedule_id, status) -> {
                callBackActivity.registerClass(position, teacher_id, schedule_id, status);
            };

            tvDate = itemView.findViewById(R.id.item_tv_bookall_date);
            tvDateTime = itemView.findViewById(R.id.item_tv_bookall_datetime);
            rcyTeacher = itemView.findViewById(R.id.item_bookall_rcyListTeacher);
        }

        public void init(DataSchedules dataTeachers) {
            tvDate.setText(Utils.dateTimeVN(dataTeachers.getDate()));
            tvDateTime.setText(Utils.dateTime(dataTeachers.getDate()));
            schedulesAdapter = new SchedulesAdapter(callBooking);
            schedulesAdapter.addAll(dataTeachers.getSchedules());
            rcyTeacher.setAdapter(schedulesAdapter);
            rcyTeacher.setLayoutManager(new LinearLayoutManager(context));
            rcyTeacher.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        }
    }

    public interface callBackActivity {
        void registerClass(int position, String teacher_id, String schedule_id, String status);
    }
}