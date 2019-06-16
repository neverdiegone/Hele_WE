package helen.com.we.fragment.booking.presenter;

import helen.com.we.model.DataTeachers;
import helen.com.we.model.ScheduleList;
import helen.com.we.network.ApiFunction;
import helen.com.we.network.Callback;
import helen.com.we.network.NetworkingUtils;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;

public class BookingPresenter implements BookingContract.presenterBooking {
    private BookingContract.viewBooking mView;

    public BookingPresenter(BookingContract.viewBooking mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void getListBooking(String index) {
        ApiFunction.getListTeachers(index, new Callback<BaseResponse<ScheduleList>>() {
            @Override
            public void returnResult(BaseResponse<ScheduleList> dataTeachersBaseListResponse) {
                mView.getListBookingSuccess(dataTeachersBaseListResponse);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }

            @Override
            public void returnErrorAll(String message) {
                mView.showError(message);
            }
        });
    }
}
