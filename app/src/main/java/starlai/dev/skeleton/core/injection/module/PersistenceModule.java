package starlai.dev.skeleton.core.injection.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import starlai.dev.skeleton.ui.module.ModuleContract;
import starlai.dev.skeleton.ui.module.ModuleDataManager;
import starlai.dev.skeleton.ui.submodule.quantity.SubmoduleQuantityContract;
import starlai.dev.skeleton.ui.submodule.quantity.SubmoduleQuantityDataManager;
import starlai.dev.skeleton.ui.submodule.view.SubmoduleContract;
import starlai.dev.skeleton.ui.submodule.view.SubmoduleDataManager;
import starlai.dev.skeleton.ui.user.UserContract;
import starlai.dev.skeleton.ui.user.UserDataManager;


/**
 * Created by izayoi on 12/2/2016.
 */

@Module
public class PersistenceModule {

    @Provides
    public UserContract.Repository provideUserRepository(Context context) {
        return new UserDataManager(context);
    }

    @Provides
    public SubmoduleContract.Repository provideSubmoduleRepository(Context context) {
        return new SubmoduleDataManager(context);
    }

    @Provides
    public SubmoduleQuantityContract.Repository provideSubmoduleQuantityRepository(Context context) {
        return new SubmoduleQuantityDataManager(context);
    }

    @Provides
    public ModuleContract.Repository provideModuleRepository(Context context) {
        return new ModuleDataManager(context);
    }
}
