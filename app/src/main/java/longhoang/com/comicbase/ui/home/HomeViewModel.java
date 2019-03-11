package longhoang.com.comicbase.ui.home;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import longhoang.com.comicbase.core.BaseViewModel;
import longhoang.com.comicbase.data.model.api.home.NewUpdate;
import longhoang.com.comicbase.data.model.api.home.Proposal;

public class HomeViewModel extends BaseViewModel {

    MutableLiveData<List<Proposal>> mProposalLiveData = new MutableLiveData<>();
    MutableLiveData<List<NewUpdate>> mNewUpdateLiveData = new MutableLiveData<>();

    @Inject
    public HomeViewModel() {
    }

    public HomeNavigator mHomeNavigator;

    public HomeNavigator getHomeNavigator() {
        return mHomeNavigator;
    }

    public void setHomeNavigator(HomeNavigator homeNavigator) {
        mHomeNavigator = homeNavigator;
    }

    public void fetchHome() {
        getCompositeDisposable().add(repository
                .getHomeApiCall()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(disposable -> showProgressDialog(true))
                .doAfterTerminate(() -> showProgressDialog(false))
                .subscribe(homeResponse -> {
                    if (homeResponse != null && homeResponse.getHome() != null) {
                        mProposalLiveData.postValue(homeResponse.getHome().getProposal());
                        mNewUpdateLiveData.postValue(homeResponse.getHome().getNewUpdate());
                    }
                }, throwable -> {

                })
        );
    }
}
