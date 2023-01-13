/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author 11053
 */
public class MenuInicial extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicial
     */
    public MenuInicial() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);// iniciar o menu com tela maximizada
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivos = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenuItem();
        jMenuVendas = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Controle Farmacêutico - DaosSystem");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1017, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        jMenuArquivos.setText("Arquivos");
        jMenuArquivos.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgSair.png"))); // NOI18N
        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenuArquivos.add(jMenuSair);

        jMenuBar1.add(jMenuArquivos);

        jMenuCadastros.setText("Cadastros");
        jMenuCadastros.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jMenuClientes.setText("Clientes");
        jMenuCadastros.add(jMenuClientes);

        jMenuProdutos.setText("Produtos");
        jMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuProdutos);

        jMenuUsuarios.setText("Usuários");
        jMenuCadastros.add(jMenuUsuarios);

        jMenuBar1.add(jMenuCadastros);

        jMenuVendas.setText("Vendas");
        jMenuVendas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuBar1.add(jMenuVendas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosActionPerformed
        new ProdutoView().setVisible(true);
    }//GEN-LAST:event_jMenuProdutosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuArquivos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuClientes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenuItem jMenuUsuarios;
    private javax.swing.JMenu jMenuVendas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
