package starlai.dev.skeleton.ui.module;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.Module;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by izayoi on 3/8/17.
 */

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {

    private List<Module> modules;

    public ModuleAdapter(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public ModuleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_module_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ModuleAdapter.ViewHolder holder, int position) {
        final Module module = modules.get(position);

        holder.moduleId.setText(String.valueOf(module.getId()));
        holder.name.setText(module.getName());
        holder.location.setText(module.getLocation());
        holder.description.setText(String.valueOf(module.getDescription()));

    }

    @Override
    public int getItemCount() {
        return (modules != null)? modules.size() : 0;
    }

    public void refreshData(List<Module> Modules) {
        this.modules = checkNotNull(Modules);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_module_id)
        TextView moduleId;
        @BindView(R.id.tv_module_name)
        TextView name;
        @BindView(R.id.tv_module_location)
        TextView location;
        @BindView(R.id.tv_module_description)
        TextView description;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
