package longhoang.com.comicbase.data.model.api.chapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterItem {
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("_id")
    @Expose
    private String id;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
