package net.maxproit.salesforce.masum.appdata.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AttachmentDbController {

    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context mContext;

    public AttachmentDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public AttachmentDbController open() throws SQLException {
        dbHelper = new DbHelper(mContext);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    public int insertData(int leadId,byte[] imgPP,byte[] imgIdCard,byte[] imgVCard) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_ID, leadId);
        values.put(DbConstants.ATACH_PP, imgPP);
        values.put(DbConstants.ATACH_ID_CARD, imgIdCard);
        values.put(DbConstants.ATACH_V_CARD, imgVCard);
        // Insert the new row, returning the primary key value of the new row
        open();
        int insert= (int) db.insert(DbConstants.TABLE_ATACHMENT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;


    }
}
