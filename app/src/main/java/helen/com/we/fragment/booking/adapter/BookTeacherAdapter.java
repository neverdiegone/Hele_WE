package helen.com.we.fragment.booking.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import helen.com.we.R;
import helen.com.we.base.CallBack;
import helen.com.we.base.WeRecyclerAdapter;
import helen.com.we.model.Teacher;
import helen.com.we.util.Utils;

public class BookTeacherAdapter extends WeRecyclerAdapter<Teacher> {
    private CallBack.Teacher callBack;

    public BookTeacherAdapter(CallBack.Teacher callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_teacher, viewGroup, false);
        return new BookTeacherAdapter.ViewHolder(view, viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).init(dataSet.get(position), holder, position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        protected ImageView imageView;
        protected TextView tvVideo;
        protected TextView tvDescrption;
        protected TextView tvNameTeacher;
        protected TextView tvCountryTeacher;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            imageView = itemView.findViewById(R.id.item_img_teacher);
            tvVideo = itemView.findViewById(R.id.item_tv_video_teacher);
            tvDescrption = itemView.findViewById(R.id.item_tv_decrption_teacher);
            tvNameTeacher = itemView.findViewById(R.id.item_tv_name_teacher);
            tvCountryTeacher = itemView.findViewById(R.id.item_tv_country_teacher);
        }

        public void init(Teacher teacher, RecyclerView.ViewHolder holder, int pos) {
            tvVideo.setText(teacher.getVideoIntroduction());
            tvCountryTeacher.setText("Quốc gia :" + teacher.getCountry().getName());
            tvDescrption.setText(teacher.getShortIntroduction());
            tvNameTeacher.setText("Họ Tên : " + teacher.getName());
            String urlTeacher = teacher.getAvatar();
            Utils.loadImageAvatar(urlTeacher, imageView, context);
            holder.itemView.setOnClickListener(v -> callBack.onClickTeacher(pos, String.valueOf(teacher.getId())));
        }
    }
}
