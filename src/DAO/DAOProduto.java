package DAO;
import conexao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ModelProduto;
import java.sql.*;

public class DAOProduto extends ConnectionFactory{
    
    private Connection connection;
    
    private int idProduto;
    private String produtoNome;
    private Double produtoValor;
    private int produtoEstoque;
    private String produtoObservacao;

    public DAOProduto() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(ModelProduto produto){
        String sql = "INSERT INTO produto(idProduto, produtoNome,produtoValor,produtoEstoque,produtoObservacao) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, produto.getIdProduto());
            stmt.setString  (2, produto.getProdutoNome());
            stmt.setDouble  (3, produto.getProdutoValor());
            stmt.setInt     (4, produto.getProdutoEstoque());
            stmt.setString  (5, produto.getProdutoObservacao());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
