package longhoang.com.comicbase.data.model.api.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResponse {
    @SerializedName("Home")
    @Expose
    private Home home;

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "DataHome{" +
                "home=" + home +
                '}';
    }
}
