package helen.com.we.fragment.booking.presenter;

import helen.com.we.model.DataTeachers;
import helen.com.we.model.ScheduleList;
import helen.com.we.model.User;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;

public interface BookingContract {

    interface viewBooking {
        void init();

        void showError(String message);

        void getListBookingSuccess(BaseResponse<ScheduleList> dataTeachersBaseListResponse);
    }

    interface presenterBooking {
        void start();

        void getListBooking(String index);

    }
}
