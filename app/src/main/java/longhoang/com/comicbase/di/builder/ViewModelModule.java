package longhoang.com.comicbase.di.builder;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import longhoang.com.comicbase.di.BAnkViewModelFactory;
import longhoang.com.comicbase.di.ViewModelKey;
import longhoang.com.comicbase.ui.MainViewModel;
import longhoang.com.comicbase.ui.category.CategoriesViewModel;
import longhoang.com.comicbase.ui.home.HomeViewModel;
import longhoang.com.comicbase.ui.user.UserViewModel;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BAnkViewModelFactory factory);
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);
    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel.class)
    abstract ViewModel bindCategoriesViewModel(CategoriesViewModel viewModel);
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel viewModel);
}