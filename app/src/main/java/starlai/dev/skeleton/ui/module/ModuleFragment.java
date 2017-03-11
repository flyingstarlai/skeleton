package starlai.dev.skeleton.ui.module;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
import butterknife.OnClick;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.Module;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModuleFragment extends Fragment implements ModuleContract.View {

    private ModuleContract.Presenter presenter;
    private ModuleAdapter adapter;
    private View view;
    private ProgressDialog progressDialog;

    @BindView(R.id.rcv_module)
    RecyclerView recyclerView;
    @BindView(R.id.empty_text)TextView emptyText;


    public ModuleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_module, container, false);
        ButterKnife.bind(this, view);
        presenter = new ModulePresenter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        List<Module> tempModules = new ArrayList<>();
        adapter = new ModuleAdapter(tempModules);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.loadModules();
    }

    @OnClick(R.id.fab_start_machine) void startMachine () {
        showSnackbar("Starting the Machine...");
    }
    @Override
    public void showModules(List<Module> modules) {
        adapter.refreshData(modules);
    }

    @Override
    public void showSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.md_brown_500));
        snackbar.setAction("Actions", null).show();

    }

    @Override
    public void showProgressIndicator(boolean show, String title, String message) {

    }

    @Override
    public void showEmptyText() {

    }

    @Override
    public void hideEmptyText() {

    }
}
