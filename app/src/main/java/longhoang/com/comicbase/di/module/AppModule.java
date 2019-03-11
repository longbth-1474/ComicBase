package longhoang.com.comicbase.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import longhoang.com.comicbase.data.BAnkRepository;
import longhoang.com.comicbase.data.BAnkRepositoryImpl;
import longhoang.com.comicbase.data.local.db.BAnkDBHelper;
import longhoang.com.comicbase.data.local.db.BAnkDBHelperImpl;
import longhoang.com.comicbase.data.local.db.BAnkDatabase;
import longhoang.com.comicbase.data.remote.BAnkApiHelper;
import longhoang.com.comicbase.data.remote.BAnkApiHelperImpl;
import longhoang.com.comicbase.di.ApiInfo;
import longhoang.com.comicbase.di.DatabaseInfo;
import longhoang.com.comicbase.di.builder.ViewModelModule;
import longhoang.com.comicbase.utils.AppConstants;
import longhoang.com.comicbase.utils.ConfigManager;
import longhoang.com.comicbase.utils.rx.AppSchedulerProvider;
import longhoang.com.comicbase.utils.rx.SchedulerProvider;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Module(includes = {ViewModelModule.class})
public class AppModule {
    @Provides
    @Singleton
    BAnkApiHelper provideBAnkApiHelper(BAnkApiHelperImpl apiHelper) {
        return apiHelper;
    }

    @Provides
    @Singleton
    BAnkDBHelper provideBAnkDBHelper(BAnkDBHelperImpl dbHelper) {
        return dbHelper;
    }

    @Provides
    @Singleton
    BAnkRepository provideBAnkRepository(BAnkRepositoryImpl repository) {
        return repository;
    }

    //API KEY
    @Provides
    @ApiInfo
    String provideApiKey() {
        return "";
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    BAnkDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, BAnkDatabase.class, dbName)
            .fallbackToDestructiveMigration()
            .build();
    }
// Need When Custom Font
//    @Provides
//    @Singleton
//    CalligraphyConfig provideCalligraphyDefaultConfig() {
//        return new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build();
//    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    ConfigManager provideConfigManager(Context ctx) {
        return new ConfigManager(ctx);
    }
}
