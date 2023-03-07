package dao;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ClienteModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO extends ConnectionFactory{
    
    private Connection connection;
    
    private int idCliente;
    private String clienteNome;
    private String clienteEndereco;
    private String clienteBairro;
    private String clienteCidade;
    private String clienteEstado;
    private String clienteCep;
    private String clienteTelefone;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<ClienteModel> leitura() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; //metodo utilizado para view
        List<ClienteModel> clientes = new ArrayList<>(); //Array para guardar os estados

        try {
            stmt = connection.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setIdCliente        (rs.getInt      ("idCliente")); //nomes colunas bando de dados
                cliente.setClienteNome      (rs.getString   ("clienteNome")); //nomes colunas bando de dados
                cliente.setClienteEndereco  (rs.getString   ("clienteEndereco"));
                cliente.setClienteBairro    (rs.getString   ("clienteBairro"));
                cliente.setClienteCidade    (rs.getString   ("clienteCidade"));
                cliente.setClienteEstado    (rs.getString   ("clienteEstado"));
                cliente.setClienteCep       (rs.getString   ("clienteCep"));
                cliente.setClienteTelefone  (rs.getString   ("clienteTelefone"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionFactory.closeConnection(connection, stmt,rs);
        }
        return clientes;
    }
    
    //Listagem comboBox
    public ResultSet listarCliente(){
        connection = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM cliente ORDER BY clienteNome;"; //ordem alfabética 
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return stmt.executeQuery();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
            return null;
        }
    }
    
    
    public void adiciona(ClienteModel cliente){
        String sql = "INSERT INTO cliente(clienteNome,clienteEndereco,clienteBairro,clienteCidade,clienteEstado,clienteCep,clienteTelefone ) VALUES(?,?,?,?,?,?,?)";
                       
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString  (1, cliente.getClienteNome());
            stmt.setString  (2, cliente.getClienteEndereco());
            stmt.setString  (3, cliente.getClienteBairro());
            stmt.setString  (4, cliente.getClienteCidade());
            stmt.setString  (5, cliente.getClienteEstado());
            stmt.setString  (6, cliente.getClienteCep());
            stmt.setString  (7, cliente.getClienteTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void delete(ClienteModel cliente) {
        String sql = "DELETE FROM cliente WHERE idProduto = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt     (1, cliente.getIdCliente());//necessario somente o id
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            stmt.close();
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            throw new RuntimeException(u);
        }
    }
    
    public void update(ClienteModel cliente) {
        String sql = "UPDATE cliente SET clienteNome = ?, clienteEndereco = ?, clienteBairro = ?, clienteCidade = ?, clienteEstado = ?, clienteCep = ?, clienteTelefone = ? WHERE idCliente = ?";  
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString  (1, cliente.getClienteNome());
            stmt.setString  (2, cliente.getClienteEndereco());
            stmt.setString  (3, cliente.getClienteBairro());
            stmt.setString  (4, cliente.getClienteCidade());
            stmt.setString  (5, cliente.getClienteEstado());
            stmt.setString  (6, cliente.getClienteCep());
            stmt.setString  (7, cliente.getClienteTelefone());
            stmt.setInt     (8, cliente.getIdCliente());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            throw new RuntimeException(u);
        }
    }
}
