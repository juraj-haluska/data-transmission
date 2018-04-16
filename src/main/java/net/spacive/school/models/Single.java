package net.spacive.school.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class Single<T> {

    @JsonProperty("data")
    public T data;

    public Single<T> withData(T data) {
        this.data = data;
        return this;
    }
}