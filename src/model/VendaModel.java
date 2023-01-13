package model;

import java.util.Date;

public class VendaModel {
    private int idVenda;
    private int fk_cliente ;
    private Date vendaData;
    private Double vendaValorLiquido;
    private Double vendaValorTotal;
    private Double vendaDesconto;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(int fk_cliente) {
        this.fk_cliente = fk_cliente;
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
    
    


}
