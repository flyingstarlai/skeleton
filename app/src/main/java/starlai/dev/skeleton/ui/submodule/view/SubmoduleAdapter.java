package starlai.dev.skeleton.ui.submodule.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.Submodule;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by izayoi on 3/8/17.
 */

public class SubmoduleAdapter extends RecyclerView.Adapter<SubmoduleAdapter.ViewHolder> {

    private List<Submodule> submodules;

    public SubmoduleAdapter(List<Submodule> submodules) {
        this.submodules = submodules;
    }

    @Override
    public SubmoduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_submodule_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(SubmoduleAdapter.ViewHolder holder, int position) {
        final Submodule submodule = submodules.get(position);

        holder.submoduleId.setText(String.valueOf(submodule.getId()));
        holder.name.setText(submodule.getName());
        holder.storage.setText(submodule.getStorage());
        holder.capacity.setText(String.valueOf(submodule.getCapacity()));

    }

    @Override
    public int getItemCount() {
        return (submodules != null)? submodules.size() : 0;
    }

    public void refreshData(List<Submodule> submodules) {
        this.submodules = checkNotNull(submodules);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_submodule_id)
        TextView submoduleId;
        @BindView(R.id.tv_submodule_name)
        TextView name;
        @BindView(R.id.tv_submodule_storage)
        TextView storage;
        @BindView(R.id.tv_submodule_capacity)
        TextView capacity;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
