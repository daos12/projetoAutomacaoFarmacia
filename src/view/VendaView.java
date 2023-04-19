package view;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import dao.ClienteDAO;
import dao.VendaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.VendaModel;
import util.Formatador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ProdutoModel;

public class VendaView extends javax.swing.JFrame {

    public VendaView() {
        initComponents();
        leiaJTable();

    }
    private Connection connection; // conectando para trazer a quantidade de produtos
    Formatador formatador = new Formatador(); //converter ',' para '.' para inserção no bando de dados
 
//Tratamento data e hora para a venda
    Date dataHoraAtual = new Date();
    String data = new SimpleDateFormat("yyyy/MM/dd").format(dataHoraAtual);
    String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);


    
//busca as informações do bando de dados para a tabela jtable
    public void leiaJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtProdutoVenda.getModel();
        modelo.setNumRows(0);//evida duplicar os resultadas ao cadastrar um item
        VendaDAO dao = new VendaDAO();

        for (VendaModel venda : dao.leitura()) {
            modelo.addRow(new Object[]{
                venda.getIdVenda(),
                venda.getIdCliente(),
                venda.getVendaData(),
                venda.getVendaValorTotal(),
                venda.getVendaDesconto(),
                venda.getIdProduto(),
                venda.getQuantidade()
                
            });
        }
    }
    

    public void limpaCampos() {
        txfCodigoCliente.setText("");
        txfCodigoProduto.setText("");
        txfValorProduto.setText("");
        txfQuantidade.setText("");
        txfDesconto.setText("");
        txfTotal.setText("");


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
        txfCodigoProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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
        txfDataaaa = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txfData = new javax.swing.JTextField();
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

        jLabel6.setText("Código Produto:");

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
                "Id Venda", "idCliente ", "Data Venda", "ValorTotal", "Desconto", "idProduto", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutoVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutoVendaMouseClicked(evt);
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

        try {
            txfDataaaa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setText("Data:");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfDataaaa, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfDataaaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        //somarValorTotalProdutos();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        //habilitaDesabilita(true);
        if (jtProdutoVenda.getSelectedRow() != -1) {
            // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
            VendaModel venda = new VendaModel();

            venda.setIdVenda            ((int) jtProdutoVenda.getValueAt(jtProdutoVenda.getSelectedRow(), 0));
            venda.setIdCliente          (Integer.parseInt(txfCodigoCliente.getText()));
            venda.setVendaData          (new java.sql.Date(System.currentTimeMillis()));
            venda.setVendaValorLiquido  (Double.parseDouble(txfValorProduto.getText())); //(formatador.converterVirgula(txfValorProduto.getText())); //conversor ',' em '.'
            venda.setVendaValorTotal    (Double.parseDouble(txfTotal.getText())); //(formatador.converterVirgula(txfTotal.getText())); //conversor ',' em '.'
            venda.setVendaDesconto      (Double.parseDouble(txfDesconto.getText())); //(formatador.converterVirgula(txfDesconto.getText())); //conversor ',' em '.'
            venda.setIdProduto          (Integer.parseInt(txfCodigoProduto.getText()));       
            venda.setQuantidade         (Integer.parseInt(txfQuantidade.getText()));       
 
           
            
            int id = 1;
                  
            try {
                // Conexão com o banco de dados
                connection = new ConnectionFactory().getConnection();
                
                // Comando SQL para selecionar a quantidade de um produto pelo ID

                String sql = "SELECT produtoEstoque FROM produto WHERE idProduto = ?";

                // Preparação da consulta com o ID desejado
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(txfCodigoProduto.getText())); // Substitua "id_do_produto" pelo ID desejado

                // Execução da consulta
                ResultSet rs = stmt.executeQuery();

                // Leitura do resultado (assumindo que só queremos um resultado)
                if (rs.next()) {
                    int quantidade = rs.getInt("produtoEstoque");
                    System.out.println("Quantidade do produto: " + quantidade);
                } else {
                    System.out.println("Produto não encontrado");
                }

            } catch (SQLException e) {
                // Tratamento de erros
                System.err.println("Erro ao buscar a quantidade do produto: " + e.getMessage());
            }


            
            
            
            
            

            
            
            
            
            
            
            
            
            
            
            



            

// fazendo a validação dos dados
            if ((txfCodigoCliente.getText().isEmpty())|(txfTotal.getText().isEmpty())|(txfCodigoProduto.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
            } else {

                // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
                VendaDAO dao = new VendaDAO();
                dao.update(venda);
                JOptionPane.showMessageDialog(null, "Venda " + txfCodigoProduto.getText() + " atualizada com sucesso! ");
            
            
            }

            // apaga os dados preenchidos nos campos de texto
            limpaCampos();

            // atualiza JTable
            leiaJTable();
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

// instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
        VendaModel venda = new VendaModel();
        venda.setIdCliente          (Integer.parseInt(txfCodigoCliente.getText()));
        venda.setVendaData          (new java.sql.Date(System.currentTimeMillis()));
        venda.setVendaValorLiquido  (formatador.converterVirgula(txfValorProduto.getText())); //conversor ',' em '.'
        venda.setVendaValorTotal    (formatador.converterVirgula(txfTotal.getText()));
        venda.setVendaDesconto      (formatador.converterVirgula(txfDesconto.getText()));
        venda.setIdProduto          (Integer.parseInt(txfCodigoProduto.getText()));
        venda.setQuantidade         (Integer.parseInt(txfQuantidade.getText()));

// fazendo a validação dos dados
        if ((txfCodigoCliente.getText().isEmpty()) | (txfValorProduto.getText().isEmpty()) | (txfTotal.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "O campo não pode ficar/retornar vazio");
        } else {

// instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            VendaDAO dao = new VendaDAO();
            dao.adiciona(venda);
            JOptionPane.showMessageDialog(null, "Produto " + txfCodigoProduto.getText() + " inserido com sucesso! ");
        }

// apaga os dados preenchidos nos campos de texto
        limpaCampos();

// atualiza JTable
        leiaJTable();
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

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed
        
//        //Tratamento data e hora cadastro
//        Date dataHoraAtual = new Date();
//        String data = new SimpleDateFormat("yyyy/MM/dd").format(dataHoraAtual);
//        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
//        //JOptionPane.showConfirmDialog(null, data);
//        
//        VendaModel venda = new VendaModel();
//        //venda.setFk_cliente         (Integer.parseInt(txfCodigoCliente.getText()));
//        venda.setVendaData          (new java.sql.Date(System.currentTimeMillis())); //Data exata da venda
//        venda.setVendaValorLiquido  (formatador.converterVirgula(txfValorProduto.getText())); //conversor ',' em '.'
//        venda.setVendaValorTotal    (formatador.converterVirgula(txfTotal.getText())); //conversor ',' em '.'
//        venda.setVendaDesconto      (formatador.converterVirgula(txfDesconto.getText())); //conversor ',' em '.'

    }//GEN-LAST:event_jbAdicionarActionPerformed

    private void jtProdutoVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoVendaMouseClicked
        if (jtProdutoVenda.getSelectedRow() != -1) {
            txfCodigoCliente.setText    (jtProdutoVenda.getValueAt(jtProdutoVenda.getSelectedRow(), 1).toString());
            txfTotal.setText            (jtProdutoVenda.getValueAt(jtProdutoVenda.getSelectedRow(), 3).toString());
            txfDesconto.setText         (jtProdutoVenda.getValueAt(jtProdutoVenda.getSelectedRow(), 4).toString());
            txfCodigoProduto.setText    (jtProdutoVenda.getValueAt(jtProdutoVenda.getSelectedRow(), 5).toString());
            txfQuantidade.setText       (jtProdutoVenda.getValueAt(jtProdutoVenda.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_jtProdutoVendaMouseClicked

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
            java.util.logging.Logger.getLogger(VendaView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTable jtProdutoVenda;
    private javax.swing.JTable jtVendas;
    private javax.swing.JTextField txfCodigoCliente;
    private javax.swing.JTextField txfCodigoProduto;
    private javax.swing.JTextField txfData;
    private javax.swing.JFormattedTextField txfDataaaa;
    private javax.swing.JTextField txfDesconto;
    private javax.swing.JTextField txfPesquisa;
    private javax.swing.JTextField txfQuantidade;
    private javax.swing.JTextField txfTotal;
    private javax.swing.JTextField txfValorProduto;
    // End of variables declaration//GEN-END:variables


}
