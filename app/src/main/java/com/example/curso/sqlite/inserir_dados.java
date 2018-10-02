package com.example.curso.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class inserir_dados extends AppCompatActivity {
Button inserir_elementos;
    EditText cpf;
    EditText id;
    EditText enderenco;
    EditText nome;
    @SuppressLint("WrongViewCast")
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
        id = findViewById(R.id.editText2);
        cpf =  findViewById(R.id.editText3);
        enderenco = findViewById(R.id.editText4);
        nome = findViewById(R.id.editText5);
                inserir_elementos = (Button) findViewById(R.id.button5);
        inserir_elementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new inserir().adicionar_Dados(id.getId(),cpf.getId(),enderenco.toString(),nome.toString());
            }
        });
        Button voltar = (Button) findViewById(R.id.button6);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    class inserir {
        private SQLiteDatabase db;
        private sqlite sqlite;

        @SuppressLint("WrongConstant")
        public String adicionar_Dados(int id, int cpf, String local, String nome) {
            ContentValues pessoas;
            long resutlado;
            db = openOrCreateDatabase(sqlite.database,SQLiteDatabase.CREATE_IF_NECESSARY,null);

            pessoas = new ContentValues();
            pessoas.put("id",id);
            pessoas.put("cpf",cpf);
            pessoas.put("enderenco",local);
            pessoas.put("nome",nome);
            try{
                resutlado = db.insert("sql",null,pessoas);
                messagem("Envio","recebido");
               return  "ok";
            }catch (Exception err){
                Log.i("erro","aconteceu alguma coisa ",err);
                return err.getMessage();
            }
            finally {
            }

        }
        public  void  messagem(String titulo ,String mensagem){
            android.app.AlertDialog.Builder alertateste = new android.app.AlertDialog.Builder(inserir_dados.this);
            alertateste.setMessage(mensagem);
            alertateste.setTitle(titulo);
            alertateste.setNeutralButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub

                }
            });
            alertateste.show();
        }
    }
    

}
