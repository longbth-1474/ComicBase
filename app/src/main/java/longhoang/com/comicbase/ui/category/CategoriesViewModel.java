package longhoang.com.comicbase.ui.category;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import longhoang.com.comicbase.core.BaseViewModel;
import longhoang.com.comicbase.data.model.api.category.Category;

public class CategoriesViewModel extends BaseViewModel {

    MutableLiveData<List<Category>> mListMutableLiveData = new MutableLiveData<>();

    @Inject
    public CategoriesViewModel() {
    }

    public void fetchCategories() {
        getCompositeDisposable().add(repository
            .getCategoriesApiCall()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe(disposable -> showProgressDialog(true))
            .doAfterTerminate(() -> showProgressDialog(false))
            .subscribe(categoryResponse -> {
                if (categoryResponse != null && categoryResponse.getCategories() != null) {
                    mListMutableLiveData.postValue(categoryResponse.getCategories());
                }
            }, throwable -> {
            })
        );
    }
}
