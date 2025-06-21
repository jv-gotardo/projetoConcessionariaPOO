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
    
    public Contrato(Financiamento financiamento, String termos_Contrato, LocalDate dataAssinatura,
            LocalDate dataVencimento){
        financiamento = this.financiamento;
        termos_Contrato = this.termos_Contrato;
        dataAssinatura = this.dataAssinatura;
        dataVencimento = this.dataVencimentoPrevista;
    }
}
