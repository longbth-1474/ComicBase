package longhoang.com.comicbase.data.model.api.detail.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailCategoryBody {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("page")
    @Expose
    private Integer page;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public DetailCategoryBody(String url, Integer page) {
        this.url = url;
        this.page = page;
    }
}
