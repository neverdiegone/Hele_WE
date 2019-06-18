package helen.com.we.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleList {
    @SerializedName("schedule")
    List<DataTeachers> dataTeachersList;
    @SerializedName("week_index")
    private int week_index;

    public List<DataTeachers> getDataTeachersList() {
        return dataTeachersList;
    }

    public void setDataTeachersList(List<DataTeachers> dataTeachersList) {
        this.dataTeachersList = dataTeachersList;
    }

    public int getWeek_index() {
        return week_index;
    }

    public void setWeek_index(int week_index) {
        this.week_index = week_index;
    }
}
