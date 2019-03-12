package longhoang.com.comicbase.data.model.api.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("urlComic")
    @Expose
    private String urlComic;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlComic() {
        return urlComic;
    }

    public void setUrlComic(String urlComic) {
        this.urlComic = urlComic;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
