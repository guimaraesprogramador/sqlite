package com.example.curso.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {
    static  final String database = "banco.db";
    static  final  int versao = 1;
    public  sqlite(Context banco){
        super(banco,database,null,versao);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS  sql ( id primary key not null, nome char(500) not null,cpf int not null,enderenco char(500) not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,0,versao);
        onCreate(db);
    }

}
