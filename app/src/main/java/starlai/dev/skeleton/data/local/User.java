package starlai.dev.skeleton.data.local;

import android.database.Cursor;
import android.provider.SyncStateContract;

import starlai.dev.skeleton.utility.Constants;

/**
 * Created by izayoi on 3/8/17.
 */

public class User {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public User(long id, String username, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id: " + getId() +
                ", username: " + getUsername()+
                ", firstName: " + getFirstName() +
                ", lastName: " + getLastName() +
                ", email: " + getEmail() + "}";
    }

    public static User getUserFromCursor(Cursor cursor) {
        long id = cursor.getLong(cursor.getColumnIndex(Constants.COL_ID));
        String username = cursor.getString(cursor.getColumnIndex(Constants.COL_USERNAME));
        String firstName = cursor.getString(cursor.getColumnIndex(Constants.COL_FIRST_NAME));
        String lastName = cursor.getString(cursor.getColumnIndex(Constants.COL_LAST_NAME));
        String email = cursor.getString(cursor.getColumnIndex(Constants.COL_EMAIL));

        return new User(id, username, firstName, lastName, email);

    }
}
