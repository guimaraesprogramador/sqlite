package com.example.curso.sqlite;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.O;

public class selecionar_itens extends AppCompatActivity {
ListView listagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_itens);
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
        listagem = (ListView) findViewById(R.id.lista);
        Button pesquisar = (Button) findViewById(R.id.button);
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new listar().selecionar_elementos();
            }
        });
    }
    class listar{
        private SQLiteDatabase db;
        private sqlite sqlite;

        @SuppressLint("WrongConstant")
        public void selecionar_elementos(){
            try{

                String[] coluna = {"id","cpf", "nome", "enderenco"};
                db = openOrCreateDatabase(sqlite.database,SQLiteDatabase.CREATE_IF_NECESSARY,null);
                final Cursor sql;
                sql = db.query("sql", coluna, null, null,null,null, "id Asc");
                ArrayList<clientes> lista = new ArrayList<clientes>();
                if(sql.getCount()>0){
                    sql.moveToFirst();
                    do{
                        clientes c = new clientes();
                        c.getId(sql.getInt(0));
                        c.getCpf(sql.getInt(2));
                        c.getEndenco(sql.getString(3));
                        c.getNome(sql.getString(1));
                        lista.add(c);
                    }while (sql.moveToNext());
                }
                ArrayAdapter<clientes> adapter = new ArrayAdapter<clientes>(
                        selecionar_itens.this,
                        android.R.layout.simple_list_item_1,lista);
                listagem.setAdapter(adapter);

            }catch (Exception err){

            }


        }
    }
}
