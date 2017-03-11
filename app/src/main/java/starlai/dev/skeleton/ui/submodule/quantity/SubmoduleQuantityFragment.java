package starlai.dev.skeleton.ui.submodule.quantity;


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
import starlai.dev.skeleton.data.local.Quantity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubmoduleQuantityFragment extends Fragment implements SubmoduleQuantityContract.View {
    private SubmoduleQuantityContract.Presenter presenter;
    private SubmoduleQuantityAdapter adapter;
    private View view;
    private ProgressDialog progressDialog;

    @BindView(R.id.rcv_submodule_quantity)
    RecyclerView recycleView;
    @BindView(R.id.empty_text)TextView emptyText;

    public SubmoduleQuantityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab_submodule_quantity, container, false);
        ButterKnife.bind(this, view);
        presenter = new SubmoduleQuantityPresenter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        List<Quantity> tempQuantities = new ArrayList<>();
        adapter = new SubmoduleQuantityAdapter(tempQuantities);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadSubmoduleQuantities();
    }

    @Override
    public void showQuantities(List<Quantity> quantities) {
        adapter.refreshData(quantities);

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
        recycleView.setVisibility(View.GONE);
    }

    @Override
    public void hideEmptyText() {
        emptyText.setVisibility(View.GONE);
        recycleView.setVisibility(View.VISIBLE);
    }
}
