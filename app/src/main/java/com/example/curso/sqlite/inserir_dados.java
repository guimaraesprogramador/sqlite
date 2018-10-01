package com.example.curso.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class inserir_dados extends AppCompatActivity {
Button inserir_elementos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        inserir_elementos = (Button) findViewById(R.id.button5);
        inserir_elementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    class inserir {
        private SQLiteDatabase db;
        private sqlite sqlite;

        public inserir(Context context) {
            sqlite = new sqlite(context);
        }

        public String adicionar_Dados(int id, String cpf, String local) {
            ContentValues pessoas;
            db = sqlite.getWritableDatabase();
            pessoas = new ContentValues();
return  pessoas.toString();
        }
    }
    

}
