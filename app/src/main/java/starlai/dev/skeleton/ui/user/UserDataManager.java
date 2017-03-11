package starlai.dev.skeleton.ui.user;

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

public class UserDataManager implements UserContract.Repository {

    private DatabaseHelper dhHelper;
    private SQLiteDatabase database;

    public UserDataManager(Context context) {
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

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Constants.USER_TABLE;

        if(database != null) {
            Cursor cursor = database.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    users.add(User.getUserFromCursor(cursor));
                    cursor.moveToNext();
                }
            }
        }
        User u1 = new User(1, "izayoi", "Andre", "Lai", "andre@lai.com");
        User u2 = new User(2, "valhalla", "Ang", "Lai", "val@lai.com");
        User u3 = new User(3, "einhenjar", "Ein", "Lai", "ein@lai.com");
        User u4 = new User(5, "troll", "Tral", "Horde", "tral@hoo.com");
        User u5 = new User(7, "moghul", "Moo", "Ghoul", "mgmg@goo.com");
        List<User> tempUsers = new ArrayList<>();
        tempUsers.add(u1);
        tempUsers.add(u2);
        tempUsers.add(u3);
        tempUsers.add(u4);
        tempUsers.add(u5);
        return tempUsers;
    }
}
