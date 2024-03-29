package dao;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.VendaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendaDAO extends ConnectionFactory{
    
    private Connection connection;
    
    private int idVenda;
    private int idCliente ;
    private java.util.Date vendaData;
    private Double vendaValorLiquido;
    private Double vendaValorTotal;
    private Double vendaDesconto;
    private int idProduto;
    private int quantidade;

    
    
    
    public VendaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<VendaModel> leitura() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //metodo utilizado para view
        List<VendaModel> vendas = new ArrayList<>(); //Array para guardar os estados

        try {
            stmt = connection.prepareStatement("SELECT * FROM venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaModel venda = new VendaModel();
                venda.setIdVenda            (rs.getInt("idVenda")); //nomes colunas bando de dados
                venda.setIdCliente          (rs.getInt("idCliente")); //nomes colunas bando de dados
                venda.setVendaData          (rs.getDate("vendaData"));
                venda.setVendaValorTotal    (rs.getDouble("vendaValorTotal"));
                venda.setVendaDesconto      (rs.getDouble("vendaDesconto"));
                venda.setIdProduto          (rs.getInt("idProduto"));
                venda.setQuantidade         (rs.getInt("quantidade"));
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionFactory.closeConnection(connection, stmt,rs);
        }
        return vendas;
    }

    
    
    public void adiciona(VendaModel venda){
        String sql = "INSERT INTO venda(idCliente,vendaData,vendaValorLiquido,vendaValorTotal,vendaDesconto,idProduto,quantidade) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, venda.getIdCliente());
            stmt.setDate    (2, (Date)venda.getVendaData());
            stmt.setDouble  (3, venda.getVendaValorLiquido());
            stmt.setDouble  (4, venda.getVendaValorTotal());
            stmt.setDouble  (5, venda.getVendaDesconto());
            stmt.setInt     (6, venda.getIdProduto());
            stmt.setInt     (7, venda.getQuantidade());
            stmt.execute(); 
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void delete(VendaModel venda) {
        String sql = "DELETE FROM venda WHERE idVenda = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, venda.getIdVenda());//necessario somente o id
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            stmt.close();
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            throw new RuntimeException(u);
        }
    }
    
    public void update(VendaModel venda) {
        String sql = "UPDATE venda SET idCliente = ?,vendaData = ?,vendaValorLiquido = ?, vendaValorTotal = ?, vendaDesconto = ?, idCliente = ?, quantidade = ? WHERE idVenda = ?";  
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, venda.getIdCliente());
            stmt.setDate    (2, (Date) venda.getVendaData());
            stmt.setDouble  (3, venda.getVendaValorLiquido());
            stmt.setDouble  (4, venda.getVendaValorTotal());
            stmt.setDouble  (5, venda.getVendaDesconto());
            stmt.setInt     (6, venda.getIdProduto());
            stmt.setInt     (7, venda.getQuantidade());
            stmt.setInt     (8, venda.getIdVenda());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a atualização!");
            throw new RuntimeException(u);
        }
    }
}
