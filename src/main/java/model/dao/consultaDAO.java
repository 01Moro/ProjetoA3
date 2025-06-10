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
import javax.swing.table.DefaultTableModel;
import model.bean.ConsultaResumoc;
import model.bean.ConsultaResumom;

/**
 *
 * @author jvmor
 */
public class consultaDAO {
    //Usado na tela para marcar consulta
    public void consultaMarcar(Date DATA_DA_CONSULTA, Time HORA_DA_CONSULTA, Time HORA_FIM_CONSULTA, int ID_MEDICO, int ID_PACIENTE)throws SQLException{
        String sql = "INSERT INTO consulta_medica (DATA_DA_CONSULTA, HORA_DA_CONSULTA, HORA_FIM_CONSULTA, ID_MEDICO, ID_PACIENTE) VALUES (?, ?, ?, ?, ?)";
        
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDate(1, DATA_DA_CONSULTA);
            ps.setTime(2, HORA_DA_CONSULTA);
            ps.setTime(3, HORA_FIM_CONSULTA);
            ps.setInt(4, ID_MEDICO);
            ps.setInt(5, ID_PACIENTE);
            ps.executeUpdate();
        }
    }
    //Usado para colocar a consulta na tabela na tela do paciente
    public List<ConsultaResumoc> listarConsultasPaciente(int ID_PACIENTE){
        List<ConsultaResumoc> lista = new ArrayList<>();
        
        String sql = "SELECT c.ID_CONSULTA, c.DATA_DA_CONSULTA, c.HORA_DA_CONSULTA, m.NOME_COMPLETO, m.CRM " +
                    "FROM consulta_medica c JOIN medico m ON c.ID_MEDICO = m.ID_MEDICO " +
                    "WHERE c.ID_PACIENTE = ?";
        
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setInt(1, ID_PACIENTE);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int ID_CONSULTA = rs.getInt("ID_CONSULTA");
                Date DATA_DA_CONSULTA = rs.getDate("DATA_DA_CONSULTA");
                Time HORA_DA_CONSULTA = rs.getTime("HORA_DA_CONSULTA");
                String NOME_COMPLETO = rs.getString("NOME_COMPLETO");
                String CRM = rs.getString("CRM");
                
                String dataHora = DATA_DA_CONSULTA.toString() + " " + HORA_DA_CONSULTA.toString();
                String medicoCrm = NOME_COMPLETO + " (CRM " + CRM + ")"; 
                
                lista.add(new ConsultaResumoc(ID_CONSULTA, dataHora, medicoCrm));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    //Usado para colocar a consulta na tabela na tela do medico
    public List<ConsultaResumom> listarConsultasDoMedico(int idMedico) {
        List<ConsultaResumom> lista = new ArrayList<>();
        String sql = "SELECT c.ID_CONSULTA, c.DATA_DA_CONSULTA, c.HORA_DA_CONSULTA, " +
                     "p.NOME_COMPLETO AS NOME_PACIENTE, p.CPF AS CPF_PACIENTE " +
                     "FROM consulta_medica c " +
                     "JOIN paciente p ON c.ID_PACIENTE = p.ID_PACIENTE " +
                     "WHERE c.ID_MEDICO = ?";

        try (Connection conn = conexaoDB.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ConsultaResumom resumo = new ConsultaResumom();
                resumo.setIdConsulta(rs.getInt("ID_CONSULTA"));
                resumo.setDataHora(rs.getDate("DATA_DA_CONSULTA") + " " + rs.getTime("HORA_DA_CONSULTA"));
                resumo.setPacienteCpf(rs.getString("NOME_PACIENTE") + " - " + rs.getString("CPF_PACIENTE"));
                lista.add(resumo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    //Usado para excluir consultas antes de excluir a conta
    public int excluir(int ID_PACIENTE) throws Exception{
        String sql = "DELETE FROM consulta_medica WHERE ID_PACIENTE = ?";
        
        try (Connection conn = conexaoDB.obtemConexao(); PreparedStatement psConsultas = conn.prepareStatement(sql)) {
        psConsultas.setInt(1, ID_PACIENTE); // Supondo que você tem esse método
        int linhasafetadas = psConsultas.executeUpdate();
        
        return linhasafetadas;
    }
    }
    public boolean cancelarConsulta(int idConsulta) {
        String sql = "DELETE FROM consulta_medica WHERE ID_CONSULTA = ?";
    
        try (Connection conn = conexaoDB.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
        
            ps.setInt(1, idConsulta);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
