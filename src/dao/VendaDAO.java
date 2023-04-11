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
    private int fk_cliente ;
    private java.util.Date vendaData;
    private Double vendaValorLiquido;
    private Double vendaValorTotal;
    private Double vendaDesconto;

    
    
    
    public VendaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<VendaModel> leitura() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //metodo utilizado para view
        List<VendaModel> vendas = new ArrayList<>(); //Array para guardar os estados

        try {
            stmt = connection.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaModel venda = new VendaModel();
                venda.setIdVenda            (rs.getInt("idVenda")); //nomes colunas bando de dados
                venda.setFk_cliente         (rs.getInt("fk_cliente ")); //nomes colunas bando de dados
                venda.setVendaData          (rs.getDate("vendaData"));
                venda.setVendaValorLiquido  (rs.getDouble("vendaValorLiquido"));
                venda.setVendaValorTotal    (rs.getDouble("vendaValorTotal"));
                venda.setVendaDesconto      (rs.getDouble("vendaDesconto"));
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
        String sql = "INSERT INTO venda(fk_cliente,vendaData,vendaValorLiquido,vendaValorTotal,vendaDesconto) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, venda.getFk_cliente());
            stmt.setDate    (2, (Date)venda.getVendaData());
            stmt.setDouble  (3, venda.getVendaValorLiquido());
            stmt.setDouble  (4, venda.getVendaValorTotal());
            stmt.setDouble  (5, venda.getVendaDesconto());
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
        String sql = "UPDATE venda SET fk_cliente = ?,vendaData = ?,vendaValorLiquido = ?, vendaValorTotal = ?, vendaDesconto = ? WHERE idVenda = ?";  
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, venda.getFk_cliente());
            stmt.setDate    (2, (Date)venda.getVendaData());
            stmt.setDouble  (3, venda.getVendaValorLiquido());
            stmt.setDouble  (4, venda.getVendaValorTotal());
            stmt.setDouble  (5, venda.getVendaDesconto());
            stmt.setInt     (6, venda.getIdVenda());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            throw new RuntimeException(u);
        }
    }
}
