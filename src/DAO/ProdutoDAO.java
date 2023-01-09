package DAO;
import conexao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ProdutoModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDAO extends ConnectionFactory{
    
    private Connection connection;
    
    private int idProduto;
    private String produtoNome;
    private Double produtoValor;
    private int produtoEstoque;
    private String produtoObservacao;

    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<ProdutoModel> leitura() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //metodo utilizado para view
        List<ProdutoModel> produtos = new ArrayList<>(); //Array para guardar os estados

        try {
            stmt = connection.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoModel produto = new ProdutoModel();
                produto.setIdProduto        (rs.getInt("idProduto")); //nomes colunas bando de dados
                produto.setProdutoNome      (rs.getString("produtoNome")); //nomes colunas bando de dados
                produto.setProdutoValor     (rs.getDouble("produtoValor"));
                produto.setProdutoEstoque   (rs.getInt("produtoEstoque"));
                produto.setProdutoObservacao(rs.getString("produtoObservacao"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionFactory.closeConnection(connection, stmt,rs);
        }
        return produtos;
    }
    
    
    public void adiciona(ProdutoModel produto){
        String sql = "INSERT INTO produto(produtoNome,produtoValor,produtoEstoque,produtoObservacao) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString  (1, produto.getProdutoNome());
            stmt.setDouble  (2, produto.getProdutoValor());
            stmt.setInt     (3, produto.getProdutoEstoque());
            stmt.setString  (4, produto.getProdutoObservacao());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void delete(ProdutoModel produto) {
        String sql = "DELETE FROM produto WHERE idProduto = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, produto.getIdProduto());//necessario somente o id
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            stmt.close();
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            throw new RuntimeException(u);
        }
    }
    
    public void update(ProdutoModel produto) {
        String sql = "UPDATE produto SET produtoNome = ?,produtoValor = ?,produtoEstoque = ?, produtoObservacao = ? WHERE idProduto = ?";  
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString  (1, produto.getProdutoNome());
            stmt.setDouble  (2, produto.getProdutoValor());
            stmt.setInt     (3, produto.getProdutoEstoque());
            stmt.setString  (4, produto.getProdutoObservacao());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            throw new RuntimeException(u);
        }
    }
}
