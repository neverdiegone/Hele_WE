package helen.com.we.network;


import helen.com.we.model.BookClass;
import helen.com.we.model.DataSchedules;
import helen.com.we.model.DataTeachers;
import helen.com.we.model.Logout;
import helen.com.we.model.ScheduleList;
import helen.com.we.model.TeacherDetails;
import helen.com.we.model.User;
import helen.com.we.network.responses.BaseListPageResponse;
import helen.com.we.network.responses.BaseListResponse;
import helen.com.we.network.responses.BaseResponse;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("en/member/login")
    Observable<BaseResponse<User>> loginUser(@Field("email") String email,
                                             @Field("password") String password,
                                             @Field("fcm_token") String fcm_token,
                                             @Field("device_type") String device_type,
                                             @Field("lang") String language);

    @FormUrlEncoded
    @POST("en/member/logout")
    Observable<BaseResponse<Logout>> logoutUser();

    @GET("en/member/profile")
    Observable<BaseResponse<User>> getProfileUser();

    @PUT("en/member/change-password")
    Observable<BaseResponse<Logout>> changePassword(@Field("old_password") String old_password,
                                                    @Field("new_password") String new_password);

    @PUT("en/member/update-fcm-token")
    Observable<BaseResponse<User>> updateFCMToken(@Field("fcm_token") String fcm_token);

    @GET("en/member/teacher")
    Observable<BaseResponse<ScheduleList>> getListTeachers(@Query("week_index") String index);

    @GET("en/member/teacher/{teacher_id}")
    Observable<BaseResponse<TeacherDetails>> getTeacherDetails(@Path("teacher_id") String teacher_id);

    @GET("en/member/teacher/{teacher_id}/schedule")
    Observable<BaseListResponse<DataSchedules>> getTeacherSchedule(@Path("teacher_id") String teacher_id, @Query("week_index") String index);

    @FormUrlEncoded
    @POST("en/member/teacher/{teacher_id}/schedule")
    Observable<BaseResponse<BookClass>> bookClass(@Path("teacher_id") String teacher_id, @Field("schedule_id") String schedule_id, @Field("status") String status);


}
