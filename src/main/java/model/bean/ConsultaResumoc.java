/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author jvmor
 */
public class ConsultaResumoc {
    private int idConsulta;
    private String dataHora;
    private String medicoCrm;
    
    public ConsultaResumoc(int idConsulta, String dataHora, String medicoCrm){
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.medicoCrm = medicoCrm; 
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getMedicoCrm() {
        return medicoCrm;
    }

    public void setMedicoCrm(String medicoCrm) {
        this.medicoCrm = medicoCrm;
    }
}
