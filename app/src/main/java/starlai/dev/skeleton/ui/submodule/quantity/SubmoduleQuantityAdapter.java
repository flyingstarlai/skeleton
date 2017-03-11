package starlai.dev.skeleton.ui.submodule.quantity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.Quantity;
import starlai.dev.skeleton.data.local.Submodule;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by izayoi on 3/8/17.
 */

public class SubmoduleQuantityAdapter extends RecyclerView.Adapter<SubmoduleQuantityAdapter.ViewHolder> {

    private List<Quantity> quantities;

    public SubmoduleQuantityAdapter(List<Quantity> quantities) {
        this.quantities = quantities;
    }

    @Override
    public SubmoduleQuantityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_submodule_quantity_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(SubmoduleQuantityAdapter.ViewHolder holder, int position) {
        final Quantity quantity = quantities.get(position);

        holder.quantityId.setText(String.valueOf(quantity.getId()));
        holder.name.setText(quantity.getName());
        holder.monthly.setText(String.valueOf(quantity.getMonthly()));
        holder.yearly.setText(String.valueOf(quantity.getYearly()));

    }

    @Override
    public int getItemCount() {
        return (quantities != null)? quantities.size() : 0;
    }

    public void refreshData(List<Quantity> quantities) {
        this.quantities = checkNotNull(quantities);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_quantity_id)
        TextView quantityId;
        @BindView(R.id.tv_quantity_name)
        TextView name;
        @BindView(R.id.tv_quantity_monthly)
        TextView monthly;
        @BindView(R.id.tv_quantity_yearly)
        TextView yearly;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
