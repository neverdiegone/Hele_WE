package helen.com.we.fragment.booking.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import helen.com.we.R;
import helen.com.we.base.CallBack;
import helen.com.we.base.ItemDecorationAlbumColumns;
import helen.com.we.base.WeRecyclerAdapter;
import helen.com.we.model.DataTeachers;
import helen.com.we.model.Teacher;
import helen.com.we.schedules.SchedulesActivity;
import helen.com.we.util.Utils;

public class BookAllHomeAdapter extends WeRecyclerAdapter<DataTeachers> {
    private BookTeacherAdapter bookTeacherAdapter;
    private CallBack.Teacher callTeacher;
    private Context contextFagment;
    private String index;

    public BookAllHomeAdapter(Context contextFagment, String index) {
        this.contextFagment = contextFagment;
        this.index = index;
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
            callTeacher = (postion, id) -> {
                Toast.makeText(context, "" + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(contextFagment, SchedulesActivity.class);
                intent.putExtra("id_teacher", id);
                intent.putExtra("index", index);
                contextFagment.startActivity(intent);
            };

            tvDate = itemView.findViewById(R.id.item_tv_bookall_date);
            tvDateTime = itemView.findViewById(R.id.item_tv_bookall_datetime);
            rcyTeacher = itemView.findViewById(R.id.item_bookall_rcyListTeacher);
        }

        public void init(DataTeachers dataTeachers) {
            tvDate.setText(Utils.dateTimeVN(dataTeachers.getDate()));
            tvDateTime.setText(Utils.dateTime(dataTeachers.getDate()));
            bookTeacherAdapter = new BookTeacherAdapter(callTeacher);
            bookTeacherAdapter.addAll(dataTeachers.getTeachers());
            rcyTeacher.setAdapter(bookTeacherAdapter);
            rcyTeacher.setLayoutManager(new GridLayoutManager(context, 2));
            rcyTeacher.addItemDecoration(new ItemDecorationAlbumColumns(10, 2));

        }
    }
}
