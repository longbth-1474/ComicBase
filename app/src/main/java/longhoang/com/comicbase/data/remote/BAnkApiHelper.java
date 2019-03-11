package longhoang.com.comicbase.data.remote;


import io.reactivex.Single;
import longhoang.com.comicbase.data.model.api.BlogResponse;
import longhoang.com.comicbase.data.model.api.home.HomeResponse;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public interface BAnkApiHelper {
    Single<BlogResponse> getBlogApiCall();
    Single<HomeResponse> getHomeApiCall();
}