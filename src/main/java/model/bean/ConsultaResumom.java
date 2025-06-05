/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author jvmor
 */
public class ConsultaResumom {
    private int idConsulta;
    private String dataHora;
    private String pacienteCpf;
    
    public ConsultaResumom(){
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.pacienteCpf = pacienteCpf; 
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

        public String getPacienteCpf() {
            return pacienteCpf;
        }

        public void setPacienteCpf(String pacienteCpf) {
            this.pacienteCpf = pacienteCpf;
        }
    
}
