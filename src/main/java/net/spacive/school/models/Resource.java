package net.spacive.school.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Resource {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("year")
    @Expose
    public Integer year;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("pantone_value")
    @Expose
    public String pantoneValue;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("year", year)
                .append("color", color)
                .append("pantoneValue", pantoneValue)
                .toString();
    }

}