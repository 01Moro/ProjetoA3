/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import model.bean.ConsultaResumom;
import model.bean.buscarDadosm;
import model.bean.medico;
import model.bean.medicoLogin;
import model.bean.pacienteLogin;
import model.dao.consultaDAO;
import model.dao.medicoDAO;
import model.dao.pacienteDAO;

/**
 *
 * @author jvmor
 */
public class TelaMedico extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private int idMedicologado;
    public TelaMedico() {
        initComponents();
        
        
        jTabbedPane1.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
        @Override
        protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
            return 0;
        }
        });
    }
    //Coloca as consultas na tela do medico
    private void carregarConsultasDoMedico() {
        try {
            // Pega o CRM do médico logado
            String identificador = txtCRM.getText().trim();

            // Busca o ID do médico
            medicoDAO daoMedico = new medicoDAO();
            int idMedico = daoMedico.buscarMedico(identificador);

            if (idMedico == -1) {
                System.out.println("Médico não encontrado!");
                return;
            }

            // Modelo da tabela
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.setColumnIdentifiers(new String[]{"ID Consulta", "Data e Hora", "Paciente"});

            // Consulta no banco
            consultaDAO dao = new consultaDAO();
            List<ConsultaResumom> consultas = dao.listarConsultasDoMedico(idMedico);

            for (ConsultaResumom c : consultas) {
                model.addRow(new Object[]{
                    c.getIdConsulta(),
                    c.getDataHora(),
                    c.getPacienteCpf()
                });
            }

            tabelaConsultas.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar consultas do médico.");
        }
    }
        //Coloca os dados do paciente no jLabel na tela da conta
    private void carregarDadosDoMedico(String crm) {
        try {
            medicoDAO dao = new medicoDAO();
            buscarDadosm medico = dao.buscarMedicoporCRM(crm);

            if (medico != null) {
                lblNome.setText(medico.getNome());
                lblCRM.setText(medico.getCrm());
                lblCPF.setText(medico.getCpf());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                lblDatanascimento.setText(sdf.format(medico.getDataNascimento()));
            } else {
                JOptionPane.showMessageDialog(this, "Medico não encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados do paciente.");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCRM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblCRM = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDatanascimento = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("CRM");

        txtCRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCRMActionPerformed(evt);
            }
        });

        jLabel2.setText("Senha");

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Login");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel4.setText("CPF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(txtSenha)
                        .addComponent(jLabel1)
                        .addComponent(txtCRM)
                        .addComponent(jLabel4)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agendamentos"));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar consulta");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tabelaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Data e Hora", "Paciente"
            }
        ));
        jScrollPane1.setViewportView(tabelaConsultas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addGap(244, 244, 244)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnVoltar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel5.setText("Dados pessoais");

        lblCRM.setText("CRM");

        lblCPF.setText("CPF");

        lblNome.setText("NOME");

        lblDatanascimento.setText("DATA DE NASCIMENTO");

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel10.setText("Conta");

        jButton1.setText("Minha consultas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSair.setText("Sair da conta");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(btnSair))
                        .addGap(170, 170, 170)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatanascimento)
                            .addComponent(lblNome)
                            .addComponent(lblCPF)
                            .addComponent(lblCRM)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel10))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCRM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDatanascimento)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel3);

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
    }// </editor-fold>//GEN-END:initComponents

    private void txtCRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCRMActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        
        String CPF_MEDICO = txtCPF.getText();
        String CRM = txtCRM.getText();
        String SENHA_MEDICO = new String (txtSenha.getPassword());
        
        try{
            if(CPF_MEDICO.length() > 0 && CRM.length() > 0 && SENHA_MEDICO.length() > 0){
                medicoLogin medico = new medicoLogin(CPF_MEDICO, CRM, SENHA_MEDICO);
                medicoDAO dao = new medicoDAO();
                if(dao.existe(medico)){
                    JOptionPane.showMessageDialog(null, "Bem vindo!");
                    jTabbedPane1.setSelectedIndex(2);
                    carregarConsultasDoMedico();
                    carregarDadosDoMedico(CRM);
                    dao.atualizarStatusAtivoCRM(CRM, true);
                    idMedicologado = dao.buscarMedico(CRM);
                    System.out.println("ID do medico: " + idMedicologado);
                }
                else{
                    JOptionPane.showMessageDialog(null, "CPF ou Senha Invalido.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Texto inválido.");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Problemas técnicos. Tente novamente mais tarde.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        carregarConsultasDoMedico();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaConsultas.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma coluna para cancelar");
            return;
        }
        
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar esta consulta?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacao != JOptionPane.YES_OPTION){
            return;
        }
        
        int idConsulta = (int) tabelaConsultas.getValueAt(linhaSelecionada, 0);
        
        consultaDAO dao = new consultaDAO();
        boolean sucesso = dao.cancelarConsulta(idConsulta);
        
        if(sucesso) {
            JOptionPane.showMessageDialog(null, "Consulta cancelada!");
            carregarConsultasDoMedico(); //atualiza a tabela
        }
        else {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar a consulta.");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        String CRM = txtCRM.getText();
        
        medicoDAO dao = new medicoDAO();
        dao.atualizarStatusAtivoID(idMedicologado, false); // desativa o médico
        JOptionPane.showMessageDialog(this, "Você saiu da conta.");

        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        medicoDAO dao = new medicoDAO();
        dao.atualizarStatusAtivoID(idMedicologado, false);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCRM;
    private javax.swing.JLabel lblDatanascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tabelaConsultas;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCRM;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}

