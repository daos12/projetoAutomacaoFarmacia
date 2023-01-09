package model;
public class ProdutoModel {
    private int idProduto;
    private String produtoNome;
    private Double produtoValor;
    private int produtoEstoque;
    private String produtoObservacao;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(Double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public int getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(int produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

    public String getProdutoObservacao() {
        return produtoObservacao;
    }

    public void setProdutoObservacao(String produtoObservacao) {
        this.produtoObservacao = produtoObservacao;
    }

}
