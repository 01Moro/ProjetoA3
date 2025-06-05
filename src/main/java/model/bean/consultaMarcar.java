/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author jvmor
 */
public class consultaMarcar {
    private Date DATA_DA_CONSULTA;
    private Time HORA_DA_CONSULTA;
    private Time HORA_FIM_CONSULTA;
    private int ID_MEDICO;
    private int ID_PACIENTE;
    
    public consultaMarcar(Date DATA_DA_CONSULTA, Time HORA_DA_CONSULTA, Time HORA_FIM_CONSULTA, int ID_MEDICO, int ID_PACIENTE){
        this.DATA_DA_CONSULTA = DATA_DA_CONSULTA;
        this.HORA_DA_CONSULTA = HORA_DA_CONSULTA;
        this.HORA_FIM_CONSULTA = HORA_FIM_CONSULTA;
        this.ID_MEDICO = ID_MEDICO;
        this.ID_PACIENTE = ID_PACIENTE;
    }

    public Date getDATA_DA_CONSULTA() {
        return DATA_DA_CONSULTA;
    }

    public void setDATA_DA_CONSULTA(Date DATA_DA_CONSULTA) {
        this.DATA_DA_CONSULTA = DATA_DA_CONSULTA;
    }

    public Time getHORA_DA_CONSULTA() {
        return HORA_DA_CONSULTA;
    }

    public void setHORA_DA_CONSULTA(Time HORA_DA_CONSULTA) {
        this.HORA_DA_CONSULTA = HORA_DA_CONSULTA;
    }

    public Time getHORA_FIM_CONSULTA() {
        return HORA_FIM_CONSULTA;
    }

    public void setHORA_FIM_CONSULTA(Time HORA_FIM_CONSULTA) {
        this.HORA_FIM_CONSULTA = HORA_FIM_CONSULTA;
    }

    public int getID_MEDICO() {
        return ID_MEDICO;
    }

    public void setID_MEDICO(int ID_MEDICO) {
        this.ID_MEDICO = ID_MEDICO;
    }

    public int getID_PACIENTE() {
        return ID_PACIENTE;
    }

    public void setID_PACIENTE(int ID_PACIENTE) {
        this.ID_PACIENTE = ID_PACIENTE;
    }
    
}
