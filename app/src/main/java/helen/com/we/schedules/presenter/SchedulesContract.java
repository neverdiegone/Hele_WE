package helen.com.we.schedules.presenter;

import helen.com.we.model.BookClass;
import helen.com.we.model.DataSchedules;
import helen.com.we.model.DataTeachers;
import helen.com.we.model.Schedule;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;

public interface SchedulesContract {
    interface viewSchedules {
        void init();

        void showError(String message);

        void getListSchedulesSuccess(BaseListResponse<DataSchedules> dataSchedulesBaseListResponse);

        void bookClassSuccess(BaseResponse<BookClass> bookClassBaseResponse);

        void showErrorBook(String message);
    }

    interface presenterSchedules {

        void start();

        void getListSchedules(String teacher_id, String index);

        void bookingSchedules(String teacher_id, String schedule_id, String status);
    }
}
