/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Connectionfactory.conexaoDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.buscarDadosm;
import model.bean.medicoLogin;

/**
 *
 * @author jvmor
 */
public class medicoDAO {
    //Usado no login do medico
    public boolean existe(medicoLogin medico)throws Exception{
        String sql = "SELECT * FROM medico WHERE CRM = ? AND CPF = ? AND SENHA_MEDICO = ?";
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, medico.getCRM());
            ps.setString(2, medico.getCPF());
            ps.setString(3, medico.getSENHA());
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    //Usado para a seleçao na tela do paciente
    public ArrayList<String> listarMedicosAtivos(){
        ArrayList<String> medicos = new ArrayList<>();
        String sql = "SELECT NOME_COMPLETO FROM medico WHERE ativo = true";
        
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                medicos.add(rs.getString("NOME_COMPLETO"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return medicos;
    }
    //Usado para buscar o id do medico pelo nome
    public int buscarMediconome(String nomeMedico) {
        String sql = "SELECT ID_MEDICO FROM medico WHERE NOME_COMPLETO = ?";
    
        try (Connection conn = conexaoDB.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
        
            ps.setString(1, nomeMedico);
            ResultSet rs = ps.executeQuery();
        
            if (rs.next()) {
                return rs.getInt("ID_MEDICO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    //Usado para buscar o id do medico pelo crm
    public int buscarMedico(String CRM) {
        int id = -1;
        String sql = "SELECT ID_MEDICO FROM medico WHERE CRM = ?";
        
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, CRM);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("ID_MEDICO");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }
    //Usado para pegar os dados do medico e colocar na tela
    public buscarDadosm buscarMedicoporCRM(String crm) {
        buscarDadosm dados = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = conexaoDB.obtemConexao();
            String sql = "SELECT NOME_COMPLETO, CRM, CPF, DATA_DE_NASCIMENTO FROM medico WHERE CRM = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, crm);
            rs = ps.executeQuery();

            if (rs.next()) {
                dados = new buscarDadosm();
                dados.setNome(rs.getString("NOME_COMPLETO"));
                dados.setCrm(rs.getString("CRM"));
                dados.setCpf(rs.getString("CPF"));
                dados.setDataNascimento(rs.getDate("DATA_DE_NASCIMENTO"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar medico: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return dados;
    }
    //Usado para alterar a coluna ATIVO usando como busca do medico o crm
    public void atualizarStatusAtivoCRM(String crm, boolean statusAtivo) {
    String sql = "UPDATE medico SET ATIVO = ? WHERE CRM = ?";
    
    try (Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
        
            ps.setBoolean(1, statusAtivo);
            ps.setString(2, crm);
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Usado para buscar os horarios diponiveis do medico
    public List<String> buscarHorariosOcupados(int idMedico, Date dataConsulta) {
        List<String> ocupados = new ArrayList<>();

        String sql = "SELECT HORA_DA_CONSULTA FROM consulta_medica WHERE ID_MEDICO = ? AND DATA_DA_CONSULTA = ?";
    
        try (Connection conn = conexaoDB.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
        
            ps.setInt(1, idMedico);
            ps.setDate(2, new java.sql.Date(dataConsulta.getTime())); // ou LocalDate se usar Java 8+
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                Time hora = rs.getTime("HORA_DA_CONSULTA");
                ocupados.add(hora.toString().substring(0, 5)); // pega formato HH:mm
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ocupados;
    }
    //Usado para alterar a coluna ATIVO usando como busca do medico o id
    public void atualizarStatusAtivoID(int id, boolean statusAtivo) {
    String sql = "UPDATE medico SET ATIVO = ? WHERE ID_MEDICO = ?";
    
    try (Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
        
            ps.setBoolean(1, statusAtivo);
            ps.setInt(2, id);
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

