package longhoang.com.comicbase.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comic implements Parcelable {
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
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("warning")
    @Expose
    private Integer warning;

    public Comic(String urlImage, String title, String time, String chapter, String url,
                 String id) {
        this.urlImage = urlImage;
        this.title = title;
        this.time = time;
        this.chapter = chapter;
        this.url = url;
        this.id = id;
    }

    protected Comic(Parcel in) {
        urlImage = in.readString();
        title = in.readString();
        time = in.readString();
        chapter = in.readString();
        url = in.readString();
        id = in.readString();
        if (in.readByte() == 0) {
            warning = null;
        } else {
            warning = in.readInt();
        }
    }

    public static final Creator<Comic> CREATOR = new Creator<Comic>() {
        @Override
        public Comic createFromParcel(Parcel in) {
            return new Comic(in);
        }

        @Override
        public Comic[] newArray(int size) {
            return new Comic[size];
        }
    };

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWarning() {
        return warning;
    }

    public void setWarning(Integer warning) {
        this.warning = warning;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlImage);
        dest.writeString(title);
        dest.writeString(time);
        dest.writeString(chapter);
        dest.writeString(url);
        dest.writeString(id);
        if (warning == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(warning);
        }
    }
}
