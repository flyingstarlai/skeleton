package starlai.dev.skeleton.ui.submodule.quantity;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import starlai.dev.skeleton.data.local.Quantity;
import starlai.dev.skeleton.data.local.Submodule;

/**
 * Created by izayoi on 3/8/17.
 */

public class SubmoduleQuantityDataManager implements SubmoduleQuantityContract.Repository {



    public SubmoduleQuantityDataManager(Context context) {}



    @Override
    public List<Quantity> getAllSubmoduleQuantities() {
        Quantity q1 = new Quantity(11, "Arabica", 200, 2800);
        Quantity q2 = new Quantity(12, "Gayo", 120, 600);
        Quantity q3 = new Quantity(13, "Lintong", 310, 500);
        Quantity q4 = new Quantity(14, "Robusta", 180, 1200);
        Quantity q5 = new Quantity(15, "Jawa", 260, 4100);

        List<Quantity> quantities = new ArrayList<>();
        quantities.add(q1);
        quantities.add(q2);
        quantities.add(q3);
        quantities.add(q4);
        quantities.add(q5);

        return quantities;
    }
}
