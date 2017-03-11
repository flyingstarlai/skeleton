package starlai.dev.skeleton.core.injection.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import starlai.dev.skeleton.data.remote.ApiService;

/**
 * Created by izayoi on 11/22/2016.
 */

@Module
public class ApiServiceModule {

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit.Builder retrofit) {
        return retrofit.build().create(ApiService.class);
    }
}
