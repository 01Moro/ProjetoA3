/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author jvmor
 */
public class pacienteLogin {
    private String CPF_PACIENTE;
    private String SENHA_PACIENTE;
    
    public pacienteLogin(String CPF_PACIENTE, String SENHA_PACIENTE){
        this.CPF_PACIENTE = CPF_PACIENTE;
        this.SENHA_PACIENTE = SENHA_PACIENTE;
    }
    public String getCPF_PACIENTE() {
        return CPF_PACIENTE;
    }

    public void setCPF_PACIENTE(String CPF_PACIENTE) {
        this.CPF_PACIENTE = CPF_PACIENTE;
    }

    public String getSENHA_PACIENTE() {
        return SENHA_PACIENTE;
    }

    public void setSENHA_PACIENTE(String SENHA_PACIENTE) {
        this.SENHA_PACIENTE = SENHA_PACIENTE;
    }

}
