package longhoang.com.comicbase.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import longhoang.com.comicbase.ui.category.CategoryFragment;
import longhoang.com.comicbase.ui.chapter.ChapterFragment;
import longhoang.com.comicbase.ui.comic.ComicFragment;
import longhoang.com.comicbase.ui.home.HomeFragment;
import longhoang.com.comicbase.ui.search.SearchFragment;
import longhoang.com.comicbase.ui.user.UserFragment;

@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract HomeFragment provideHomeFragment();
    @ContributesAndroidInjector
    abstract CategoryFragment provideCategoryFragment();
    @ContributesAndroidInjector
    abstract UserFragment provideUserFragment();
    @ContributesAndroidInjector
    abstract ComicFragment provideComicFragment();
    @ContributesAndroidInjector
    abstract ChapterFragment provideChapterFragment();
    @ContributesAndroidInjector
    abstract SearchFragment provideSearchFragment();
}
