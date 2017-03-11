package starlai.dev.skeleton.ui.submodule.quantity;

import java.util.List;

import starlai.dev.skeleton.data.local.Quantity;
import starlai.dev.skeleton.data.local.Submodule;

/**
 * Created by izayoi on 3/8/17.
 */

public interface SubmoduleQuantityContract {

    interface View {
        void showQuantities(List<Quantity> quantities);
        void showSnackbar(String message);
        void showProgressIndicator(boolean show, String title, String message);
        void showEmptyText();
        void hideEmptyText();

    }

    interface Presenter {
        void loadSubmoduleQuantities();

    }

    public interface Repository {
        List<Quantity> getAllSubmoduleQuantities();

    }
}
