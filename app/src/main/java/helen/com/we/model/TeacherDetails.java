package helen.com.we.model;

import com.google.gson.annotations.SerializedName;

public class TeacherDetails {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("gender")
    private String gender;
    @SerializedName("is_verified")
    private Integer isVerified;
    @SerializedName("country")
    private Country country;
    @SerializedName("short_introduction")
    private String shortIntroduction;
    @SerializedName("long_introduction")
    private String longIntroduction;
    @SerializedName("audio_introduction")
    private String audioIntroduction;
    @SerializedName("video_introduction")
    private String videoIntroduction;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getShortIntroduction() {
        return shortIntroduction;
    }

    public void setShortIntroduction(String shortIntroduction) {
        this.shortIntroduction = shortIntroduction;
    }

    public String getLongIntroduction() {
        return longIntroduction;
    }

    public void setLongIntroduction(String longIntroduction) {
        this.longIntroduction = longIntroduction;
    }

    public String getAudioIntroduction() {
        return audioIntroduction;
    }

    public void setAudioIntroduction(String audioIntroduction) {
        this.audioIntroduction = audioIntroduction;
    }

    public String getVideoIntroduction() {
        return videoIntroduction;
    }

    public void setVideoIntroduction(String videoIntroduction) {
        this.videoIntroduction = videoIntroduction;
    }
}
