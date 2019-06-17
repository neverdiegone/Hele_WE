package helen.com.we;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;
import com.google.firebase.FirebaseApp;

import io.fabric.sdk.android.Fabric;

public class WeApplication extends Application {

    private static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        FirebaseApp.initializeApp(this);
        Fabric.with(this, new Crashlytics());
        Stetho.initializeWithDefaults(this);
        //AppDatabase.getAppDatabase(getApplicationContext());
    }
}
