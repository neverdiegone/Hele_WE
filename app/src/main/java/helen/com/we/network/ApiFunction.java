package helen.com.we.network;

import helen.com.we.model.BookClass;
import helen.com.we.model.DataSchedules;
import helen.com.we.model.DataTeachers;
import helen.com.we.model.Logout;
import helen.com.we.model.ScheduleList;
import helen.com.we.model.TeacherDetails;
import helen.com.we.model.User;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ApiFunction {

    public static void postLogin(String email, String password, String fcm_token, String device_type, String lang, Callback<BaseResponse<User>> callback) {
        NetworkingUtils.getUserApiInstance().loginUser(email, password, fcm_token, device_type, lang)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<User> userBaseResponse) {
                        if (userBaseResponse.getSuccess()) {
                            callback.returnResult(userBaseResponse);
                        } else {
                            callback.returnErrorAll(userBaseResponse.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void logOut(Callback<BaseResponse<Logout>> callback) {
        NetworkingUtils.getUserApiInstance().logoutUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<Logout>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<Logout> logoutBaseResponse) {
                        if (logoutBaseResponse.getSuccess()) {
                            callback.returnResult(logoutBaseResponse);
                        } else {
                            callback.returnErrorAll(logoutBaseResponse.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void changePassword(String old_password, String new_password, Callback<BaseResponse<Logout>> callback) {
        NetworkingUtils.getUserApiInstance().changePassword(old_password, new_password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<Logout>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<Logout> logoutBaseResponse) {
                        if (logoutBaseResponse.getSuccess()) {
                            callback.returnResult(logoutBaseResponse);
                        } else {
                            callback.returnErrorAll(logoutBaseResponse.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void getProfileUser(Callback<BaseResponse<User>> callback) {
        NetworkingUtils.getUserApiInstance().getProfileUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseResponse<User> userBaseResponse) {
                        if (userBaseResponse.getSuccess()) {
                            callback.returnResult(userBaseResponse);
                        } else {
                            callback.returnErrorAll(userBaseResponse.getMessage());

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void getListTeachers(String index, Callback<BaseResponse<ScheduleList>> callback) {
        NetworkingUtils.getUserApiInstance().getListTeachers(index)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<ScheduleList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<ScheduleList> dataTeachersBaseListResponse) {
                        if (dataTeachersBaseListResponse.getSuccess()) {
                            callback.returnResult(dataTeachersBaseListResponse);
                        } else {
                            callback.returnErrorAll(dataTeachersBaseListResponse.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void getTeachersId(String id_teachers, Callback<BaseResponse<TeacherDetails>> callback) {
        NetworkingUtils.getUserApiInstance().getTeacherDetails(id_teachers)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<TeacherDetails>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<TeacherDetails> dataTeachersDeatails) {
                        if (dataTeachersDeatails.getSuccess()) {
                            callback.returnResult(dataTeachersDeatails);
                        } else {
                            callback.returnErrorAll(dataTeachersDeatails.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void getTeacherSchedule(String id_teachers, String index, Callback<BaseListResponse<DataSchedules>> callback) {
        NetworkingUtils.getUserApiInstance().getTeacherSchedule(id_teachers, index)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseListResponse<DataSchedules>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseListResponse<DataSchedules> dataSchedules) {
                        if (dataSchedules.getSuccess()) {
                            callback.returnResult(dataSchedules);
                        } else {
                            callback.returnErrorAll(dataSchedules.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void getBookClass(String id_teachers, String schedule_id, String status, Callback<BaseResponse<BookClass>> callback) {
        NetworkingUtils.getUserApiInstance().bookClass(id_teachers, schedule_id, status)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<BookClass>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<BookClass> dataBookClass) {
                        if (dataBookClass.getSuccess()) {
                            callback.returnResult(dataBookClass);
                        } else {
                            callback.returnErrorAll(dataBookClass.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
