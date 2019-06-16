package helen.com.we.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("is_blocked")
    @Expose
    private Integer isBlocked;
    @SerializedName("login_token")
    @Expose
    private String loginToken;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("email_notification")
    @Expose
    private Integer emailNotification;
    @SerializedName("push_notification")
    @Expose
    private Integer pushNotification;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("skype_id")
    @Expose
    private String skypeId;
    @SerializedName("remain_session")
    @Expose
    private Integer remainSession;
    @SerializedName("expired_date")
    @Expose
    private String expiredDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Integer isBlocked) {
        this.isBlocked = isBlocked;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Integer emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Integer getPushNotification() {
        return pushNotification;
    }

    public void setPushNotification(Integer pushNotification) {
        this.pushNotification = pushNotification;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public Integer getRemainSession() {
        return remainSession;
    }

    public void setRemainSession(Integer remainSession) {
        this.remainSession = remainSession;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
}
