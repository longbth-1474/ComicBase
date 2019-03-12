package longhoang.com.comicbase.data.model.api.detail.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailCategoryResponse {
    @SerializedName("Comics")
    @Expose
    private ComicsCategory comics;

    public ComicsCategory getComics() {
        return comics;
    }

    public void setComics(ComicsCategory comics) {
        this.comics = comics;
    }
}
