package net.spacive.school.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class User {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("job")
    @Expose
    public String job;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("createdAt")
    @Expose
    public String createdAt;
    @SerializedName("updatedAt")
    @Expose
    public String updatedAt;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("job", job)
                .append("id", id)
                .append("createdAt", createdAt)
                .append("updatedAt", updatedAt)
                .toString();
    }

}