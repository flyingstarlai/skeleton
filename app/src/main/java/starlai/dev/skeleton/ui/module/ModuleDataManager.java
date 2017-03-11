package starlai.dev.skeleton.ui.module;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import starlai.dev.skeleton.data.local.Module;
import starlai.dev.skeleton.data.local.Module;

/**
 * Created by izayoi on 3/8/17.
 */

public class ModuleDataManager implements ModuleContract.Repository {



    public ModuleDataManager(Context context) {}



    @Override
    public List<Module> getAllModules() {
        Module m1 = new Module(1, "Mod ARG", "Malaysia", "Cindailah mana tidak berkias");
        Module m2 = new Module(3, "Mod XCV", "Japan", "Kimi wa ima namida nagashita");
        Module m3 = new Module(5, "Mod CV8", "Germany", "Es ist wie das Spiel mit Bauklötzen");
        Module m4 = new Module(7, "Mod 98VC", "Spain", "Quiero respirar tu cuello despacito");
        Module m5 = new Module(9, "Mod ZYU", "Italy", "Ma il mio mistero è chiuso in me");


        List<Module> Modules = new ArrayList<>();
        Modules.add(m1);
        Modules.add(m2);
        Modules.add(m3);
        Modules.add(m4);
        Modules.add(m5);

        return Modules;
    }
}
