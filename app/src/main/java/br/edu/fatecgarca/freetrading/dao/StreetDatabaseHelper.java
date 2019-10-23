package br.edu.fatecgarca.freetrading.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StreetDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "street.db";
    private static final int DB_VERSION = 1;

    public StreetDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String comandoCliente = "CREATE TABLE IF NOT EXISTS cliente("
                +"codigo INTEGER PRIMARY KEY," +
                "nome TEXT," +
                "endereco TEXT," +
                "bairro TEXT," +
                "telefone TEXT," +
                "email TEXT" +
                ")";
        db.execSQL(comandoCliente);

        String comandoProduto = "CREATE TABLE IF NOT EXISTS produto("+
                "codigo INTEGER PRIMARY KEY," +
                "descricao TEXT," +
                "preco DOUBLE," +
                "quantidade INTEGER" +
                ")";
        db.execSQL(comandoProduto);

        String comandoVenda = "CREATE TABLE IF NOT EXISTS venda("+
                "numero_venda INTEGER PRIMARY KEY AUTOINCREMENT," +
                "codigo_cliente INTEGER,"+
                "codigo_produto INTEGER,"+
                "quantidade INTEGER,"+
                "parcela INTEGER," +
                "valor DOUBLE," +
                "data_venda DATE," +
                "PRIMARY KEY (codigo_cliente, codigo_produto), " +
                "FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo)," +
                "FOREIGN KEY (codigo_produto) REFERENCES produto (codigo)"+
                ")";
        db.execSQL(comandoVenda);

        /*String comandoProdutoVenda = "CREATE TABLE IF NOT EXISTS  produtovenda("+
                "codigo_produto INTEGER," +
                "numero_venda INTEGER," +
                "quantidade_vendida INTEGER," +
                "preco_unitario TEXT, PRIMARY KEY (codigo, numero_venda), " +
                "FOREIGN KEY (numero_venda) REFERENCES venda (numero_venda)," +
                "FOREIGN KEY (codigo_produto) REFERENCES produto (codigo)" +
                ")";
        db.execSQL(comandoProdutoVenda);*/


        String comandoPagamento = "CREATE TABLE IF NOT EXISTS pagamento("+
                "codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "codigo_cliente INTEGER," +
                "numero_venda INTEGER," +
                "codigo_produto INTEGER," +
                "status boolean, PRIMARY KEY (codigo, codigo_cliente, numero_venda, codigo_produto)," +
                "FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo)," +
                "FOREIGN KEY (numero_venda) REFERENCES venda (numero_venda)," +
                "FOREIGN KEY (codigo_cliente) REFERENCES produto (codigo)" +
                ")";
        db.execSQL(comandoPagamento);

        String comandoUsuarios = "CREATE TABLE IF NOT EXISTS usuarios(" +
                "codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "email TEXT," +
                "usuario TEXT," +
                "senha TEXT" +
                ")";
        db.execSQL(comandoUsuarios);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

