package helen.com.we.base;

public interface CallBack {
    interface Teacher {
        void onClickTeacher(int postion, String id);
    }

    interface Booking {
        void onClickRegisterBook(int position, String teacher_id, String schedule_id, String status);
    }

}
