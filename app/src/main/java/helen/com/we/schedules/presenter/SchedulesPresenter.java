package helen.com.we.schedules.presenter;

import helen.com.we.model.BookClass;
import helen.com.we.model.DataSchedules;
import helen.com.we.network.ApiFunction;
import helen.com.we.network.Callback;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;

public class SchedulesPresenter implements SchedulesContract.presenterSchedules {
    private SchedulesContract.viewSchedules mViewSchedules;

    public SchedulesPresenter(SchedulesContract.viewSchedules mViewSchedules) {
        this.mViewSchedules = mViewSchedules;
    }

    @Override
    public void start() {
        mViewSchedules.init();
    }

    @Override
    public void getListSchedules(String teacher_id, String index) {
        ApiFunction.getTeacherSchedule(teacher_id, index, new Callback<BaseListResponse<DataSchedules>>() {
            @Override
            public void returnResult(BaseListResponse<DataSchedules> dataSchedulesBaseListResponse) {
                mViewSchedules.getListSchedulesSuccess(dataSchedulesBaseListResponse);
            }

            @Override
            public void returnError(String message) {
                mViewSchedules.showError(message);
            }

            @Override
            public void returnErrorAll(String message) {
                mViewSchedules.showError(message);
            }
        });
    }

    @Override
    public void bookingSchedules(String teacher_id, String schedule_id, String status) {
        ApiFunction.getBookClass(teacher_id, schedule_id, status, new Callback<BaseResponse<BookClass>>() {
            @Override
            public void returnResult(BaseResponse<BookClass> bookClassBaseResponse) {
                mViewSchedules.bookClassSuccess(bookClassBaseResponse);
            }

            @Override
            public void returnError(String message) {
                mViewSchedules.showErrorBook(message);
            }

            @Override
            public void returnErrorAll(String message) {
                mViewSchedules.showErrorBook(message);
            }
        });
    }
}
