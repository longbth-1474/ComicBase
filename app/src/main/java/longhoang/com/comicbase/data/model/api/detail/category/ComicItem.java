package longhoang.com.comicbase.data.model.api.detail.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicItem {
    @SerializedName("urlImage")
    @Expose
    private String urlImage;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("chapter")
    @Expose
    private String chapter;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("warning")
    @Expose
    private Integer warning;
    @SerializedName("_id")
    @Expose
    private String id;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWarning() {
        return warning;
    }

    public void setWarning(Integer warning) {
        this.warning = warning;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
