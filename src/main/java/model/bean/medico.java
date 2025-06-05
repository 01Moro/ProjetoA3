/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author jvmor
 */
public class medico {
    private String CPF_MEDICO;
    private String CRM;
    private String SEHNA_MEDICO;
    private int ID_MEDICO;
    
    public medico(int ID_MEDICO, String CRM, String CPF_MEDICO, String SENHA_MEDICO){
        
        this.CRM = CRM;
        this.CPF_MEDICO = CPF_MEDICO;
        this.SEHNA_MEDICO = SENHA_MEDICO;
        this.ID_MEDICO = ID_MEDICO;
        
    }

    public String getCPF_MEDICO() {
        return CPF_MEDICO;
    }

    public void setCPF_MEDICO(String CPF_MEDICO) {
        this.CPF_MEDICO = CPF_MEDICO;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getSEHNA_MEDICO() {
        return SEHNA_MEDICO;
    }

    public void setSEHNA_MEDICO(String SEHNA_MEDICO) {
        this.SEHNA_MEDICO = SEHNA_MEDICO;
    }

    public int getID_MEDICO() {
        return ID_MEDICO;
    }

    public void setID_MEDICO(int ID_MEDICO) {
        this.ID_MEDICO = ID_MEDICO;
    }
    
}
