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
import java.util.ArrayList;
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
    public int buscarMediconome(String NOME_COMPLETO) throws SQLException{
        String sql = "SELECT ID_MEDICO FROM medico WHERE NOME_COMPLETO = ?";
        
        try(Connection conn = conexaoDB.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, NOME_COMPLETO);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ID_MEDICO");
            }
        }
        return -1;
    }
    //Usado para buscar o id do medico pelo cpf e crm
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
}
