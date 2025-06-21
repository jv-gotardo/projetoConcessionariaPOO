/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import modelo.enums.StatusPagamento;
import modelo.enums.TipoPagamento;

/**
 *
 * @author jvito
 */
public class Pagamento {
    private Venda venda;
    private TipoPagamento tipoPagamento;
    private double valorPago;
    private LocalDate dataPagamento;
    private StatusPagamento statusPagamento;
    
    public Pagamento(Venda venda, TipoPagamento tipoPagamento, double valorPago,
            LocalDate dataPagamento){
        venda = this.venda;
        tipoPagamento = this.tipoPagamento;
        valorPago = this.valorPago;
        dataPagamento = this.dataPagamento;
    }
}
