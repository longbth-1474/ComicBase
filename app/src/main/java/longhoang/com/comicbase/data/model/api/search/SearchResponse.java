package longhoang.com.comicbase.data.model.api.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponse {
    @SerializedName("Comics")
    @Expose
    private SearchComic comics;

    public SearchComic getComics() {
        return comics;
    }

    public void setComics(SearchComic comics) {
        this.comics = comics;
    }
}
