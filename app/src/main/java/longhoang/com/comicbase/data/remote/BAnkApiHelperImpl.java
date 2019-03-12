package longhoang.com.comicbase.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import longhoang.com.comicbase.data.model.api.BlogResponse;
import longhoang.com.comicbase.data.model.api.chapter.ChapterBody;
import longhoang.com.comicbase.data.model.api.chapter.ChapterResponse;
import longhoang.com.comicbase.data.model.api.comic.ComicBody;
import longhoang.com.comicbase.data.model.api.comic.ComicResponse;
import longhoang.com.comicbase.data.model.api.home.HomeResponse;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Singleton
public class BAnkApiHelperImpl implements BAnkApiHelper {
    @Inject
    public BAnkApiHelperImpl() {
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(BAnkApiEndPoint.ENDPOINT_BLOG)
            .build()
            .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<HomeResponse> getHomeApiCall() {
        return Rx2AndroidNetworking.get(BAnkApiEndPoint.ENDPOINT_HOME)
            .build()
            .getObjectSingle(HomeResponse.class);
    }

    @Override
    public Single<ComicResponse> getComicApiCall(ComicBody comicBody) {
        return Rx2AndroidNetworking.post(BAnkApiEndPoint.ENDPOINT_DETAIL_COMIC)
            .addBodyParameter(comicBody).build().getObjectSingle(ComicResponse.class);
    }

    @Override
    public Single<ChapterResponse> getChapterApiCall(ChapterBody chapterBody) {
        return Rx2AndroidNetworking.post(BAnkApiEndPoint.ENDPOINT_CHAPTER)
            .addBodyParameter(chapterBody).build().getObjectSingle(ChapterResponse.class);
    }
}
