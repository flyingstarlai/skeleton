package starlai.dev.skeleton.ui.dashboard;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.common.MainActivity;
import starlai.dev.skeleton.data.local.Submodule;
import starlai.dev.skeleton.ui.submodule.view.SubmoduleAdapter;
import starlai.dev.skeleton.ui.submodule.view.SubmodulePresenter;
import starlai.dev.skeleton.ui.user.UserFragment;

/**
 * A simple {@link Fragment} subclass.

 */
public class DashboardFragment extends Fragment {

    private View view;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.titleText)
    TextView titleText;

    @BindView(R.id.titleText2)
    TextView titleText2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
//        titleText.setText("Dashboard Item");
//        titleText2.setText("Description");



        return view;
    }

    @OnClick(R.id.fab_goto_user) void gotoUser() {
        FragmentTransaction fragmentTransaction =  getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new UserFragment()).commit();
    }


    boolean doubleBackToExitPressedOnce = false;



}
