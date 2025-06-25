/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo.enums;

/**
 *
 * @author jvito
 */
public enum TipoPagamento {
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    PIX("PIX"),
    DINHEIRO("Dinheiro"),
    BOLETO_BANCARIO("Boleto Bancário");

    public final String CODIGO;
    
    TipoPagamento(String codigoString){
        this.CODIGO = codigoString;
    }
}
