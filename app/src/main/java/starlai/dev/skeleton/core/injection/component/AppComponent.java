package starlai.dev.skeleton.core.injection.component;

import javax.inject.Singleton;


import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import starlai.dev.skeleton.common.MainActivity;
import starlai.dev.skeleton.core.injection.module.ApiServiceModule;
import starlai.dev.skeleton.core.injection.module.AppModule;
import starlai.dev.skeleton.core.injection.module.NetModule;
import starlai.dev.skeleton.core.injection.module.PersistenceModule;
import starlai.dev.skeleton.data.local.Module;
import starlai.dev.skeleton.data.remote.ServiceInterceptor;
import starlai.dev.skeleton.ui.module.ModulePresenter;
import starlai.dev.skeleton.ui.submodule.quantity.SubmoduleQuantityPresenter;
import starlai.dev.skeleton.ui.submodule.view.SubmodulePresenter;
import starlai.dev.skeleton.ui.user.UserPresenter;

/**
 * Created by izayoi on 11/9/2016.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                NetModule.class,
                PersistenceModule.class,
                ApiServiceModule.class
    }
)

public interface AppComponent {

    void inject(MainActivity view);

    void inject(UserPresenter view);

    void inject(SubmodulePresenter view);

    void inject(SubmoduleQuantityPresenter view);

    void inject(ModulePresenter view);

    Retrofit.Builder retrofit();
    OkHttpClient okHttpClient();
    ServiceInterceptor interceptor();


}
