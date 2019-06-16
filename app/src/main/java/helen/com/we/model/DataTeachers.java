package helen.com.we.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataTeachers {
    @SerializedName("date")
    private String date;
    @SerializedName("teachers")
    private List<Teacher> teachers = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
