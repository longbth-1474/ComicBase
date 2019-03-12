package longhoang.com.comicbase.data.model.api.comic;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chapter implements Parcelable {
    @SerializedName("titleChapter")
    @Expose
    private String titleChapter;
    @SerializedName("timeChapter")
    @Expose
    private String timeChapter;
    @SerializedName("urlChapter")
    @Expose
    private String urlChapter;
    @SerializedName("_id")
    @Expose
    private String id;

    private Chapter(Parcel in) {
        titleChapter = in.readString();
        timeChapter = in.readString();
        urlChapter = in.readString();
        id = in.readString();
    }

    public static final Creator<Chapter> CREATOR = new Creator<Chapter>() {
        @Override
        public Chapter createFromParcel(Parcel in) {
            return new Chapter(in);
        }

        @Override
        public Chapter[] newArray(int size) {
            return new Chapter[size];
        }
    };

    public String getTitleChapter() {
        return titleChapter;
    }

    public void setTitleChapter(String titleChapter) {
        this.titleChapter = titleChapter;
    }

    public String getTimeChapter() {
        return timeChapter;
    }

    public void setTimeChapter(String timeChapter) {
        this.timeChapter = timeChapter;
    }

    public String getUrlChapter() {
        return urlChapter;
    }

    public void setUrlChapter(String urlChapter) {
        this.urlChapter = urlChapter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleChapter);
        dest.writeString(timeChapter);
        dest.writeString(urlChapter);
        dest.writeString(id);
    }
}
