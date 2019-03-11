package longhoang.com.comicbase.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import longhoang.com.comicbase.BAnkApp;
import longhoang.com.comicbase.di.builder.ActivityBuilder;
import longhoang.com.comicbase.di.module.AppModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    void inject(BAnkApp app);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application app);
        AppComponent build();
    }
}
