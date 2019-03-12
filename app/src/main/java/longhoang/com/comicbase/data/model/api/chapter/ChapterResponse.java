package longhoang.com.comicbase.data.model.api.chapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterResponse {
    @SerializedName("Chapter")
    @Expose
    private ChapterAPI chapter;

    public ChapterAPI getChapter() {
        return chapter;
    }

    public void setChapter(ChapterAPI chapter) {
        this.chapter = chapter;
    }
}

