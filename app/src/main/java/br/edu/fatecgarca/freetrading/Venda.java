package br.edu.fatecgarca.freetrading;

import java.util.Date;

public class Venda {
    private int codigo_cliente;
    private int codigo_produto;
    private int qantidade_produto;
    private int parcela;
    private double total;
    private String data_venda;

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public int getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public int getQantidade_produto() {
        return qantidade_produto;
    }

    public void setQantidade_produto(int qantidade_produto) {
        this.qantidade_produto = qantidade_produto;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData_venda() {
        return data_venda;
    }


}
