package starlai.dev.skeleton.ui.user;

import com.apkfuns.logutils.LogUtils;

import java.util.List;

import javax.inject.Inject;

import starlai.dev.skeleton.core.SkeletonApplication;
import starlai.dev.skeleton.data.local.User;
import starlai.dev.skeleton.ui.user.UserContract;

/**
 * Created by izayoi on 3/8/17.
 */

public class UserPresenter implements UserContract.Presenter {

    private final UserContract.View view;
    @Inject UserContract.Repository repository;

    public UserPresenter(UserContract.View view) {
        this.view = view;
        SkeletonApplication.getInstance().getAppComponent().inject(this);
    }



    @Override
    public void loadUsers() {

        List<User> users = repository.getAllUsers();
        LogUtils.d(users.toString());

        if(users.size() > 0) {
            view.hideEmptyText();
            view.showUser(users);
        } else
            view.showEmptyText();
    }

}
