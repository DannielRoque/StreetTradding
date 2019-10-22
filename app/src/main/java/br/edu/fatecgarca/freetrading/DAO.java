package br.edu.fatecgarca.freetrading;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {


    private StreetDatabaseHelper openHelper;
    protected SQLiteDatabase banco;

    public DAO(Context context){
        openHelper = new StreetDatabaseHelper(context, "street.sql", null, 1);
    }

    protected void abre(){
        banco = openHelper.getWritableDatabase();
    }

    protected void fecha(){
        if(banco != null){
            banco.close();
        }
    }

    public boolean incluirCliente(Cliente c){
        long idDoClienteIncluido;
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo",c.getCodigo());
        contentValues.put("endereco",c.getEndereco());
        contentValues.put("bairro",c.getBairro());
        contentValues.put("telefone",c.getTelefone());
        contentValues.put("email",c.getEmail());
        abre();
        idDoClienteIncluido = banco.insert("cliente", null, contentValues);
        fecha();
        if(idDoClienteIncluido>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean incluirProduto(Produto p){
        long idDoProdutoIncluido;
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", p.getCodigo());
        contentValues.put("descricao", p.getDescricao());
        contentValues.put("preco", p.getPreco());
        contentValues.put("quantidade", p.getQuantidade());
        abre();
        idDoProdutoIncluido = banco.insert("produto", null, contentValues);
        fecha();
        if(idDoProdutoIncluido>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean incluirVenda(Venda v){
        long idVendaIncluida;
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo_cliente", v.getCodigo_cliente());
        contentValues.put("codigo_produto", v.getCodigo_produto());
        contentValues.put("quantidade", v.getQantidade_produto());
        contentValues.put("parcela", v.getParcela());
        contentValues.put("valor", v.getTotal());
        contentValues.put("data_venda", v.getData_venda());
        abre();
        idVendaIncluida = banco.insert("venda", null, contentValues);
        fecha();
        if (idVendaIncluida>0){
            return true;
        }else{
            return false;
        }
    }

    public void deletaTudoCliente(){
        abre();
        String sql = "DELETE FROM cliente";
        banco.execSQL(sql);
        fecha();
    }

    public void deletaTudoProduto(){
        abre();
        String sql = "DELETE FROM produto";
        banco.execSQL(sql);
        fecha();
    }

    public void deleteCliente(Integer codigo_cliente){
        abre();
        String sql = "DELETE FROM cliente WHERE codigo_cliente ="+codigo_cliente;
        banco.execSQL(sql);
        fecha();
    }

    public void deleteProduto(Integer codigo_produto){
        abre();
        String sql = "DELETE FROM produto WHERE codigo_produto="+codigo_produto;
        fecha();
    }

    public void deleteVenda(int numero_venda){
        abre();
        String sql = "DELETE FROM venda WHERE numero_venda="+numero_venda;
        fecha();
    }

    public ArrayList<Produto> getTodosProdutos(){
        ArrayList<Produto> lista = new ArrayList<>();
        abre();
        Cursor cursor = banco.query("produto",null,null,null,"descricao",
                null,"descricao");
        while(cursor.moveToNext()){
            Produto produto = new Produto();
            produto.setCodigo(cursor.getInt(0));
            produto.setDescricao(cursor.getString(1));
            produto.setPreco(cursor.getDouble(2));
            lista.add(produto);
        }
        cursor.close();
        fecha();
        return lista;
    }

    public ArrayList<Cliente> getTodosClientes(){
        ArrayList<Cliente> lista = new ArrayList<>();
        abre();
        Cursor cursor = banco.query("cliente",null,null,null,"nome",
                null,"nome");
        while (cursor.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setCodigo(cursor.getInt(0));
            cliente.setNome(cursor.getString(1));
            lista.add(cliente);
        }
        cursor.close();
        fecha();
        return lista;
    }

    public ArrayList<Venda> getTodasVendasPagas(){
        ArrayList<Venda> lista = new ArrayList<>();
        abre();
        Cursor cursor = banco.query("venda",null,"parcela==1",null,null,
                null,"numero_venda");
        while (cursor.moveToNext()){
            Venda venda = new Venda();
            venda.setCodigo_cliente(cursor.getInt(1));
            venda.setCodigo_produto(cursor.getInt(2));
            venda.setTotal(cursor.getDouble(5));
        }
        cursor.close();
        fecha();
        return lista;
    }

    public boolean alteraProduto(Produto produto){
        ContentValues values = new ContentValues();
        values.put("codigo", produto.getCodigo());
        values.put("descricao", produto.getDescricao());
        values.put("quantidade", produto.getQuantidade());
        values.put("valor", produto.getPreco());
        abre();
        int registroAlterado=banco.update("produto",values,"codigo = "+produto.getCodigo(),null);
        fecha();
        return true;
    }

    public boolean alteraCliente(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("codigo", cliente.getCodigo());
        values.put("nome", cliente.getNome());
        values.put("endereco", cliente.getEndereco());
        values.put("bairro", cliente.getBairro());
        values.put("telefone", cliente.getTelefone());
        values.put("email", cliente.getEmail());
        abre();
        int registroAlteradoCliente=banco.update("cliente", values,"codigo="+cliente.getCodigo(),null);
        fecha();
        return true;
    }
}
