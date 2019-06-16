package helen.com.we.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleList {
    @SerializedName("schedule")
    List<DataTeachers> dataTeachersList;

    public List<DataTeachers> getDataTeachersList() {
        return dataTeachersList;
    }

    public void setDataTeachersList(List<DataTeachers> dataTeachersList) {
        this.dataTeachersList = dataTeachersList;
    }
}
