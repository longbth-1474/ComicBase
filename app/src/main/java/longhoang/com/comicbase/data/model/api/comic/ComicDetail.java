package longhoang.com.comicbase.data.model.api.comic;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicDetail implements Parcelable {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("titleOther")
    @Expose
    private String titleOther;
    @SerializedName("timeUpdate")
    @Expose
    private String timeUpdate;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("viewer")
    @Expose
    private String viewer;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("chapters")
    @Expose
    private List<Chapter> chapters = null;

    protected ComicDetail(Parcel in) {
        id = in.readString();
        url = in.readString();
        image = in.readString();
        title = in.readString();
        titleOther = in.readString();
        timeUpdate = in.readString();
        author = in.readString();
        type = in.readString();
        status = in.readString();
        viewer = in.readString();
        content = in.readString();
        if (in.readByte() == 0) {
            v = null;
        } else {
            v = in.readInt();
        }
        chapters = in.createTypedArrayList(Chapter.CREATOR);
    }

    public static final Creator<ComicDetail> CREATOR = new Creator<ComicDetail>() {
        @Override
        public ComicDetail createFromParcel(Parcel in) {
            return new ComicDetail(in);
        }

        @Override
        public ComicDetail[] newArray(int size) {
            return new ComicDetail[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleOther() {
        return titleOther;
    }

    public void setTitleOther(String titleOther) {
        this.titleOther = titleOther;
    }

    public String getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViewer() {
        return viewer;
    }

    public void setViewer(String viewer) {
        this.viewer = viewer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(image);
        dest.writeString(title);
        dest.writeString(titleOther);
        dest.writeString(timeUpdate);
        dest.writeString(author);
        dest.writeString(type);
        dest.writeString(status);
        dest.writeString(viewer);
        dest.writeString(content);
        if (v == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(v);
        }
        dest.writeTypedList(chapters);
    }
}
