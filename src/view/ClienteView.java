package view;
import dao.ClienteDAO;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import model.ClienteModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import util.Formatador;

public class ClienteView extends javax.swing.JFrame {
    
    Formatador formatador = new Formatador(); //converter ',' para '.' para inserção no bando de dados
    private DefaultTableModel tabela; //Para criar a opção de pesquisa
    private TableRowSorter<TableModel> sorter; //Para criar a opção de pesquisa
//    private javax.swing.JComboBox<String> jcbPesquisa; //Para criar a opção de pesquisa
    
    public ClienteView() {
        initComponents();
        leiaJTable();
        //habilitaDesabilita(false);//desabilitar os campos para edição
        botaoSalvar(false); //Desabilita o botão salvar
        
    }


    
    //busca as informações do bando de dados para a tabela jtable
    public void leiaJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
        modelo.setNumRows(0);//evida duplicar os resultadas ao cadastrar um item
        ClienteDAO dao = new ClienteDAO();

        for (ClienteModel cliente : dao.leitura()) {
            modelo.addRow(new Object[]{
                cliente.getIdCliente(),
                cliente.getClienteNome(),
                cliente.getClienteEndereco(),
                cliente.getClienteBairro(),
                cliente.getClienteCidade(),
                cliente.getClienteEstado(),
                cliente.getClienteCep(),
                cliente.getClienteTelefone(),
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
        jLabel3 = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txfPesquisa = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        txfBairro = new javax.swing.JFormattedTextField();
        txfCidade = new javax.swing.JFormattedTextField();
        jcbEstados = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfCep = new javax.swing.JFormattedTextField();
        txfTelefone = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txfEndereco = new javax.swing.JTextField();
        jcbPesquisa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Clientes - DaosSystem");
        setResizable(false);

        jLabel1.setText("Código:");

        txfCodigo.setEditable(false);

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel5.setText("Cidade:");

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
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgNovo.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgCancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jbCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalvar)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbNovo)
                    .addComponent(jbSalvar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jLabel9.setText("Bairro:");

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Cliente", "Endereço", "Bairro", "Cidade", "Estado", "CEP", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCliente);
        if (jtCliente.getColumnModel().getColumnCount() > 0) {
            jtCliente.getColumnModel().getColumn(0).setMinWidth(90);
            jtCliente.getColumnModel().getColumn(0).setPreferredWidth(90);
            jtCliente.getColumnModel().getColumn(0).setMaxWidth(90);
            jtCliente.getColumnModel().getColumn(1).setMinWidth(300);
            jtCliente.getColumnModel().getColumn(1).setPreferredWidth(300);
            jtCliente.getColumnModel().getColumn(1).setMaxWidth(300);
            jtCliente.getColumnModel().getColumn(2).setMinWidth(130);
            jtCliente.getColumnModel().getColumn(2).setPreferredWidth(130);
            jtCliente.getColumnModel().getColumn(2).setMaxWidth(130);
        }

        jLabel10.setText("Pesquisar:");

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgPesquisar.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        txfBairro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txfCidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jcbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jcbEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadosActionPerformed(evt);
            }
        });

        jLabel6.setText("UF:");

        jLabel11.setText("CEP:");

        try {
            txfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("Telefone:");

        jcbPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txfBairro)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txfNome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txfCidade))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jcbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbPesquisar)
                .addGap(41, 41, 41)
                .addComponent(jcbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(txfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(28, 28, 28))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar)
                    .addComponent(jcbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (jtCliente.getSelectedRow() != -1) {
            // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
            ClienteModel cliente = new ClienteModel();
            cliente.setIdCliente((int) jtCliente.getValueAt(jtCliente.getSelectedRow(), 0)); //somente id

            // fazendo a validação dos dados
            if ((txfNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
            } else {

                // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
                ClienteDAO dao = new ClienteDAO();
                dao.delete(cliente);
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

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        habilitaDesabilita(true);
        if (jtCliente.getSelectedRow() != -1) {
            // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
            ClienteModel cliente = new ClienteModel();
            cliente.setIdCliente        ((int) jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
            cliente.setClienteNome      (txfNome.getText());
            cliente.setClienteEndereco  (txfEndereco.getText());
            cliente.setClienteBairro    (txfBairro.getText()); 
            cliente.setClienteCidade    (txfCidade.getText());
            //cliente.setClienteEstado    (jcbEstados.getText());
            cliente.setClienteCep       (txfCep.getText());
            cliente.setClienteTelefone  (txfTelefone.getText());

            // fazendo a validação dos dados
            if ((txfNome.getText().isEmpty())|(txfCidade.getText().isEmpty())|(txfBairro.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
            } else {

                // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
                ClienteDAO dao = new ClienteDAO();
                dao.update(cliente);
                JOptionPane.showMessageDialog(null, "Cliente " + txfNome.getText() + " atualizado com sucesso! ");
            }

            // apaga os dados preenchidos nos campos de texto
            limpaCampos();

            // atualiza JTable
            leiaJTable();
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
        ClienteModel cliente = new ClienteModel();
        cliente.setClienteNome      (txfNome.getText());
        cliente.setClienteEndereco  (txfEndereco.getText());
        cliente.setClienteBairro    (txfBairro.getText()); 
        cliente.setClienteCidade    (txfCidade.getText());
       // cliente.setClienteEstado    (jcbEstados.getText());
        cliente.setClienteCep       (txfCep.getText());
        cliente.setClienteTelefone  (txfTelefone.getText());

        // fazendo a validação dos dados
        if ((txfNome.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "O campo não pode ficar/retornar vazio");
        } else {

            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            ClienteDAO dao = new ClienteDAO();
            dao.adiciona(cliente);
            JOptionPane.showMessageDialog(null, "Cliente " + txfNome.getText() + " inserido com sucesso! ");
        }

        // apaga os dados preenchidos nos campos de texto
        limpaCampos();

        // atualiza JTable
        leiaJTable();
        habilitaDesabilita(false);
        botaoSalvar(false);
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        limpaCampos();
        habilitaDesabilita(true);
        botaoSalvar(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limpaCampos();
        habilitaDesabilita(false);
        botaoSalvar(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jcbEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadosActionPerformed

    private void jtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClienteMouseClicked
        if (jtCliente.getSelectedRow() != -1) {
            txfCodigo.setText       (jtCliente.getValueAt(jtCliente.getSelectedRow(), 0).toString());
            txfNome.setText         (jtCliente.getValueAt(jtCliente.getSelectedRow(), 1).toString());
            txfEndereco.setText     (jtCliente.getValueAt(jtCliente.getSelectedRow(), 2).toString());
            txfBairro.setText       (jtCliente.getValueAt(jtCliente.getSelectedRow(), 3).toString());
            txfCidade.setText       (jtCliente.getValueAt(jtCliente.getSelectedRow(), 4).toString());
            //jcbEstados.setText      (jtCliente.getValueAt(jtCliente.getSelectedRow(), 5).toString());
            txfBairro.setText       (jtCliente.getValueAt(jtCliente.getSelectedRow(), 6).toString());
            txfCep.setText          (jtCliente.getValueAt(jtCliente.getSelectedRow(), 7).toString());
            txfTelefone.setText     (jtCliente.getValueAt(jtCliente.getSelectedRow(), 8).toString());

        }
    }//GEN-LAST:event_jtClienteMouseClicked

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed

    }//GEN-LAST:event_jbPesquisarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }
    
    
    public void habilitaDesabilita(boolean condicao){
        txfNome.setEditable(condicao);
        txfCidade.setEditable(condicao);
        txfBairro.setEditable(condicao);
        txfEndereco.setEditable(condicao);
        jcbEstados.setEditable(condicao);
        txfCep.setEditable(condicao);
        txfTelefone.setEditable(condicao);
}
    
    public void botaoSalvar(boolean condicao){
        jbSalvar.setEnabled(condicao);
    }
    
    public void limpaCampos(){
        txfNome.setText("");
        txfCidade.setText("");
        txfBairro.setText("");
        txfEndereco.setText("");
        //jcbEstados.setText("");
        txfCep.setText("");
        txfTelefone.setText("");
        
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JComboBox<String> jcbEstados;
    private javax.swing.JComboBox<String> jcbPesquisa;
    private javax.swing.JTable jtCliente;
    private javax.swing.JFormattedTextField txfBairro;
    private javax.swing.JFormattedTextField txfCep;
    private javax.swing.JFormattedTextField txfCidade;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfEndereco;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfPesquisa;
    private javax.swing.JFormattedTextField txfTelefone;
    // End of variables declaration//GEN-END:variables
}
