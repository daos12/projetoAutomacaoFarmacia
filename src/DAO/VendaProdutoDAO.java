package DAO;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.VendaProdutoModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VendaProdutoDAO extends ConnectionFactory{
    
    private Connection connection;
    
    private int idVendaProduto ;    
    private int fk_Produto ;
    private int fk_Venda ;
    private double vendaProdutoValor;
    private int vendaProdutoQtd;

    public VendaProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<VendaProdutoModel> leitura() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //metodo utilizado para view
        List<VendaProdutoModel> vendaProdutos = new ArrayList<>(); //Array para guardar os estados

        try {
            stmt = connection.prepareStatement("SELECT * FROM vendaproduto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProdutoModel vendaProduto = new VendaProdutoModel();
                vendaProduto.setIdVendaProduto   (rs.getInt("idVendaProduto")); //nomes colunas bando de dados
                vendaProduto.setFk_Produto       (rs.getInt("fk_Produto")); //nomes colunas bando de dados
                vendaProduto.setFk_Venda         (rs.getInt("fk_Venda"));
                vendaProduto.setVendaProdutoValor(rs.getDouble("vendaProdutoValor"));
                vendaProduto.setVendaProdutoQtd  (rs.getInt("vendaProdutoQtd"));
                vendaProdutos.add(vendaProduto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionFactory.closeConnection(connection, stmt,rs);
        }
        return vendaProdutos;
    }
    
    
    public void adiciona(VendaProdutoModel vendaProduto){
        String sql = "INSERT INTO vendaproduto(fk_Produto,fk_Venda,vendaProdutoValor,vendaProdutoQtd) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, vendaProduto.getFk_Produto());
            stmt.setInt     (2, vendaProduto.getFk_Venda());
            stmt.setDouble  (3, vendaProduto.getVendaProdutoValor());
            stmt.setInt     (4, vendaProduto.getVendaProdutoQtd());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void delete(VendaProdutoModel vendaProduto) {
        String sql = "DELETE FROM vendaproduto WHERE idVendaProduto = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, vendaProduto.getIdVendaProduto());//necessario somente o id
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            stmt.close();
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            throw new RuntimeException(u);
        }
    }
    
    public void update(VendaProdutoModel vendaProduto) {
        String sql = "UPDATE vendaproduto SET fk_Produto = ?,fk_Venda = ?,vendaProdutoValor = ?, vendaProdutoQtd = ? WHERE idVendaProduto = ?";  

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, vendaProduto.getFk_Produto());
            stmt.setInt     (2, vendaProduto.getFk_Venda());
            stmt.setDouble  (3, vendaProduto.getVendaProdutoValor());
            stmt.setInt     (4, vendaProduto.getVendaProdutoQtd());
            stmt.setInt     (5, vendaProduto.getIdVendaProduto());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            throw new RuntimeException(u);
        }
    }
}
