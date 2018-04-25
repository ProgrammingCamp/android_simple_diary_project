package com.programmingcamp.simplediary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, "DiaryDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE tblDiary(DiaryDate TEXT Primary Key, DiaryContent TEXT)";
        db.execSQL(query);
    }

    public void SaveDiary(DiaryModel diaryModel){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("DiaryDate", diaryModel.getDiaryDate());
        values.put("DiaryContent", diaryModel.getDiaryContent());

        db.insert("tblDiary", null, values);
    }

    public DiaryModel SearchDiaryByDate(String diaryDate){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("tblDiary",new String[]{"DiaryDate", "DiaryContent"},
                "DiaryDate=?",new String[]{diaryDate},
                null,null,null);

        if(cursor != null){
            cursor.moveToFirst();

            DiaryModel diaryModel = new DiaryModel();
            diaryModel.setDiaryDate(cursor.getString(0));
            diaryModel.setDiaryContent(cursor.getString(1));

            return diaryModel;
        }
        else{
            return null;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

