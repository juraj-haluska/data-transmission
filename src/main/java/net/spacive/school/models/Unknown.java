package net.spacive.school.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "year",
        "color",
        "pantone_value"
})
public class Unknown {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("year")
    public Integer year;
    @JsonProperty("color")
    public String color;
    @JsonProperty("pantone_value")
    public String pantoneValue;

    public Unknown withId(Integer id) {
        this.id = id;
        return this;
    }

    public Unknown withName(String name) {
        this.name = name;
        return this;
    }

    public Unknown withYear(Integer year) {
        this.year = year;
        return this;
    }

    public Unknown withColor(String color) {
        this.color = color;
        return this;
    }

    public Unknown withPantoneValue(String pantoneValue) {
        this.pantoneValue = pantoneValue;
        return this;
    }

}
