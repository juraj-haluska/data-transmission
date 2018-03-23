package net.spacive.school.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Page<T> {

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("data")
    @Expose
    public List<T> data = null;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("page", page)
                .append("perPage", perPage)
                .append("total", total)
                .append("totalPages", totalPages)
                .append("data", data).toString();
    }

}