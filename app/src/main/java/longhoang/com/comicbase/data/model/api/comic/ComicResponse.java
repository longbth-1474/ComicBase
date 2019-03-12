package longhoang.com.comicbase.data.model.api.comic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicResponse {
    @SerializedName("Comic")
    @Expose
    private ComicDetail comic;

    public ComicDetail getComic() {
        return comic;
    }

    public void setComic(ComicDetail comic) {
        this.comic = comic;
    }
}
