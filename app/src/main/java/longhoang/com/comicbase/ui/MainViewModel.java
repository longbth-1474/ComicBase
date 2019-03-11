package longhoang.com.comicbase.ui;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import longhoang.com.comicbase.core.BaseViewModel;
import longhoang.com.comicbase.data.model.api.BlogResponse;

public class MainViewModel extends BaseViewModel {

    MutableLiveData<List<BlogResponse.Blog>> blogs = new MutableLiveData<>();

    @Inject
    public MainViewModel() {

    }

    public void fetchBlogs() {
        getCompositeDisposable().add(repository
                .getBlogApiCall()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(blogResponse -> {
                    if (blogResponse != null && blogResponse.getData() != null) {
                        blogs.postValue(blogResponse.getData());
                        Log.d("BLOG", "fetchBlogs: " + blogResponse.getStatusCode());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    //processError
                }));
    }

    public void fetchHome() {
        getCompositeDisposable().add(repository
                .getHomeApiCall()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(homeResponse -> {
                    if(homeResponse!=null && homeResponse.getHome()!=null){
                        Log.d("HOME", "fetchHome: " + homeResponse.getHome().getUrlHome());
                    }
                },throwable -> {

                })
        );
    }
}
