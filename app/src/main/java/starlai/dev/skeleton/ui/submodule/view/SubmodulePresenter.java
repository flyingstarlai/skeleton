package starlai.dev.skeleton.ui.submodule.view;

import java.util.List;

import javax.inject.Inject;

import starlai.dev.skeleton.core.SkeletonApplication;
import starlai.dev.skeleton.data.local.Submodule;

/**
 * Created by izayoi on 3/8/17.
 */

public class SubmodulePresenter implements SubmoduleContract.Presenter {

    private final SubmoduleContract.View view;
    @Inject SubmoduleContract.Repository repository;

    public SubmodulePresenter(SubmoduleContract.View view) {
        this.view = view;
        SkeletonApplication.getInstance().getAppComponent().inject(this);
    }



    @Override
    public void loadSubmodules() {

        List<Submodule> submodules = repository.getAllSubmodules();

        if(submodules.size() > 0) {
            view.hideEmptyText();
            view.showSubmodules(submodules);
        } else
            view.showEmptyText();
    }

}
