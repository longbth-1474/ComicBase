package longhoang.com.comicbase.data.model.api.chapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterBody {
    @SerializedName("urlChapter")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChapterBody(String url) {
        this.url = url;
    }
}
