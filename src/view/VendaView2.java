package view;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import dao.ClienteDAO;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.VendaProdutoModel;
import model.VendaModel;
import util.Formatador;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.Date;



public class VendaView2 extends javax.swing.JFrame {
    
    Formatador formatador = new Formatador(); //converter ',' para '.' para inserção no bando de dados

    public VendaView2() {
        initComponents();
        valoresComboxCliente();
        valoresComboxProdutos();

    }

    //listagem dos valores do comboBox cliente
    public void valoresComboxCliente() {
        Vector<Integer> idCliente = new Vector<Integer>();
        try {
            java.sql.Connection connection = new ConnectionFactory().getConnection();
            ClienteDAO clienteDao = new ClienteDAO();
            connection = new ConnectionFactory().getConnection();
            ResultSet rs = clienteDao.listarCliente();

            while (rs.next()) {
                idCliente.addElement(rs.getInt(1));
                jcbCliente.addItem(rs.getString(2));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
        }
    }

    //listagem dos valores do comboBox cliente
    public void valoresComboxProdutos() {
        Vector<Integer> idProdutos = new Vector<Integer>();
        try {
            java.sql.Connection connection = new ConnectionFactory().getConnection();
            ProdutoDAO produtoDao = new ProdutoDAO();
            connection = new ConnectionFactory().getConnection();
            ResultSet rs = produtoDao.listarProduto();

            while (rs.next()) {
                idProdutos.addElement(rs.getInt(1));
                jcbProduto.addItem(rs.getString(2));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
        }
    }
    


    public void limpaCampos() {
        txfCodigoCliente.setText("");
        txfCodigoProduto.setText("");
        txfDesconto.setText("");
        txfNumeroVenda.setText("");
        txfPesquisa.setText("");
        txfTotal.setText("");
        txfQuantidade.setText("");
        jcbCliente.setSelectedIndex(0);
        jcbProduto.setSelectedIndex(0);

    }

    private void somarValorTotalProdutos() {
        double soma = 0, valor;
        int cont = jtProdutoVenda.getRowCount();
        for (int i = 0; i < cont; i++) {
            valor = (double) jtProdutoVenda.getValueAt(i, 4);
            soma = soma + valor;
        }
        txfTotal.setText(String.valueOf(soma));
        aplicarDescontos();
    }

    //aplica desconto
    private void aplicarDescontos() {
        try {
            txfTotal.setText(String.valueOf(
                                Double.parseDouble(txfTotal.getText()) - Double.parseDouble(txfDesconto.getText())));
        } catch (NumberFormatException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txfCodigoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcbCliente = new componentes.UJComboBox();
        jLabel2 = new javax.swing.JLabel();
        jcbProduto = new componentes.UJComboBox();
        jLabel5 = new javax.swing.JLabel();
        txfNumeroVenda = new javax.swing.JTextField();
        txfCodigoProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfQuantidade = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        txfDesconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txfTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutoVenda = new javax.swing.JTable();
        jbAdicionar = new javax.swing.JButton();
        txfValorProduto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txfPesquisa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jbPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVendas = new javax.swing.JTable();
        jbCancelar1 = new javax.swing.JButton();
        jbNovo1 = new javax.swing.JButton();
        jbSalvar1 = new javax.swing.JButton();
        jbEditar1 = new javax.swing.JButton();
        jbExcluir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Código Cliente:");

        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione  um Cliente" }));
        jcbCliente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jcbClienteAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setText("Nome do Cliente:");

        jcbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione  um Produto" }));
        jcbProduto.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jcbProdutoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jcbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProdutoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome do Produto:");

        jLabel6.setText("Código Produto:");

        jLabel7.setText("Número da Venda:");

        jLabel8.setText("Quantidade:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgCancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgNovo.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgSalvar.png"))); // NOI18N
        jbSalvar.setText("Cadastrar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgEditar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgExcluir.png"))); // NOI18N
        jbExcluir.setText("Remover produto");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jLabel9.setText("Desconto:");

        jLabel10.setText("Valor Total:");

        jtProdutoVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Produto", "Nome Produto", "Quantidade", "Valor Unitario", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProdutoVenda);
        if (jtProdutoVenda.getColumnModel().getColumnCount() > 0) {
            jtProdutoVenda.getColumnModel().getColumn(0).setMinWidth(80);
            jtProdutoVenda.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtProdutoVenda.getColumnModel().getColumn(0).setMaxWidth(80);
            jtProdutoVenda.getColumnModel().getColumn(2).setMinWidth(80);
            jtProdutoVenda.getColumnModel().getColumn(2).setPreferredWidth(80);
            jtProdutoVenda.getColumnModel().getColumn(2).setMaxWidth(80);
            jtProdutoVenda.getColumnModel().getColumn(3).setMinWidth(90);
            jtProdutoVenda.getColumnModel().getColumn(3).setPreferredWidth(90);
            jtProdutoVenda.getColumnModel().getColumn(3).setMaxWidth(90);
            jtProdutoVenda.getColumnModel().getColumn(4).setMinWidth(90);
            jtProdutoVenda.getColumnModel().getColumn(4).setPreferredWidth(90);
            jtProdutoVenda.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        jbAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgPlus.png"))); // NOI18N
        jbAdicionar.setText("Adicionar");
        jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarActionPerformed(evt);
            }
        });

        jLabel12.setText("Valor Produto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txfCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txfCodigoProduto)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jbAdicionar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jbCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalvar)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCancelar)
                            .addComponent(jbNovo)
                            .addComponent(jbExcluir)
                            .addComponent(jbSalvar)
                            .addComponent(jbEditar))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jLabel11.setText("Pesquisar:");

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgPesquisar.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");

        jtVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Cliente", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtVendas);
        if (jtVendas.getColumnModel().getColumnCount() > 0) {
            jtVendas.getColumnModel().getColumn(0).setMinWidth(120);
            jtVendas.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtVendas.getColumnModel().getColumn(0).setMaxWidth(120);
            jtVendas.getColumnModel().getColumn(2).setMinWidth(110);
            jtVendas.getColumnModel().getColumn(2).setPreferredWidth(110);
            jtVendas.getColumnModel().getColumn(2).setMaxWidth(110);
        }

        jbCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgCancelar.png"))); // NOI18N
        jbCancelar1.setText("Cancelar");
        jbCancelar1.setToolTipText("");
        jbCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelar1ActionPerformed(evt);
            }
        });

        jbNovo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgNovo.png"))); // NOI18N
        jbNovo1.setText("Novo");
        jbNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovo1ActionPerformed(evt);
            }
        });

        jbSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgSalvar.png"))); // NOI18N
        jbSalvar1.setText("Cadastrar");
        jbSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvar1ActionPerformed(evt);
            }
        });

        jbEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgEditar.png"))); // NOI18N
        jbEditar1.setText("Editar");
        jbEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditar1ActionPerformed(evt);
            }
        });

        jbExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgExcluir.png"))); // NOI18N
        jbExcluir1.setText("Excluir");
        jbExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCancelar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbNovo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExcluir1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEditar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalvar1)
                .addGap(14, 14, 14))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(262, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbPesquisar)
                        .addGap(0, 181, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar1)
                    .addComponent(jbNovo1)
                    .addComponent(jbExcluir1)
                    .addComponent(jbSalvar1)
                    .addComponent(jbEditar1))
                .addGap(87, 87, 87))
        );

        jTabbedPane1.addTab("Consultar/Editar/Excluir", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = jtProdutoVenda.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) jtProdutoVenda.getModel();
        modelo.removeRow(linha);
        somarValorTotalProdutos();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
//        habilitaDesabilita(true);
//        if (jtProduto.getSelectedRow() != -1) {
//            // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
//            ProdutoModel produto = new ProdutoModel();
//            produto.setIdProduto        ((int) jtProduto.getValueAt(jtProduto.getSelectedRow(), 0));
//            produto.setProdutoNome      (txfNome.getText());
//            produto.setProdutoValor     (formatador.converterVirgula(txfValor.getText())); //conversor ',' em '.'
//            produto.setProdutoEstoque   (Integer.parseInt(txfEstoque.getText()));
//            produto.setProdutoObservacao(txfObservacao.getText());
//
//            // fazendo a validação dos dados
//            if ((txfNome.getText().isEmpty())|(txfEstoque.getText().isEmpty())|(txfValor.getText().isEmpty())) {
//                JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
//            } else {
//
//                // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
//                ProdutoDAO dao = new ProdutoDAO();
//                dao.update(produto);
//                JOptionPane.showMessageDialog(null, "Produto " + txfNome.getText() + " atualizado com sucesso! ");
//            }
//
//            // apaga os dados preenchidos nos campos de texto
//            limpaCampos();
//
//            // atualiza JTable
//            leiaJTable();
//        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

        // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
        VendaProdutoModel vendaProduto = new VendaProdutoModel();
        vendaProduto.setFk_Produto          (Integer.parseInt(txfCodigoCliente.getText()));
        vendaProduto.setFk_Venda            (Integer.parseInt((txfCodigoProduto.getText())));
        vendaProduto.setVendaProdutoValor   (formatador.converterVirgula(txfTotal.getText())); //conversor ',' em '.'
        vendaProduto.setVendaProdutoQtd     (Integer.parseInt(txfQuantidade.getText()));

//        // fazendo a validação dos dados
//        if ((txfNome.getText().isEmpty())|(txfEstoque.getText().isEmpty())|(txfValor.getText().isEmpty())) {
//            JOptionPane.showMessageDialog(null, "O campo não pode ficar/retornar vazio");
//        } else {
//
//            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
//            ProdutoDAO dao = new ProdutoDAO();
//            dao.adiciona(produto);
//            JOptionPane.showMessageDialog(null, "Produto " + txfNome.getText() + " inserido com sucesso! ");
//        }
//
//        // apaga os dados preenchidos nos campos de texto
//        limpaCampos();
//
//        // atualiza JTable
//        leiaJTable();
//        habilitaDesabilita(false);
//        botaoSalvar(false);

    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        limpaCampos();
//        habilitaDesabilita(true);
//        botaoSalvar(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limpaCampos();
        //habilitaDesabilita(false);
        //botaoSalvar(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelar1ActionPerformed

    private void jbNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbNovo1ActionPerformed

    private void jbSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSalvar1ActionPerformed

    private void jbEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditar1ActionPerformed

    private void jbExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcluir1ActionPerformed

    private void jcbClienteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jcbClienteAncestorAdded


    }//GEN-LAST:event_jcbClienteAncestorAdded

    private void jcbProdutoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jcbProdutoAncestorAdded


    }//GEN-LAST:event_jcbProdutoAncestorAdded

    private void jcbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProdutoActionPerformed

    }//GEN-LAST:event_jcbProdutoActionPerformed

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed
        
        //Tratamento data e hora cadastro
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("yyyy/MM/dd").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        //JOptionPane.showConfirmDialog(null, data);
        
        VendaModel venda = new VendaModel();
        venda.setFk_cliente         (Integer.parseInt(txfCodigoCliente.getText()));
        venda.setVendaData          (new java.sql.Date(System.currentTimeMillis())); //Data exata da venda
        venda.setVendaValorLiquido  (formatador.converterVirgula(txfValorProduto.getText())); //conversor ',' em '.'
        venda.setVendaValorTotal    (formatador.converterVirgula(txfTotal.getText())); //conversor ',' em '.'
        venda.setVendaDesconto      (formatador.converterVirgula(txfDesconto.getText())); //conversor ',' em '.'

    }//GEN-LAST:event_jbAdicionarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VendaView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaView2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAdicionar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCancelar1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEditar1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbExcluir1;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbNovo1;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JButton jbSalvar1;
    private componentes.UJComboBox jcbCliente;
    private componentes.UJComboBox jcbProduto;
    private javax.swing.JTable jtProdutoVenda;
    private javax.swing.JTable jtVendas;
    private javax.swing.JTextField txfCodigoCliente;
    private javax.swing.JTextField txfCodigoProduto;
    private javax.swing.JTextField txfDesconto;
    private javax.swing.JTextField txfNumeroVenda;
    private javax.swing.JTextField txfPesquisa;
    private javax.swing.JTextField txfQuantidade;
    private javax.swing.JTextField txfTotal;
    private javax.swing.JTextField txfValorProduto;
    // End of variables declaration//GEN-END:variables


}
