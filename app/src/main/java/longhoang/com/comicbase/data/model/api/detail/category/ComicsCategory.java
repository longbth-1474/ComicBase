package longhoang.com.comicbase.data.model.api.detail.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicsCategory {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("comics")
    @Expose
    private List<ComicItem> comics = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ComicItem> getComics() {
        return comics;
    }

    public void setComics(List<ComicItem> comics) {
        this.comics = comics;
    }
}
