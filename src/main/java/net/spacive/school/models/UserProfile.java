package net.spacive.school.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "first_name",
        "last_name",
        "avatar"
})
public class UserProfile {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("first_name")
    public String firstName;
    @JsonProperty("last_name")
    public String lastName;
    @JsonProperty("avatar")
    public String avatar;

    public UserProfile withId(Integer id) {
        this.id = id;
        return this;
    }

    public UserProfile withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserProfile withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserProfile withAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

}