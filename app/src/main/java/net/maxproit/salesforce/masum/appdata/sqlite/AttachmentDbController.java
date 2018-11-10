package net.maxproit.salesforce.masum.appdata.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.salesforce.masum.model.Attachment;
import net.maxproit.salesforce.masum.model.VisitPlan;

import java.util.ArrayList;

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

    public int insertData(int leadId, byte[] imgPP, byte[] imgIdCard, byte[] imgVCard) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_ID, leadId);
        values.put(DbConstants.ATACH_PP, imgPP);
        values.put(DbConstants.ATACH_ID_CARD, imgIdCard);
        values.put(DbConstants.ATACH_V_CARD, imgVCard);
        // Insert the new row, returning the primary key value of the new row
        open();
        int insert = (int) db.insert(DbConstants.TABLE_ATACHMENT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;


    }

    public int updateData(Attachment attachment) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.ATACH_PP, attachment.getProfilePic());
        values.put(DbConstants.ATACH_ID_CARD, attachment.getIdCard());
        values.put(DbConstants.ATACH_V_CARD, attachment.getVisitingCard());
        // Insert the new row, returning the primary key value of the new row
        open();
        int update = db.update(DbConstants.TABLE_ATACHMENT, values, DbConstants.LEAD_ID + "=" + attachment.getLeadId(), null);

        close();
        return update;


    }


    public ArrayList<Attachment> getAllData(String leadId) {
        String[] projection = {
                DbConstants.ATACHMENT_ID,
                DbConstants.LEAD_ID,
                DbConstants.ATACH_PP,
                DbConstants.ATACH_ID_CARD,
                DbConstants.ATACH_V_CARD,

        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.ATACHMENT_ID + " DESC";
        String WHERE = DbConstants.LEAD_ID + "=?";
        Cursor c = db.query(
                DbConstants.TABLE_ATACHMENT,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[]{leadId},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }


    private ArrayList<Attachment> fetchData(Cursor c) {
        ArrayList<Attachment> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    int id = c.getInt(c.getColumnIndexOrThrow(DbConstants.ATACHMENT_ID));
                    int leadId = c.getInt(c.getColumnIndexOrThrow(DbConstants.LEAD_ID));
                    byte[] proPic = c.getBlob(c.getColumnIndexOrThrow(DbConstants.ATACH_PP));
                    byte[] idCard = c.getBlob(c.getColumnIndexOrThrow(DbConstants.ATACH_ID_CARD));
                    byte[] vCard = c.getBlob(c.getColumnIndexOrThrow(DbConstants.ATACH_V_CARD));

                    // wrap up data list and return
                    favDataArray.add(new Attachment(id, leadId, proPic, idCard, vCard));
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }
}
