/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author jvito
 */
public class Contrato {
    private Financiamento financiamento;
    private String termos_Contrato;
    private LocalDate dataAssinatura;
    private LocalDate dataVencimentoPrevista;

    public Contrato(Financiamento financiamento, String termos_Contrato, LocalDate dataAssinatura, LocalDate dataVencimentoPrevista) {
        this.financiamento = financiamento;
        this.termos_Contrato = termos_Contrato;
        this.dataAssinatura = dataAssinatura;
        this.dataVencimentoPrevista = dataVencimentoPrevista;
    }

    public Financiamento getFinanciamento() {
        return financiamento;
    }

    public void setFinanciamento(Financiamento financiamento) {
        this.financiamento = financiamento;
    }

    public String getTermos_Contrato() {
        return termos_Contrato;
    }

    public void setTermos_Contrato(String termos_Contrato) {
        this.termos_Contrato = termos_Contrato;
    }

    public LocalDate getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(LocalDate dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public LocalDate getDataVencimentoPrevista() {
        return dataVencimentoPrevista;
    }

    public void setDataVencimentoPrevista(LocalDate dataVencimentoPrevista) {
        this.dataVencimentoPrevista = dataVencimentoPrevista;
    }

    @Override
    public String toString() {
        return "Contrato{" + "financiamento=" + financiamento + ", termos_Contrato=" + 
                termos_Contrato + ", dataAssinatura=" + dataAssinatura + ", dataVencimentoPrevista=" + 
                dataVencimentoPrevista + '}';
    }
}
