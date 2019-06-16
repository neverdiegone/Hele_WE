package helen.com.we.model;

import com.google.gson.annotations.SerializedName;

public class Schedule {
    @SerializedName("id")
    private Integer id;
    @SerializedName("start_at")
    private String startAt;
    @SerializedName("end_at")
    private String endAt;
    @SerializedName("lesson")
    private String lesson;
    @SerializedName("status")
    private String status;
    @SerializedName("lesson_memo")
    private String lessonMemo;
    @SerializedName("material")
    private String material;
    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("teacher")
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLessonMemo() {
        return lessonMemo;
    }

    public void setLessonMemo(String lessonMemo) {
        this.lessonMemo = lessonMemo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
