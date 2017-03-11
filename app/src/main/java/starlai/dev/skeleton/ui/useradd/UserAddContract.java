package starlai.dev.skeleton.ui.useradd;

import java.util.List;

import starlai.dev.skeleton.core.listener.OnDatabaseOperationCompleteListener;
import starlai.dev.skeleton.data.local.User;

/**
 * Created by izayoi on 3/8/17.
 */

public interface UserAddContract {

    interface View {
        void showSnackbar(String message);
        void showProgressIndicator(boolean show, String title, String message);
        void showEmptyText();
        void hideEmptyText();

    }

    interface Presenter {
        void loadUsers();

    }

    public interface Repository {
        void createNewUser(User user, OnDatabaseOperationCompleteListener listener);
    }
}
