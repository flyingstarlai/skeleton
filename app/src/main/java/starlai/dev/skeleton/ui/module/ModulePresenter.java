package starlai.dev.skeleton.ui.module;

import java.util.List;

import javax.inject.Inject;

import starlai.dev.skeleton.core.SkeletonApplication;
import starlai.dev.skeleton.data.local.Module;
import starlai.dev.skeleton.data.local.Submodule;

/**
 * Created by izayoi on 3/8/17.
 */

public class ModulePresenter implements ModuleContract.Presenter {

    private final ModuleContract.View view;
    @Inject ModuleContract.Repository repository;

    public ModulePresenter(ModuleContract.View view) {
        this.view = view;
        SkeletonApplication.getInstance().getAppComponent().inject(this);
    }



    @Override
    public void loadModules() {

        List<Module> modules = repository.getAllModules();

        if(modules.size() > 0) {
            view.hideEmptyText();
            view.showModules(modules);
        } else
            view.showEmptyText();
    }

}
