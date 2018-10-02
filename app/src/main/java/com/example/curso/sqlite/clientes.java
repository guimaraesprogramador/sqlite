package com.example.curso.sqlite;

public class clientes {
    private String nome;

    private int cpf;

    public int getCpf( int cpf) {
        return this.cpf=  cpf;
    }
private String endenco;

    public String getEndenco(String string) {
        return endenco;
    }
private int id;

    public int getId( int id ) {
        return this.id = id;
    }

    public String getNome( String nome ) {
        return this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome;
    }
}
