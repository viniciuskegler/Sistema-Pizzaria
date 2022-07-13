/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.tela;

import br.com.calegario.dao.HibernateUtil;
import br.com.calegario.dao.UsuarioDao;
import br.com.calegario.dao.UsuarioDaoImpl;
import br.com.calegario.entidade.Usuario;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author vinicius.kegler
 */
public class TelaLogin extends javax.swing.JFrame {

    private final UsuarioDao usuarioDao;
    private Session sessao;
    private String login;
    private String senha;

    public TelaLogin() {
        initComponents();
        usuarioDao = new UsuarioDaoImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btLogar = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        varLogin = new javax.swing.JTextField();
        lbTitulo = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        varSenha = new javax.swing.JPasswordField();
        btCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btLogar.setText("Logar");
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbLogin.setText("Login:");

        varLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Logar");

        lbSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbSenha.setText("Senha:");

        varSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btCadastro.setText("Cadastrar");
        btCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btCadastro)
                        .addGap(52, 52, 52)
                        .addComponent(btLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogar)
                    .addComponent(btCadastro))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        login = varLogin.getText().trim();
        senha = String.copyValueOf(varSenha.getPassword());
        if (validarCampos()) {
            sessao = HibernateUtil.abrirConexao();
            try {
                Usuario usuario = usuarioDao.pesquisarPorLogin(login, sessao);
                if (usuario.getSenha().equals(String.valueOf(varSenha.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                    this.dispose();
                    new Principal(usuario).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
                    usuario = null;
                    varSenha.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar conexao!" + e.getMessage());
                varSenha.setText("");
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btLogarActionPerformed

    private void btCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroActionPerformed
        this.setVisible(false);
        new UsuarioCadastro(this).setVisible(true);
    }//GEN-LAST:event_btCadastroActionPerformed

    private boolean validarCampos() {
        if (login.length() < 3 && !login.contains("@")) {
            JOptionPane.showMessageDialog(null, "Digite um login válido.");
            varSenha.setText("");
            return false;
        }
        if (senha.length() < 3) {
            JOptionPane.showMessageDialog(null, "Digite uma senha válida.");
            varSenha.setText("");
            return false;
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastro;
    private javax.swing.JButton btLogar;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField varLogin;
    private javax.swing.JPasswordField varSenha;
    // End of variables declaration//GEN-END:variables
}
