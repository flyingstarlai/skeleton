package starlai.dev.skeleton.ui.module;

import java.util.List;

import starlai.dev.skeleton.data.local.Module;
import starlai.dev.skeleton.data.local.Submodule;

/**
 * Created by izayoi on 3/8/17.
 */

public interface ModuleContract {

    interface View {
        void showModules(List<Module> modules);
        void showSnackbar(String message);
        void showProgressIndicator(boolean show, String title, String message);
        void showEmptyText();
        void hideEmptyText();

    }

    interface Presenter {
        void loadModules();

    }

    public interface Repository {
        List<Module> getAllModules();

    }
}
