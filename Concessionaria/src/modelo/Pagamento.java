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

    public Pagamento(Venda venda, TipoPagamento tipoPagamento, double valorPago, LocalDate dataPagamento) {
        this.venda = venda;
        this.tipoPagamento = tipoPagamento;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
