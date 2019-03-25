package longhoang.com.comicbase.data.remote;

import io.reactivex.Single;
import longhoang.com.comicbase.data.model.api.BlogResponse;
import longhoang.com.comicbase.data.model.api.category.CategoryResponse;
import longhoang.com.comicbase.data.model.api.chapter.ChapterBody;
import longhoang.com.comicbase.data.model.api.chapter.ChapterResponse;
import longhoang.com.comicbase.data.model.api.comic.ComicBody;
import longhoang.com.comicbase.data.model.api.comic.ComicResponse;
import longhoang.com.comicbase.data.model.api.detail.category.DetailCategoryBody;
import longhoang.com.comicbase.data.model.api.detail.category.DetailCategoryResponse;
import longhoang.com.comicbase.data.model.api.home.HomeResponse;
import longhoang.com.comicbase.data.model.api.search.SearchBody;
import longhoang.com.comicbase.data.model.api.search.SearchResponse;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public interface BAnkApiHelper {
    Single<BlogResponse> getBlogApiCall();
    Single<HomeResponse> getHomeApiCall();
    Single<ComicResponse> getComicApiCall(ComicBody comicBody);
    Single<ChapterResponse> getChapterApiCall(ChapterBody chapterBody);
    Single<CategoryResponse> getCategoriesApiCall();
    Single<DetailCategoryResponse> getDetailCategoriesApiCall(
        DetailCategoryBody detailCategoryBody);
    Single<SearchResponse> getSearchApiCall(SearchBody searchBody);
}
