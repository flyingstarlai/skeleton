package starlai.dev.skeleton.ui.submodule.view;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import starlai.dev.skeleton.data.local.Submodule;

/**
 * Created by izayoi on 3/8/17.
 */

public class SubmoduleDataManager implements SubmoduleContract.Repository {



    public SubmoduleDataManager(Context context) {}



    @Override
    public List<Submodule> getAllSubmodules() {
        Submodule sm1 = new Submodule(101, "Sub VISD8", "Bold Iron", 3200);
        Submodule sm2 = new Submodule(105, "Sub XCV9", "Fruity Juicy", 2000);
        Submodule sm3 = new Submodule(109, "SUb XCV5", "Bad Crocodile", 2500);
        Submodule sm4 = new Submodule(113, "Sub TYUR1", "Tiny Silver", 1200);
        Submodule sm5 = new Submodule(124, "Sub MMA89", "Red Fury", 2800);
        Submodule sm6 = new Submodule(127, "Sub QQR1", "Dark Chain", 3200);


        List<Submodule> submodules = new ArrayList<>();
        submodules.add(sm1);
        submodules.add(sm2);
        submodules.add(sm3);
        submodules.add(sm4);
        submodules.add(sm5);
        submodules.add(sm6);

        return submodules;
    }
}
