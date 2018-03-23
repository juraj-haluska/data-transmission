package net.spacive.school.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Single<T> {

    @SerializedName("data")
    @Expose
    public T data = null;
}
