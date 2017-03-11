package starlai.dev.skeleton.ui.user;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.User;
import starlai.dev.skeleton.ui.module.ModuleFragment;


public class UserFragment extends Fragment implements UserContract.View {

    private UserContract.Presenter presenter;
    private UserAdapter adapter;
    private View view;
    private ProgressDialog progressDialog;


    @BindView(R.id.rcv_user) RecyclerView recyclerView;
    @BindView(R.id.empty_text)TextView emptyText;


    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.INTERNET}, 1);
//            }
//        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        presenter = new UserPresenter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        List<User> tempUsers = new ArrayList<>();
        adapter = new UserAdapter(tempUsers);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadUsers();
    }

    @Override
    public void showUser(List<User> users) {
        adapter.refreshData(users);

    }

    @OnClick(R.id.fab_add_user) void showAcaraFragment() {
        showSnackbar("Checkin User...");
    }
    @OnClick(R.id.fab_goto_module) void gotoModule() {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new ModuleFragment()).commit();
    }


    @Override
    public void showSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.md_brown_500));
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
        recyclerView.setVisibility(View.GONE);

    }

    @Override
    public void hideEmptyText() {
        emptyText.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
