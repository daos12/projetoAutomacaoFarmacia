package model;
public class VendaProdutoModel {
    private int idVendaProduto ;    
    private int fk_Produto ;
    private int fk_Venda ;
    private double vendaProdutoValor;
    private int vendaProdutoQtd;

    public int getIdVendaProduto() {
        return idVendaProduto;
    }

    public void setIdVendaProduto(int idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    public int getFk_Produto() {
        return fk_Produto;
    }

    public void setFk_Produto(int fk_Produto) {
        this.fk_Produto = fk_Produto;
    }

    public int getFk_Venda() {
        return fk_Venda;
    }

    public void setFk_Venda(int fk_Venda) {
        this.fk_Venda = fk_Venda;
    }

    public double getVendaProdutoValor() {
        return vendaProdutoValor;
    }

    public void setVendaProdutoValor(double vendaProdutoValor) {
        this.vendaProdutoValor = vendaProdutoValor;
    }

    public int getVendaProdutoQtd() {
        return vendaProdutoQtd;
    }

    public void setVendaProdutoQtd(int vendaProdutoQtd) {
        this.vendaProdutoQtd = vendaProdutoQtd;
    }

    
    

    
}
