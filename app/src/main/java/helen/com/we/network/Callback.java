package helen.com.we.network;

public abstract class Callback<T> {
    public abstract void returnResult(T t);

    public abstract void returnError(String message);

    public abstract void returnErrorAll(String message);
}
