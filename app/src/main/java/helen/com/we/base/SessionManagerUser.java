package helen.com.we.base;

import android.content.SharedPreferences;

import java.util.HashMap;

import helen.com.we.WeApplication;
import helen.com.we.model.User;

public class SessionManagerUser {

    private static SessionManagerUser instance;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "DataUser";

    private SessionManagerUser() {
        pref = WeApplication.getInstance().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static SessionManagerUser getInstance() {
        if (instance == null) {
            instance = new SessionManagerUser();
        }
        return instance;
    }


    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_ID = "Id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_AVATAR = "Avatar_Url";
    private static final String KEY_PHONE = "Phone";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_ADDRESS = "Address";
    private static final String KEY_GENDER = "Gender";
    private static final String KEY_OTP = "Otp";
    private static final String KEY_IS_ACTIVE = "Is_Active";
    private static final String KEY_IS_BLOCKED = "Is_Blocked";
    private static final String KEY_TOKEN = "Login_Token";
    private static final String KEY_LANG = "Lang";
    private static final String KEY_EMAIL_NOTIFICATION = "Email_Notification";
    private static final String KEY_PUSH_NOTIFICATION = "Push_Notification";
    private static final String KEY_CREATE_DATE = "Created_at";
    private static final String KEY_LAST_LOGIN = "Last_Login";
    private static final String KEY_SKYPE_ID = "Skype_Id";
    private static final String KEY_REMAIN_Session = "Remain_Session";
    private static final String KEY_EXPRIED_DATE = "Expried_Date";


    /**
     * Create login session
     */
    public void createLoginSession(User dataUser) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // Storing in pref
        editor.putString(KEY_ID, String.valueOf(dataUser.getId()));
        editor.putString(KEY_NAME, dataUser.getName());
        editor.putString(KEY_AVATAR, dataUser.getAvatar());
        editor.putString(KEY_PHONE, dataUser.getPhone());
        editor.putString(KEY_EMAIL, dataUser.getEmail());
        editor.putString(KEY_ADDRESS, dataUser.getAddress());
        editor.putString(KEY_GENDER, dataUser.getGender());
        editor.putString(KEY_OTP, dataUser.getOtp());
        editor.putString(KEY_IS_ACTIVE, String.valueOf(dataUser.getIsActive()));
        editor.putString(KEY_IS_BLOCKED, String.valueOf(dataUser.getIsBlocked()));
        editor.putString(KEY_TOKEN, dataUser.getLoginToken());
        editor.putString(KEY_LANG, dataUser.getLang());
        editor.putString(KEY_EMAIL_NOTIFICATION, String.valueOf(dataUser.getEmailNotification()));
        editor.putString(KEY_PUSH_NOTIFICATION, String.valueOf(dataUser.getPushNotification()));
        editor.putString(KEY_CREATE_DATE, dataUser.getCreatedAt());
        editor.putString(KEY_LAST_LOGIN, dataUser.getLastLogin());
        editor.putString(KEY_SKYPE_ID, dataUser.getSkypeId());
        editor.putString(KEY_REMAIN_Session, String.valueOf(dataUser.getRemainSession()));
        editor.putString(KEY_EXPRIED_DATE, dataUser.getExpiredDate());


        // commit changes
        editor.commit();
    }

    public void createLoginSessionFace() {
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }


    // Remove value whose key
    public void removeValue() {
        editor.remove(KEY_ID);
        editor.remove(KEY_NAME);
        editor.remove(KEY_GENDER);
        editor.remove(KEY_ADDRESS);
        editor.remove(KEY_PHONE);
        editor.remove(KEY_AVATAR);
        editor.commit();
    }


    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> data = new HashMap<String, String>();
        // data name
        data.put(KEY_ID, pref.getString(KEY_ID, ""));
        data.put(KEY_TOKEN, pref.getString(KEY_TOKEN, ""));
        data.put(KEY_EMAIL, pref.getString(KEY_EMAIL, ""));
        data.put(KEY_NAME, pref.getString(KEY_NAME, ""));
        data.put(KEY_GENDER, pref.getString(KEY_GENDER, ""));
        data.put(KEY_PHONE, pref.getString(KEY_PHONE, ""));
        data.put(KEY_AVATAR, pref.getString(KEY_AVATAR, ""));
        data.put(KEY_ADDRESS, pref.getString(KEY_ADDRESS, ""));
        data.put(KEY_CREATE_DATE, pref.getString(KEY_CREATE_DATE, ""));
        data.put(KEY_REMAIN_Session, pref.getString(KEY_REMAIN_Session, ""));
        data.put(KEY_PUSH_NOTIFICATION, String.valueOf(pref.getString(KEY_PUSH_NOTIFICATION, "")));
        // return data
        return data;
    }

    public String getUserToken() {
        String token = pref.getString(KEY_TOKEN, "");
        if (token == null) {
            token = "";
        } else {
            token = pref.getString(KEY_TOKEN, "");
        }
        return token;
    }

    public String getUserName() {
        return pref.getString(KEY_NAME, "");
    }

    public String getDeviceToken() {
        return pref.getString(KEY_TOKEN, "");
    }

    public String getUserEmail() {
        return pref.getString(KEY_EMAIL, "");
    }


    public String getUserId() {
        return pref.getString(KEY_ID, "");
    }

    public String getUserImage() {
        return pref.getString(KEY_AVATAR, "");
    }


    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

}
