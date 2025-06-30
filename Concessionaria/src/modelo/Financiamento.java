/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import modelo.enums.ModeloVenda;

/**
 *
 * @author jvito
 */
public class Financiamento {
    private Venda venda;
    private double valorEntrada;
    private int numeroParcelas; 
    private double valorParcelaBruto; 
    private double juros; 
    private double valorParcela = valorParcelaBruto + (valorParcelaBruto * (juros/100));
    private String banco;
    private boolean aprovado; 
    private ModeloVenda modeloVenda;
    private LocalDate dataProximoPagamento;
    private boolean entradaPaga = false;

    public Financiamento(Venda venda, double valorEntrada, String banco, boolean aprovado) {
        this.venda = venda;
        this.valorEntrada = valorEntrada;
        this.banco = banco;
        this.aprovado = aprovado;
    }

    public Financiamento(Venda venda, double valorEntrada, int numeroParcelas, double valorParcelaBruto, String banco, boolean aprovado, ModeloVenda modeloVenda, double juros) {
        this.venda = venda;
        this.valorEntrada = valorEntrada;
        this.numeroParcelas = numeroParcelas;
        this.valorParcelaBruto = valorParcelaBruto;
        this.banco = banco;
        this.aprovado = aprovado;
        this.modeloVenda = modeloVenda;
        this.juros = juros;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public double getValorParcelaBruto() {
        return valorParcelaBruto;
    }

    public void setValorParcelaBruto(double valorParcelaBruto) {
        this.valorParcelaBruto = valorParcelaBruto;
    }

    public double getJuros() {
        return juros;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public ModeloVenda getModeloVenda() {
        return modeloVenda;
    }

    public void setModeloVenda(ModeloVenda modeloVenda) {
        this.modeloVenda = modeloVenda;
    }

    public LocalDate getDataProximoPagamento() {
        return dataProximoPagamento;
    }

    public void setDataProximoPagamento(LocalDate dataProximoPagamento) {
        this.dataProximoPagamento = dataProximoPagamento;
    }

    public boolean isEntradaPaga() {
        return entradaPaga;
    }

    public void setEntradaPaga(boolean entradaPaga) {
        this.entradaPaga = entradaPaga;
    }
}
