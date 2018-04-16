package net.spacive.school.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "per_page",
        "total",
        "total_pages",
        "data"
})
public class Page<T> {

    @JsonProperty("page")
    public Integer page;
    @JsonProperty("per_page")
    public Integer perPage;
    @JsonProperty("total")
    public Integer total;
    @JsonProperty("total_pages")
    public Integer totalPages;
    @JsonProperty("data")
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

    public Page withPage(Integer page) {
        this.page = page;
        return this;
    }

    public Page withPerPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    public Page withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Page withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Page withData(List<T> data) {
        this.data = data;
        return this;
    }
}