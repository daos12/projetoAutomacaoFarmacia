package view;
import DAO.ProdutoDAO;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import javax.swing.table.DefaultTableModel;

public class ProdutoView extends javax.swing.JFrame {
    public ProdutoView() {
        initComponents();
        leiaJTable();
        habilitaDesabilita(false);//desabilitar os campos para edição
    }

    
    //busca as informações do bando de dados para a tabela jtable
    public void leiaJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);//evida duplicar os resultadas ao cadastrar um item
        ProdutoDAO dao = new ProdutoDAO();

        for (ProdutoModel produto : dao.leitura()) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getProdutoNome(),
                produto.getProdutoEstoque(),
                produto.getProdutoValor(),
            });
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfEstoque = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfObservacao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        txfValor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txfPesquisa = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código:");

        txfCodigo.setEditable(false);

        jLabel2.setText("Nome:");

        jLabel3.setText("Estoque:");

        jLabel5.setText("Bula/Informações:");

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
        jbSalvar.setText("Salvar");
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
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jbCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalvar)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbNovo)
                    .addComponent(jbSalvar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Valor:");

        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Estoque", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProduto);
        if (jtProduto.getColumnModel().getColumnCount() > 0) {
            jtProduto.getColumnModel().getColumn(0).setMinWidth(15);
            jtProduto.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        jLabel10.setText("Pesquisar:");

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgPesquisar.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txfEstoque, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 519, Short.MAX_VALUE))
                            .addComponent(txfNome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txfObservacao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jbPesquisar)
                            .addGap(104, 104, 104))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabel9))
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(29, 29, 29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
// instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
        ProdutoModel produto = new ProdutoModel();
        produto.setProdutoNome      (txfNome.getText());
        produto.setProdutoEstoque   (Integer.parseInt((txfEstoque.getText())));
        produto.setProdutoValor     (Double.parseDouble((txfValor.getText())));
        produto.setProdutoObservacao(txfNome.getText());

// fazendo a validação dos dados
        if ((txfNome.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
        } else {

// instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            ProdutoDAO dao = new ProdutoDAO();
            dao.adiciona(produto);
            JOptionPane.showMessageDialog(null, "Produto " + txfNome.getText() + " inserido com sucesso! ");
        }

// apaga os dados preenchidos nos campos de texto
        limpaCampos();

// atualiza JTable
        leiaJTable();
        habilitaDesabilita(false);
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jtProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseClicked
        if (jtProduto.getSelectedRow() != -1) {
            txfCodigo.setText       (jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txfNome.setText         (jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            txfEstoque.setText      (jtProduto.getValueAt(jtProduto.getSelectedRow(), 2).toString());
            txfValor.setText        (jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());
            
        }
    }//GEN-LAST:event_jtProdutoMouseClicked

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        habilitaDesabilita(true);
        if (jtProduto.getSelectedRow() != -1) {
// instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
            ProdutoModel produto = new ProdutoModel();
            produto.setIdProduto        ((int) jtProduto.getValueAt(jtProduto.getSelectedRow(), 0));
            produto.setProdutoNome      (txfNome.getText());
            produto.setProdutoValor     (Double.parseDouble(txfValor.getText()));
            produto.setProdutoEstoque   (Integer.parseInt(txfEstoque.getText()));
            produto.setProdutoObservacao(txfObservacao.getText());


// fazendo a validação dos dados
            if ((txfNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
            } else {

// instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
                ProdutoDAO dao = new ProdutoDAO();
                dao.update(produto);
                JOptionPane.showMessageDialog(null, "Produto " + txfNome.getText() + " atualizado com sucesso! ");
            }

// apaga os dados preenchidos nos campos de texto
            limpaCampos();

// atualiza JTable
            leiaJTable();
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (jtProduto.getSelectedRow() != -1) {
            // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
            ProdutoModel produto = new ProdutoModel(); 
            produto.setIdProduto((int) jtProduto.getValueAt(jtProduto.getSelectedRow(), 0)); //somente id

// fazendo a validação dos dados
            if ((txfNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
            } else {

// instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
                ProdutoDAO dao = new ProdutoDAO();
                dao.delete(produto);
                //JOptionPane.showMessageDialog(null, "Estado " + txfNomeEstado.getText() + " atualizado com sucesso! ");
            }

// apaga os dados preenchidos nos campos de texto
            limpaCampos();
        // atualiza JTable
            leiaJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        limpaCampos();
        habilitaDesabilita(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limpaCampos();
        habilitaDesabilita(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoView().setVisible(true);
            }
        });
    }
    
    
    public void habilitaDesabilita(boolean condicao){
        txfNome.setEditable(condicao);
        txfEstoque.setEditable(condicao);
        txfValor.setEditable(condicao);
        txfObservacao.setEditable(condicao);
}
    
    public void limpaCampos(){
        txfNome.setText("");
        txfEstoque.setText("");
        txfValor.setText("");
        txfCodigo.setText("");
        txfObservacao.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTable jtProduto;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfEstoque;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfObservacao;
    private javax.swing.JTextField txfPesquisa;
    private javax.swing.JTextField txfValor;
    // End of variables declaration//GEN-END:variables
}
