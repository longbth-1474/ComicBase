package longhoang.com.comicbase.data.model.api.chapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChapterAPI {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("urlChapter")
    @Expose
    private String urlChapter;
    @SerializedName("chapters")
    @Expose
    private List<ChapterItem> chapters = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlChapter() {
        return urlChapter;
    }

    public void setUrlChapter(String urlChapter) {
        this.urlChapter = urlChapter;
    }

    public List<ChapterItem> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterItem> chapters) {
        this.chapters = chapters;
    }
}
