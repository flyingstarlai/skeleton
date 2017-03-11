package starlai.dev.skeleton.ui.submodule.view;

import java.util.List;

import starlai.dev.skeleton.data.local.Submodule;

/**
 * Created by izayoi on 3/8/17.
 */

public interface SubmoduleContract {

    interface View {
        void showSubmodules(List<Submodule> submodules);
        void showSnackbar(String message);
        void showProgressIndicator(boolean show, String title, String message);
        void showEmptyText();
        void hideEmptyText();

    }

    interface Presenter {
        void loadSubmodules();

    }

    public interface Repository {
        List<Submodule> getAllSubmodules();

    }
}
