package starlai.dev.skeleton.ui.useradd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.apkfuns.logutils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import starlai.dev.skeleton.core.listener.OnDatabaseOperationCompleteListener;
import starlai.dev.skeleton.data.DatabaseHelper;
import starlai.dev.skeleton.data.local.User;
import starlai.dev.skeleton.utility.Constants;

/**
 * Created by izayoi on 3/8/17.
 */

public class UserAddDataManager implements UserAddContract.Repository {

    private DatabaseHelper dhHelper;
    private SQLiteDatabase database;

    public UserAddDataManager(Context context) {
        dhHelper = DatabaseHelper.newInstance(context);
        database = dhHelper.getWritableDatabase();

    }

    @Override
    public void createNewUser(User user, OnDatabaseOperationCompleteListener listener) {
        if (database != null) {
            ContentValues values = new ContentValues();

            values.put(Constants.COL_USERNAME, user.getUsername());
            values.put(Constants.COL_FIRST_NAME, user.getFirstName());
            values.put(Constants.COL_LAST_NAME, user.getLastName());
            values.put(Constants.COL_EMAIL, user.getEmail());

            try {
                database.insertOrThrow(Constants.USER_TABLE, null, values);
                listener.onSQLOperationSucceded("Successfully add " + user.getUsername());
                LogUtils.d("Create new user");
            } catch (SQLException e) {
                listener.onSQLOperationFailed(e.getCause() + " " + e.getMessage());
            }
        }
    }


}
