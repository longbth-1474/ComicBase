package longhoang.com.comicbase.data.model.api.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Home {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("urlHome")
    @Expose
    private String urlHome;
    @SerializedName("newUpdate")
    @Expose
    private List<NewUpdate> newUpdate = null;
    @SerializedName("proposal")
    @Expose
    private List<Proposal> proposal = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlHome() {
        return urlHome;
    }

    public void setUrlHome(String urlHome) {
        this.urlHome = urlHome;
    }

    public List<NewUpdate> getNewUpdate() {
        return newUpdate;
    }

    public void setNewUpdate(List<NewUpdate> newUpdate) {
        this.newUpdate = newUpdate;
    }

    public List<Proposal> getProposal() {
        return proposal;
    }

    public void setProposal(List<Proposal> proposal) {
        this.proposal = proposal;
    }
}
