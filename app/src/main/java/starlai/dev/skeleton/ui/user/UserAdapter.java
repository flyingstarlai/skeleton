package starlai.dev.skeleton.ui.user;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import starlai.dev.skeleton.R;
import starlai.dev.skeleton.data.local.User;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by izayoi on 3/8/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        final User user = users.get(position);

        holder.userId.setText(String.valueOf(user.getId()));
        holder.username.setText(user.getUsername());
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.email.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return (users != null)? users.size() : 0;
    }

    public void refreshData(List<User> users) {
        this.users = checkNotNull(users);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_user_id)
        TextView userId;
        @BindView(R.id.tv_username)
        TextView username;
        @BindView(R.id.tv_first_name)
        TextView firstName;
        @BindView(R.id.tv_last_name)
        TextView lastName;
        @BindView(R.id.tv_email)
        TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
