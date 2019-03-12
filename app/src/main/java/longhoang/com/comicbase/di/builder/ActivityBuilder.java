package longhoang.com.comicbase.di.builder;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import longhoang.com.comicbase.ui.MainActivity;
import longhoang.com.comicbase.ui.detail.category.DetailCategoriesActivity;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {FragmentBuilder.class})
    abstract MainActivity bindMainActivity();
    @ContributesAndroidInjector(modules = {FragmentBuilder.class})
    abstract DetailCategoriesActivity bindDetailCategoriesActivity();
}
