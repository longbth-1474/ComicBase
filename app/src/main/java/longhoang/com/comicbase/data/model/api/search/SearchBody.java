package longhoang.com.comicbase.data.model.api.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchBody {
    @SerializedName("keyword")
    @Expose
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public SearchBody(String keyword) {
        this.keyword = keyword;
    }
}
