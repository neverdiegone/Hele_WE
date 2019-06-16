package helen.com.we.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataSchedules {
    @SerializedName("date")
    private String date;
    @SerializedName("schedules")
    private List<Schedule> schedules = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
