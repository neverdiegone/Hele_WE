package helen.com.we.network;

public class NetworkingUtils {
    private static ApiInterface apiInterface;

    public static ApiInterface getUserApiInstance() {
        if (apiInterface == null)
            apiInterface = RetrofitAdapter.getInstance().create(ApiInterface.class);
        return apiInterface;
    }
}
