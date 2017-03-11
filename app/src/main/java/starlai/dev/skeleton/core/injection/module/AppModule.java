package starlai.dev.skeleton.core.injection.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import starlai.dev.skeleton.core.SkeletonApplication;

/**
 * Created by izayoi on 11/9/2016.
 */

@Module
public class AppModule {

    private final SkeletonApplication app;

    public AppModule(SkeletonApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public SkeletonApplication getApp() {
        return app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }
}