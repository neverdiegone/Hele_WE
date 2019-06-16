package helen.com.we.schedules.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import helen.com.we.R;
import helen.com.we.base.WeRecyclerAdapter;
import helen.com.we.base.CallBack;
import helen.com.we.model.Schedule;

public class SchedulesAdapter extends WeRecyclerAdapter<Schedule> {
    private CallBack.Booking callBack;

    public SchedulesAdapter(CallBack.Booking callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_schedules, viewGroup, false);
        return new ViewHolder(view, viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).init(dataSet.get(position), position);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        protected TextView tvStart_at;
        protected TextView tvEnd_at;
        protected TextView btnRegisterBook;

        public ViewHolder(View view, Context context) {
            super(view);
            this.context = context;
            tvStart_at = view.findViewById(R.id.item_scheduler_start_at);
            tvEnd_at = view.findViewById(R.id.item_scheduler_end_at);
            btnRegisterBook = view.findViewById(R.id.btn_register_book);
        }

        public void init(Schedule schedule, int position) {
            if (schedule.getStatus().equalsIgnoreCase("opened")) {
                btnRegisterBook.setVisibility(View.VISIBLE);
                btnRegisterBook.setOnClickListener(v -> callBack.onClickRegisterBook(position, String.valueOf(schedule.getTeacher().getId()), String.valueOf(schedule.getId()), "booked"));
            } else {
                btnRegisterBook.setVisibility(View.GONE);
            }

            tvStart_at.setText(schedule.getStartAt());
            tvEnd_at.setText(schedule.getEndAt());

        }
    }
}
