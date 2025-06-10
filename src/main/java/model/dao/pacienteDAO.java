/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Connectionfactory.conexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.buscarDadosp;
import model.bean.paciente;
import model.bean.pacienteLogin;

/**
 *
 * @author jvmor
 */
public class pacienteDAO {
    //Usado para o login
    public boolean existe(pacienteLogin paciente)throws Exception{
        String sql = "SELECT * FROM paciente WHERE CPF = ? AND SENHA_PACIENTE = ?";
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, paciente.getCPF_PACIENTE());
            ps.setString(2, paciente.getSENHA_PACIENTE());
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    //Usado para excluir a conta
    public boolean excluir(pacienteLogin paciente) throws Exception{
        String sql = "DELETE FROM paciente WHERE CPF = ?";
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, paciente.getCPF_PACIENTE());
            int linhasafetadas = ps.executeUpdate();
            
            return linhasafetadas > 0;
        }
    }
    //Usado no cadastro
    public void cadastrar (paciente paciente)throws Exception{
        String sql = "INSERT INTO paciente (NOME_COMPLETO,CPF,SENHA_PACIENTE,DATA_DE_NASCIMENTO) VALUES(?,?,?,?)";
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, paciente.getNOME_COMPLETO());
            ps.setString(2, paciente.getCPF_PACIENTE());
            ps.setString(3, paciente.getSENHA_PACIENTE());
            ps.setDate(4, paciente.getDATA_DE_NASCIMENTO());
            ps.execute();
        }
    }
    //Usado para confirmar o paciente quando confirmar consulta
    public int buscarIDPaciente(String CPF_PACIENTE) throws SQLException{
        String sql = "SELECT ID_PACIENTE FROM paciente WHERE CPF = ?";
        
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, CPF_PACIENTE);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ID_PACIENTE");
            }
        }
        return -1;
    }
    //Usado para confirmar o paciente quando confirmar consulta
    public String confirmarPaciente(String CPF_PACIENTE) throws SQLException{
        String sql = "SELECT NOME_COMPLETO FROM paciente WHERE CPF = ?";
        
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, CPF_PACIENTE);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("NOME_COMPLETO");
            }
        }
        return null;
    }
    //Usado para mostar os dados pessoais do cliente
    public buscarDadosp buscarPacienteporCPF(String cpf) {
        buscarDadosp dados = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = conexaoDB.obtemConexao();
            String sql = "SELECT NOME_COMPLETO, CPF, DATA_DE_NASCIMENTO FROM paciente WHERE CPF = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();

            if (rs.next()) {
                dados = new buscarDadosp();
                dados.setNome(rs.getString("NOME_COMPLETO"));
                dados.setCpf(rs.getString("CPF"));
                dados.setDataNascimento(rs.getDate("DATA_DE_NASCIMENTO"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar paciente: " + e.getMessage());
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
}

