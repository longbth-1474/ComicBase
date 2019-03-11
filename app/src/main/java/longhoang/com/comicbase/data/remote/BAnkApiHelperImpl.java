package longhoang.com.comicbase.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import longhoang.com.comicbase.data.model.api.BlogResponse;
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
}
