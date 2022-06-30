/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.tela;

import br.com.calegario.entidade.Usuario;

/**
 *
 * @author vinicius.kegler
 */
public class Principal extends javax.swing.JFrame {

    private Usuario usuarioLogado;

    public Principal() {
        initComponents();
    }

    public Principal(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        this.lbmostrarnome.setText(usuarioLogado.getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbmostrarnome = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        mnCliente = new javax.swing.JMenu();
        mnClienteCad = new javax.swing.JMenuItem();
        mnClientePesq = new javax.swing.JMenuItem();
        mnPedido = new javax.swing.JMenu();
        mnPedidoCad = new javax.swing.JMenuItem();
        mnPedidoPesq = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Pizzaria");

        mnCliente.setText("Cliente");

        mnClienteCad.setText("Cadastrar");
        mnClienteCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClienteCadActionPerformed(evt);
            }
        });
        mnCliente.add(mnClienteCad);

        mnClientePesq.setText("Pesquisar");
        mnClientePesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClientePesqActionPerformed(evt);
            }
        });
        mnCliente.add(mnClientePesq);

        barraMenu.add(mnCliente);

        mnPedido.setText("Pedido");

        mnPedidoCad.setText("Cadastrar");
        mnPedido.add(mnPedidoCad);

        mnPedidoPesq.setText("Pesquisar");
        mnPedido.add(mnPedidoPesq);

        barraMenu.add(mnPedido);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lbmostrarnome, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbmostrarnome, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 211, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnClientePesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnClientePesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnClientePesqActionPerformed

    private void mnClienteCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnClienteCadActionPerformed
        new ClienteCadastro().setVisible(true);
        System.out.println("asodkjfasogjaogjaoigja");
    }//GEN-LAST:event_mnClienteCadActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbmostrarnome;
    private javax.swing.JMenu mnCliente;
    private javax.swing.JMenuItem mnClienteCad;
    private javax.swing.JMenuItem mnClientePesq;
    private javax.swing.JMenu mnPedido;
    private javax.swing.JMenuItem mnPedidoCad;
    private javax.swing.JMenuItem mnPedidoPesq;
    // End of variables declaration//GEN-END:variables
}
