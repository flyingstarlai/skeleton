package starlai.dev.skeleton.ui.useradd;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.User;
import starlai.dev.skeleton.ui.module.ModuleFragment;
import starlai.dev.skeleton.ui.user.UserFragment;


public class UserAddFragment extends Fragment implements UserAddContract.View {

    private UserAddContract.Presenter presenter;
    private View view;
    private ProgressDialog progressDialog;


    @BindView(R.id.rcv_user) RecyclerView recvUser;
    @BindView(R.id.empty_text)TextView emptyText;


    public UserAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadUsers();
    }


//    @OnClick(R.id.fab_add_user) void showAcaraFragment() {
//
//    }




    @Override
    public void showSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.md_blue_grey_500));
        snackbar.setAction("Actions", null).show();

    }

    @Override
    public void showProgressIndicator(boolean show, String title, String message) {
        if (show) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
            progressDialog.show();
        } else {
            LogUtils.d("progress dismiss");
            progressDialog.dismiss();
        }

    }

    @Override
    public void showEmptyText() {
        emptyText.setVisibility(View.VISIBLE);
        recvUser.setVisibility(View.GONE);

    }

    @Override
    public void hideEmptyText() {
        emptyText.setVisibility(View.GONE);
        recvUser.setVisibility(View.VISIBLE);
    }
}
