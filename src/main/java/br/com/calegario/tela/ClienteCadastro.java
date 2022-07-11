/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.tela;

import br.com.calegario.dao.ClienteDao;
import br.com.calegario.dao.ClienteDaoImpl;
import br.com.calegario.dao.HibernateUtil;
import br.com.calegario.entidade.Cliente;
import br.com.calegario.entidade.Endereco;
import br.com.calegario.entidade.EnderecoDTO;
import br.com.calegario.ws.CepRest;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public class ClienteCadastro extends javax.swing.JFrame {

    private ClienteDao clienteDao;
    private Cliente cliente;
    private Endereco endereco;
    private Session session;
    private boolean alterar;

    public ClienteCadastro() {
        initComponents();
        clienteDao = new ClienteDaoImpl();
        varRua.setEditable(false);
        varBairro.setEditable(false);
        varCidade.setEditable(false);
        varEstado.setEditable(false);
        alterar = false;
    }

    public ClienteCadastro(Cliente cliente) {
        initComponents();
        clienteDao = new ClienteDaoImpl();
        lb_titulo.setText("Alterar Cliente");
        this.cliente = cliente;
        alterar = true;
        carregarDadosCliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        lb_titulo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        lb_cep = new javax.swing.JLabel();
        varCep = new javax.swing.JTextField();
        btBuscarCep = new javax.swing.JButton();
        lb_rua = new javax.swing.JLabel();
        varRua = new javax.swing.JTextField();
        lb_cidade = new javax.swing.JLabel();
        varCidade = new javax.swing.JTextField();
        lb_email = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        lb_telefone = new javax.swing.JLabel();
        varTelefone = new javax.swing.JFormattedTextField();
        lb_bairro = new javax.swing.JLabel();
        varBairro = new javax.swing.JTextField();
        lb_estado = new javax.swing.JLabel();
        varEstado = new javax.swing.JTextField();
        lb_numero = new javax.swing.JLabel();
        varNumero = new javax.swing.JTextField();
        lb_comp = new javax.swing.JLabel();
        varComplemento = new javax.swing.JTextField();
        lb_obs = new javax.swing.JLabel();
        pn_obs = new javax.swing.JScrollPane();
        varObservacao = new javax.swing.JTextArea();
        btVoltar = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal");

        lb_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Cadastro Cliente");

        lb_nome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_nome.setText("Nome:");

        btSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        lb_cep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_cep.setText("CEP:");

        btBuscarCep.setText("Buscar");
        btBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarCepActionPerformed(evt);
            }
        });

        lb_rua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_rua.setText("Rua:");

        lb_cidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_cidade.setText("Cidade:");

        lb_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_email.setText("E-mail:");

        varEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varEmailFocusLost(evt);
            }
        });

        lb_telefone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_telefone.setText("Telefone:");

        try {
            varTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varTelefoneFocusLost(evt);
            }
        });

        lb_bairro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_bairro.setText("Bairro:");

        lb_estado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_estado.setText("Estado:");

        lb_numero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_numero.setText("Número:");

        lb_comp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_comp.setText("Comp:");

        lb_obs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_obs.setText("Obs.:");

        varObservacao.setColumns(20);
        varObservacao.setRows(5);
        pn_obs.setViewportView(varObservacao);

        btVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pn_obs, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_rua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_telefone)
                            .addComponent(lb_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(varBairro)
                                .addComponent(varRua)
                                .addComponent(varEmail)
                                .addComponent(varNome)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(varCep, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(varEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(varCidade)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_nome)
                        .addGap(17, 17, 17)
                        .addComponent(lb_email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_telefone))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lb_cep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_rua))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btBuscarCep)
                            .addComponent(varCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_bairro)
                    .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_cidade)
                    .addComponent(varCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_estado)
                    .addComponent(varEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_numero)
                    .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_comp)
                    .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(pn_obs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validarFormulario()) {
            session = HibernateUtil.abrirConexao();
            if (alterar) {
                atualizarCliente();
            } else {
                cliente = carregarCliente();
            }
            try {
                clienteDao.salvarOuAlterar(cliente, session);
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
                if (alterar) {
                    this.dispose();
                }
                limparCampos();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar cadastro.");
            } finally {
                session.close();
            }
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void carregarDadosCliente() {
        varNome.setText(cliente.getNome());
        varTelefone.setText(cliente.getTelefone());
        varEmail.setText(cliente.getEmail());

        endereco = cliente.getEnderecos().get(0);
        varCep.setText(endereco.getCep());
        varRua.setText(endereco.getLogradouro());
        varBairro.setText(endereco.getBairro());
        varNumero.setText(endereco.getNumero());
        varCidade.setText(endereco.getCidade());
        varEstado.setText(endereco.getEstado());
        varComplemento.setText(endereco.getComplemento());
        varObservacao.setText(endereco.getObservacao());
    }

    private void atualizarCliente() {
        cliente.setNome(varNome.getText().trim());
        cliente.setEmail(varEmail.getText().trim());
        cliente.setTelefone(varTelefone.getText());
        cliente.getEnderecos().get(0).setLogradouro(varRua.getText().trim());
        cliente.getEnderecos().get(0).setBairro(varBairro.getText().trim());
        cliente.getEnderecos().get(0).setCep(varCep.getText().trim());
        cliente.getEnderecos().get(0).setNumero(varNumero.getText().trim());
        cliente.getEnderecos().get(0).setCidade(varCidade.getText().trim());
        cliente.getEnderecos().get(0).setComplemento(varComplemento.getText().trim());
        cliente.getEnderecos().get(0).setObservacao(varObservacao.getText().trim());
        cliente.getEnderecos().get(0).setEstado(varEstado.getText().trim());
    }

    private Cliente carregarCliente() {
        cliente = new Cliente();
        cliente.setNome(varNome.getText().trim());
        cliente.setEmail(varEmail.getText().trim());
        cliente.setTelefone(varTelefone.getText());

        List<Endereco> enderecos = new ArrayList<>();
        endereco = new Endereco();
        endereco.setLogradouro(varRua.getText().trim());
        endereco.setBairro(varBairro.getText().trim());
        endereco.setCep(varCep.getText().trim());
        endereco.setNumero(varNumero.getText().trim());
        endereco.setCidade(varCidade.getText().trim());
        endereco.setComplemento(varComplemento.getText().trim());
        endereco.setObservacao(varObservacao.getText().trim());
        endereco.setEstado(varEstado.getText().trim());

        enderecos.add(endereco);
        endereco.setPessoa(cliente);
        cliente.setEnderecos(enderecos);

        return cliente;
    }

    private boolean validarFormulario() {
        String nome = varNome.getText().trim();
        if (verificarCampoMaior3(nome)) {
            JOptionPane.showMessageDialog(null, "O nome tem que ter "
                    + "pelo menos 3 letras");
            return false;
        }
        String email = varEmail.getText().trim();
        if (verificarEmail(email)) {
            JOptionPane.showMessageDialog(null, "Digite um e-mail correto!");
            return false;
        }
        if (varTelefone.getText().length() != 14) {
            JOptionPane.showMessageDialog(null, "Digite um telefone correto!");
            return false;
        }
        return verificarEndereco();
    }

    private boolean verificarEndereco() {
        if (varCep.getText().length() != 8) {
            JOptionPane.showMessageDialog(null, "Digite um cep correto!");
            return false;
        }
        if (verificarCampoMaior3(varRua.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Digite uma rua correta!");
            return false;
        }
        if (verificarCampoMaior3(varBairro.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um bairro correto!");
            return false;
        }
        if (verificarCampoMaior3(varCidade.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Digite uma cidade correta!");
            return false;
        }
        if (varEstado.getText().length() != 2) {
            JOptionPane.showMessageDialog(null, "Digite um estado correto!");
            return false;
        }
        return true;
    }

    private boolean verificarCampoMaior3(String campo) {
        return campo.length() < 3;
    }

    private boolean verificarEmail(String email) {
        return !email.contains("@") && !email.contains(".");
    }

    private void limparCampos() {
        varNome.setText("");
        varEmail.setText("");
        varTelefone.setText("");
        varCep.setText("");
        varRua.setText("");
        varBairro.setText("");
        varCidade.setText("");
        varEstado.setText("");
        varNumero.setText("");
        varComplemento.setText("");
        varObservacao.setText("");
    }

    private void btBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCepActionPerformed
        CepRest cepRest = new CepRest();
        EnderecoDTO enderecoDTO = cepRest.pesquisarCep(varCep.getText());
        if (enderecoDTO == null) {
            JOptionPane.showMessageDialog(null, "CEP não encontrado!");
        } else {
            varRua.setText(enderecoDTO.getLogradouro());
            varBairro.setText(enderecoDTO.getBairro());
            varCidade.setText(enderecoDTO.getLocalidade());
            varEstado.setText(enderecoDTO.getUf());
            varRua.setEditable(true);
            varBairro.setEditable(true);
            varCidade.setEditable(true);
            varEstado.setEditable(true);
        }
    }//GEN-LAST:event_btBuscarCepActionPerformed

    private void varEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varEmailFocusLost
        String email = varEmail.getText().trim();
        if (email.contains("@") && cliente == null) {
            session = HibernateUtil.abrirConexao();
            boolean existe = clienteDao
                    .verificarEmailCadastrado(email, session);
            session.close();
            if (existe) {
                JOptionPane.showMessageDialog(null, "Esse e-mail já está cadastrado!");
                varEmail.setText("");
            }
        }
    }//GEN-LAST:event_varEmailFocusLost

    private void varTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varTelefoneFocusLost
        String telefone = varTelefone.getText();
        if (telefone.length() == 14 && cliente == null) {
            session = HibernateUtil.abrirConexao();
            boolean existe = clienteDao.verificarTelefoneCadastrado(telefone, session);
            session.close();
            if (existe) {
                JOptionPane.showMessageDialog(null, "Esse numero já está cadastrado!");
                varTelefone.setText("");
            }
        }
    }//GEN-LAST:event_varTelefoneFocusLost

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarCep;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lb_bairro;
    private javax.swing.JLabel lb_cep;
    private javax.swing.JLabel lb_cidade;
    private javax.swing.JLabel lb_comp;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_estado;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_numero;
    private javax.swing.JLabel lb_obs;
    private javax.swing.JLabel lb_rua;
    private javax.swing.JLabel lb_telefone;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JScrollPane pn_obs;
    private javax.swing.JTextField varBairro;
    private javax.swing.JTextField varCep;
    private javax.swing.JTextField varCidade;
    private javax.swing.JTextField varComplemento;
    private javax.swing.JTextField varEmail;
    private javax.swing.JTextField varEstado;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNumero;
    private javax.swing.JTextArea varObservacao;
    private javax.swing.JTextField varRua;
    private javax.swing.JFormattedTextField varTelefone;
    // End of variables declaration//GEN-END:variables
}
