package starlai.dev.skeleton.ui.submodule.quantity;

import java.util.List;

import javax.inject.Inject;

import starlai.dev.skeleton.core.SkeletonApplication;
import starlai.dev.skeleton.data.local.Quantity;

/**
 * Created by izayoi on 3/8/17.
 */

public class SubmoduleQuantityPresenter implements SubmoduleQuantityContract.Presenter {

    private final SubmoduleQuantityContract.View view;
    @Inject SubmoduleQuantityContract.Repository repository;

    public SubmoduleQuantityPresenter(SubmoduleQuantityContract.View view) {
        this.view = view;
        SkeletonApplication.getInstance().getAppComponent().inject(this);
    }



    @Override
    public void loadSubmoduleQuantities() {

        List<Quantity> quantities = repository.getAllSubmoduleQuantities();

        if(quantities.size() > 0) {
            view.hideEmptyText();
            view.showQuantities(quantities);
        } else
            view.showEmptyText();
    }

}
