package longhoang.com.comicbase.di.builder;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import longhoang.com.comicbase.ui.category.CategoryFragment;
import longhoang.com.comicbase.ui.home.HomeFragment;
import longhoang.com.comicbase.ui.user.UserFragment;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract HomeFragment provideHomeFragment();
    @ContributesAndroidInjector
    abstract CategoryFragment provideCategoryFragment();
    @ContributesAndroidInjector
    abstract UserFragment provideUserFragment();
}
