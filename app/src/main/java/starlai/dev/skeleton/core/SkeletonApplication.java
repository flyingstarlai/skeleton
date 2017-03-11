package starlai.dev.skeleton.core;

import android.app.Application;

import starlai.dev.skeleton.core.injection.component.AppComponent;
import starlai.dev.skeleton.core.injection.component.DaggerAppComponent;
import starlai.dev.skeleton.core.injection.module.ApiServiceModule;
import starlai.dev.skeleton.core.injection.module.AppModule;
import starlai.dev.skeleton.core.injection.module.NetModule;
import starlai.dev.skeleton.core.injection.module.PersistenceModule;

/**
 * Created by izayoi on 3/7/17.
 */

public class SkeletonApplication extends Application {


    private static AppComponent appComponent;
    private static SkeletonApplication instance = new SkeletonApplication();


    public static SkeletonApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent =  DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .netModule(new NetModule("http://jiachenlong.no-ip.org/"))
                    .apiServiceModule(new ApiServiceModule())
                    .persistenceModule(new PersistenceModule())
                    .build();

        }
        return appComponent;
    }


}
