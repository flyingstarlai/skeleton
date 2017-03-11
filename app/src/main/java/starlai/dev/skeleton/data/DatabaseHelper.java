package starlai.dev.skeleton.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.apkfuns.logutils.LogUtils;

import starlai.dev.skeleton.utility.Constants;


/**
 * Created by izayoi on 11/9/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private final static int DATABASE_VERSION= 1;
    private static final String DATABASE_NAME = "sekeleton.db";

    private static DatabaseHelper dbInstance = null;

    public static DatabaseHelper newInstance(Context context) {
        if(context == null) LogUtils.d("Context Null");
        if(dbInstance == null) dbInstance = new DatabaseHelper(context.getApplicationContext());
        return dbInstance;
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        LogUtils.d("Create User: " + CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static final String CREATE_USER_TABLE =
            "CREATE TABLE " + Constants.USER_TABLE + "("
                    + Constants.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + Constants.COL_USERNAME + " TEXT, "
                    + Constants.COL_FIRST_NAME + " TEXT, "
                    + Constants.COL_LAST_NAME + " TEXT, "
                    + Constants.COL_EMAIL + " TEXT" + ")";


}
