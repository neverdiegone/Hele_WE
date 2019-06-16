package helen.com.we.model;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("id")
    private Integer id;
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
