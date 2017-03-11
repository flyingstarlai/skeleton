package starlai.dev.skeleton.ui.submodule.view;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.Submodule;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubmoduleFragment extends Fragment implements SubmoduleContract.View{

    private SubmoduleContract.Presenter presenter;
    private SubmoduleAdapter adapter;
    private View view;
    private ProgressDialog progressDialog;

    @BindView(R.id.rcv_submodule) RecyclerView recyclerView;
    @BindView(R.id.empty_text)TextView emptyText;


    public SubmoduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab_submodule_list, container, false);
        ButterKnife.bind(this, view);
        presenter = new SubmodulePresenter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        List<Submodule> tempSubmodules = new ArrayList<>();
        adapter = new SubmoduleAdapter(tempSubmodules);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadSubmodules();
    }

    @Override
    public void showSubmodules(List<Submodule> submodules) {
        adapter.refreshData(submodules);
    }

    @Override
    public void showSnackbar(String message) {




    }

    @Override
    public void showProgressIndicator(boolean show, String title, String message) {

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
