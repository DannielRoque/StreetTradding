package br.edu.fatecgarca.freetrading;

public class Produto {

    private int codigo;
    private String descricao;
    private Double preco;
    private int quantidade;

    public int getCodigo(){
     return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

}
