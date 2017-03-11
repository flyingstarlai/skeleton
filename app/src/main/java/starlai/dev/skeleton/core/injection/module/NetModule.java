package starlai.dev.skeleton.core.injection.module;

import com.apkfuns.logutils.LogUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import starlai.dev.skeleton.data.remote.ServiceInterceptor;

/**
 * Created by izayoi on 11/22/2016.
 */

@Module
public class NetModule {

    private String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    public ServiceInterceptor provideInterceptor() {
        return ServiceInterceptor.getInterceptor();
    }

    @Provides
    @Singleton
    public OkHttpClient provideClient(ServiceInterceptor interceptor) {

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return  okHttpClient;
    }

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit(OkHttpClient client) {
        LogUtils.d(baseUrl);
        Retrofit.Builder retrofit =  new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return retrofit;
    }


}
