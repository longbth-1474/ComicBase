package longhoang.com.comicbase.data.model.api.comic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicBody {
    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ComicBody(String url) {
        this.url = url;
    }
}
