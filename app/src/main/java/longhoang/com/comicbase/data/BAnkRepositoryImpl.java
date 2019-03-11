package longhoang.com.comicbase.data;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import longhoang.com.comicbase.data.local.db.BAnkDBHelper;
import longhoang.com.comicbase.data.model.api.BlogResponse;
import longhoang.com.comicbase.data.model.api.home.HomeResponse;
import longhoang.com.comicbase.data.remote.BAnkApiHelper;
import longhoang.com.comicbase.utils.ConfigManager;


/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Singleton
public class BAnkRepositoryImpl implements BAnkRepository {
    private final Gson mGson;
    private final ConfigManager mConfig;
    private BAnkDBHelper mDbHelper;
    private Context mContext;
    private BAnkApiHelper mApiHelper;

    @Inject
    public BAnkRepositoryImpl(Context context, BAnkDBHelper dbHelper, BAnkApiHelper apiHelper,
                              Gson gson, ConfigManager config) {
        mContext = context;
        mDbHelper = dbHelper;
        mApiHelper = apiHelper;
        mGson = gson;
        mConfig = config;
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return mApiHelper.getBlogApiCall();
    }

    @Override
    public Single<HomeResponse> getHomeApiCall() {
        return mApiHelper.getHomeApiCall();
    }
}
