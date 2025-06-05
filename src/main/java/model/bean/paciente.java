/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author jvmor
 */
public class paciente {
    private String CPF_PACIENTE;
    private String NOME_COMPLETO;
    private String SENHA_PACIENTE;
    private Date DATA_DE_NASCIMENTO;
    
    public paciente(String NOME_COMPLETO, String CPF_PACIENTE, String SENHA_PACIENTE, Date DATA_DE_NASCIMENTO) {
        this.NOME_COMPLETO = NOME_COMPLETO;
        this.CPF_PACIENTE = CPF_PACIENTE;
        this.SENHA_PACIENTE = SENHA_PACIENTE;
        this.DATA_DE_NASCIMENTO = DATA_DE_NASCIMENTO;
    }

    public String getCPF_PACIENTE() {
        return CPF_PACIENTE;
    }

    public void setCPF_PACIENTE(String CPF_PACIENTE) {
        this.CPF_PACIENTE = CPF_PACIENTE;
    }

    public String getNOME_COMPLETO() {
        return NOME_COMPLETO;
    }

    public void setNOME_COMPLETO(String NOME_COMPLETO) {
        this.NOME_COMPLETO = NOME_COMPLETO;
    }

    public String getSENHA_PACIENTE() {
        return SENHA_PACIENTE;
    }

    public void setSENHA_PACIENTE(String SENHA_PACIENTE) {
        this.SENHA_PACIENTE = SENHA_PACIENTE;
    }

    public Date getDATA_DE_NASCIMENTO() {
        return DATA_DE_NASCIMENTO;
    }

    public void setDATA_DE_NASCIMENTO(Date DATA_DE_NASCIMENTO) {
        this.DATA_DE_NASCIMENTO = DATA_DE_NASCIMENTO;
    }
    
    
    
}
