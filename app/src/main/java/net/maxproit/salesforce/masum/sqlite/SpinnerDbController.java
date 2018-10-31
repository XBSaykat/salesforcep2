package net.maxproit.salesforce.masum.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SpinnerDbController {

    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context mContext;

    public SpinnerDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public SpinnerDbController open() throws SQLException {
        dbHelper = new DbHelper(mContext);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

}
