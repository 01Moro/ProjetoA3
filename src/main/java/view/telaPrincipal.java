/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import model.bean.ConsultaResumoc;
import model.bean.buscarDadosp;
import model.bean.medico;
import model.bean.paciente;
import model.bean.pacienteLogin;
import model.dao.consultaDAO;
import model.dao.medicoDAO;
import model.dao.pacienteDAO;

/**
 *
 * @author jvmor
 */
public class telaPrincipal extends javax.swing.JFrame {
    // Variavel para saber se tem uma conta logada
    boolean logado;
    public telaPrincipal() {
        initComponents();
        carregarMedicos();
        carregarConsultasNaTabela();
        // Oculta as abas do JTabbedPane
    jTabbedPane1.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                return 0;
            }
        });
        //Coloca uma data minima para o JCalendar
        Calendario.setMinSelectableDate(new java.util.Date());
        //Transforma o JCalendar em "ActionPerformed"
        Calendario.addPropertyChangeListener("calendar", new java.beans.PropertyChangeListener(){
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                java.util.Date dataSelecionada = Calendario.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
                lblDataConsulta.setText("Data: " + sdf.format(dataSelecionada));
                jTabbedPane1.setSelectedIndex(5);
            }
        });
        //JDatechooser do cadastro bloquear datas futuras
        // Pega a data de hoje
        java.util.Date hoje = new java.util.Date();

        // Define o limite máximo para hoje
        txtDatanascimento.setMaxSelectableDate(hoje);
    }
    
    //Seleção de medicos na tela de confirmar a consulta baseada no banco de dados
    private void carregarMedicos(){
        medicoDAO medicoDAO = new medicoDAO();
        ArrayList<String> medicosAtivos = medicoDAO.listarMedicosAtivos();
        
        for(String nome : medicosAtivos){
            selecionarMedico.addItem(nome);
        }
    }
    //Adicionar consultas na tabela
    private void carregarConsultasNaTabela() {
        try {
            // Cria um modelo não editável
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Bloqueia edição
                }
            };

            // Define as colunas (cabeçalhos)
            model.setColumnIdentifiers(new String[]{"ID Consulta", "Data e Hora", "Médico e CRM"});

            // Consulta os dados no banco
            consultaDAO dao = new consultaDAO();
            List<ConsultaResumoc> consultas = dao.listarConsultasPaciente();

            // Preenche a tabela
            for (ConsultaResumoc c : consultas) {
            model.addRow(new Object[]{
                c.getIdConsulta(),
                c.getDataHora(),
                c.getMedicoCrm()
                });
            }

            // Define o modelo na tabela
            tabelaConsultas.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar consultas: " + e.getMessage());
            }
    }
    //Coloca os dados do paciente no jLabel na tela da conta
    private void carregarDadosDoPaciente(String cpfPaciente) {
        try {
            pacienteDAO dao = new pacienteDAO();
            buscarDadosp paciente = dao.buscarPacienteporCPF(cpfPaciente);

            if (paciente != null) {
                lblNome.setText(paciente.getNome());
                lblCPF.setText(paciente.getCpf());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                lblDatanascimento.setText(sdf.format(paciente.getDataNascimento()));
            } else {
                JOptionPane.showMessageDialog(this, "Paciente não encontrado.");
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
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnCadastro = new javax.swing.JButton();
        btnVoltarCad = new javax.swing.JButton();
        txtDatanascimento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Calendario = new com.toedter.calendar.JCalendar();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCPFlogin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnVoltarLogin = new javax.swing.JButton();
        txtSenhalogin = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblDataConsulta = new javax.swing.JLabel();
        selecionarHora = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        selecionarMedico = new javax.swing.JComboBox<>();
        txtConfirmarCPF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblNomepaciente = new javax.swing.JLabel();
        btnMarcarconsulta = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblDatanascimento = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnCancelarconsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setText("Marcar consulta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sobre nós");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Conta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("telaPrincipal", jPanel1);

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        jLabel4.setText("Senha");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        btnCadastro.setText("Enviar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnVoltarCad.setText("Voltar");
        btnVoltarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarCadActionPerformed(evt);
            }
        });

        txtDatanascimento.setDateFormatString("d-M-yyyy");

        jLabel7.setText("Data de nascimento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnVoltarCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastro))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtNome)
                    .addComponent(txtCPF)
                    .addComponent(txtDatanascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatanascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarCad)
                    .addComponent(btnCadastro))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("telaCadastro", jPanel2);

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel14.setText("Marcar consulta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Calendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(Calendario, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("telaMarcarconsulta", jPanel3);

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));

        jLabel11.setText("blablablablablablablablablablablabla");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel11)
                .addContainerGap(358, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel11)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("telaSobre", jPanel4);

        jLabel1.setText("CPF");

        jLabel8.setText("Senha");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnVoltarLogin.setText("Voltar");
        btnVoltarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarLoginActionPerformed(evt);
            }
        });

        txtSenhalogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaloginActionPerformed(evt);
            }
        });

        jLabel9.setText("Não tem conta? Cadastre-se");

        jLabel10.setForeground(new java.awt.Color(102, 204, 255));
        jLabel10.setText("aqui");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addComponent(jLabel1)
                        .addComponent(txtCPFlogin)
                        .addComponent(txtSenhalogin)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(btnVoltarLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                            .addComponent(btnLogin))))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPFlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenhalogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarLogin)
                    .addComponent(btnLogin))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("telaLogin", jPanel5);

        lblDataConsulta.setText("DATA");

        selecionarHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00", "18:00" }));

        jLabel5.setText("Selecione o médico e a hora:");

        jButton7.setText("Voltar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        selecionarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarMedicoActionPerformed(evt);
            }
        });

        jLabel13.setText("Confirme seu CPF:");

        lblNomepaciente.setText("Nome paciente");
        lblNomepaciente.setEnabled(false);

        btnMarcarconsulta.setText("Agendar");
        btnMarcarconsulta.setEnabled(false);
        btnMarcarconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarconsultaActionPerformed(evt);
            }
        });

        jButton4.setText("Confirmar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataConsulta)
                    .addComponent(jLabel5)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(selecionarMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(selecionarHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jButton7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMarcarconsulta))
                        .addComponent(txtConfirmarCPF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(lblNomepaciente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                            .addComponent(jButton4))))
                .addGap(0, 430, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblDataConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecionarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selecionarHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomepaciente)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(btnMarcarconsulta))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("telaMarcarconsulta2", jPanel7);

        jButton5.setText("Meus agendamentos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Excluir conta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("Voltar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel15.setText("Dados Pessoais");

        lblNome.setText("Nome");

        lblCPF.setText("CPF");

        lblDatanascimento.setText("Data de nascimento");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(146, 146, 146))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatanascimento)
                            .addComponent(lblCPF)
                            .addComponent(lblNome)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDatanascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(86, 86, 86)
                .addComponent(jButton8)
                .addContainerGap())
        );

        jTabbedPane1.addTab("telaConta", jPanel9);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Agendamentos"));

        btnAtualizar.setText("Atualizar");

        jButton10.setText("Voltar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnCancelarconsulta.setText("Cancelar consulta");

        tabelaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Data e Horário", "Médico"
            }
        ));
        jScrollPane1.setViewportView(tabelaConsultas);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton10)
                .addGap(171, 171, 171)
                .addComponent(btnCancelarconsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(btnAtualizar)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(jButton10)
                    .addComponent(btnCancelarconsulta))
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("telaAgendamentos", jPanel10);

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(logado == false){
            jTabbedPane1.setSelectedIndex(4);
            JOptionPane.showMessageDialog(null, "Você precisa estar logado para marcar uma consulta.");
        }else{
        jTabbedPane1.setSelectedIndex(2);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(logado == true){
            jTabbedPane1.setSelectedIndex(6);
        }
        else{
            jTabbedPane1.setSelectedIndex(4);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVoltarCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarCadActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnVoltarCadActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // TODO add your handling code here:
        java.util.Date dataUtil = txtDatanascimento.getDate(); // pega do JDateChooser
        // Formatar como String se precisar exibir
        SimpleDateFormat formato = new SimpleDateFormat("d-M-yyyy");
        String dataFormatada = formato.format(dataUtil);
        // Converter para java.sql.Date para salvar no banco
        java.sql.Date DATA_DE_NASCIMENTO = new java.sql.Date(dataUtil.getTime());
        
        String SENHA_PACIENTE = new String(txtSenha.getPassword());
        
        String NOME_COMPLETO = txtNome.getText();
        String CPF_PACIENTE = txtCPF.getText();
        
        try{
            if(NOME_COMPLETO.length() > 5 && CPF_PACIENTE.length() > 5 && SENHA_PACIENTE.length() > 5 && DATA_DE_NASCIMENTO != null){
            paciente paciente = new paciente(NOME_COMPLETO, CPF_PACIENTE, SENHA_PACIENTE, DATA_DE_NASCIMENTO);
            pacienteDAO dao = new pacienteDAO();
            System.out.println("NOME_COMPLETO: " + NOME_COMPLETO);
            System.out.println("CPF_PACIENTE: " + CPF_PACIENTE);
            System.out.println("SENHA_PACIENTE: " + SENHA_PACIENTE);
            System.out.println("DATA_DE_NASCIMENTO: " + DATA_DE_NASCIMENTO);
            dao.cadastrar(paciente);
            JOptionPane.showMessageDialog(null, "Conta criada!");
            jTabbedPane1.setSelectedIndex(0);
            }
            else{
                JOptionPane.showMessageDialog(null, "Texto inválido.");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar.");
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
        String CPF_PACIENTE = txtCPFlogin.getText();
        String SENHA_PACIENTE = new String (txtSenhalogin.getPassword());
        
        try{
            if(CPF_PACIENTE.length() > 0 && SENHA_PACIENTE.length() > 0){
                pacienteLogin paciente = new pacienteLogin(CPF_PACIENTE, SENHA_PACIENTE);
                pacienteDAO dao = new pacienteDAO();
                if(dao.existe(paciente)){
                    JOptionPane.showMessageDialog(null, "Bem vindo!");
                    logado = true;
                    jTabbedPane1.setSelectedIndex(6);
                    carregarDadosDoPaciente(CPF_PACIENTE);
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
                    }
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void txtSenhaloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaloginActionPerformed

    private void btnVoltarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarLoginActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnVoltarLoginActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        JTextField txtCPF = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        
        Object[] message = {
            "CPF:", txtCPF,
            "Senha:", txtSenha
        };
        
        int option = JOptionPane.showConfirmDialog(null, message, "Excluir Conta", JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION) {
            String CPF_PACIENTE = txtCPF.getText();
            String SENHA_PACIENTE = new String(txtSenha.getPassword());
        
        
            try{
                pacienteLogin paciente = new pacienteLogin(CPF_PACIENTE, SENHA_PACIENTE);
                pacienteDAO dao = new pacienteDAO();
                if(dao.existe(paciente)){
                    boolean sucesso = dao.excluir(paciente);
                    if(sucesso){
                        JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
                        jTabbedPane1.setSelectedIndex(0);
                        logado = false;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possível excluir.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "CPF ou Senha inválido.");
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"Problemas técnicos. Tente novamente mais tarde.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Usuário cancelou.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnMarcarconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarconsultaActionPerformed
        // TODO add your handling code here:
        try{
            pacienteDAO daop = new pacienteDAO();
            medicoDAO daom = new medicoDAO();
            consultaDAO daoc = new consultaDAO();
            
            //Pegar a data
            java.util.Date data = Calendario.getDate();
            Date dataSQL = new Date(data.getTime());
            
            //Pegar a hora
            String hora = (String) selecionarHora.getSelectedItem();
            Time horaSQL = Time.valueOf(hora + ":00");
            
            //Adicionar 50 min para a hora final
            long millis = horaSQL.getTime() + (50* 60 * 1000);
            Time horaFinal = new Time(millis);
            
            //Pegar ID do medico
            String nomeMedico = (String) selecionarMedico.getSelectedItem();
            int idMedico = daom.buscarMediconome(nomeMedico);
            
            //Pegar ID do paciente
            String CPFPaciente = txtConfirmarCPF.getText();
            int idPaciente = daop.buscarIDPaciente(CPFPaciente);
            
            if(idMedico == -1 || idPaciente == -1){
                JOptionPane.showMessageDialog(null, "Médico ou Paciente não encontrado!");
                return;
            }
            
            //Inserir consulta na tabela
            daoc.consultaMarcar(dataSQL, horaSQL, horaFinal, idMedico, idPaciente);
            JOptionPane.showMessageDialog(null, "Consulta marcada!");
            jTabbedPane1.setSelectedIndex(7);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao marcar a consulta: " + e.getMessage());
        }
    }//GEN-LAST:event_btnMarcarconsultaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String CPF_PACIENTE = txtConfirmarCPF.getText();
        pacienteDAO dao = new pacienteDAO();
        try {
            String NOME_COMPLETO = dao.confirmarPaciente(CPF_PACIENTE);
            
            if(NOME_COMPLETO != null){
                btnMarcarconsulta.setEnabled(true);
                lblNomepaciente.setEnabled(true);
                lblNomepaciente.setText(NOME_COMPLETO);
            }
            else{
                JOptionPane.showMessageDialog(null, "CPF inválido.");
                btnMarcarconsulta.setEnabled(false);
                lblNomepaciente.setEnabled(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao confirmar o usuário:" + e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void selecionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecionarMedicoActionPerformed

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendario;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnCancelarconsulta;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMarcarconsulta;
    private javax.swing.JButton btnVoltarCad;
    private javax.swing.JButton btnVoltarLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblDataConsulta;
    private javax.swing.JLabel lblDatanascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomepaciente;
    private javax.swing.JComboBox<String> selecionarHora;
    private javax.swing.JComboBox<String> selecionarMedico;
    private javax.swing.JTable tabelaConsultas;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCPFlogin;
    private javax.swing.JTextField txtConfirmarCPF;
    private com.toedter.calendar.JDateChooser txtDatanascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhalogin;
    // End of variables declaration//GEN-END:variables
}
