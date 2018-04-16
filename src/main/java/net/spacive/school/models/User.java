package net.spacive.school.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "job",
        "createdAt",
        "updatedAt"
})
public class User {

    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;
    @JsonProperty("createdAt")
    public String createdAt;
    @JsonProperty("updatedAt")
    public String updatedAt;

    public User withId(String id) {
        this.id = id;
        return this;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withJob(String job) {
        this.job = job;
        return this;
    }

    public User withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

}