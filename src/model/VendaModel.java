package model;

import java.util.Date;

public class VendaModel {
    private int idVenda;
    private int idCliente ;
    private Date vendaData;
    private Double vendaValorLiquido;
    private Double vendaValorTotal;
    private Double vendaDesconto;
    private int idProduto;
    private int quantidade;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getVendaData() {
        return vendaData;
    }

    public void setVendaData(Date vendaData) {
        this.vendaData = vendaData;
    }

    public Double getVendaValorLiquido() {
        return vendaValorLiquido;
    }

    public void setVendaValorLiquido(Double vendaValorLiquido) {
        this.vendaValorLiquido = vendaValorLiquido;
    }

    public Double getVendaValorTotal() {
        return vendaValorTotal;
    }

    public void setVendaValorTotal(Double vendaValorTotal) {
        this.vendaValorTotal = vendaValorTotal;
    }

    public Double getVendaDesconto() {
        return vendaDesconto;
    }

    public void setVendaDesconto(Double vendaDesconto) {
        this.vendaDesconto = vendaDesconto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
    
    
    


}
