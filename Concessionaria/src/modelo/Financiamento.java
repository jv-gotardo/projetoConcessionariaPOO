/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
    private double valorParcela = valorParcelaBruto + (valorParcelaBruto * juros);
    private String banco;
    private boolean aprovado; 
    private ModeloVenda modeloVenda;
    
    public Financiamento(Venda venda, double valorEntrada, String banco, boolean aprovado){
        venda = this.venda;
        valorEntrada = this.valorEntrada;
        banco = this.banco;
        aprovado = this.aprovado; 
        modeloVenda = ModeloVenda.A_VISTA;
    }
    
    public Financiamento(Venda venda, double valorEntrada, int numeroParcelas, double valorParcelaBruto,
            double juros, String banco, boolean aprovado, ModeloVenda modeloVenda){
        venda = this.venda;
        valorEntrada = this.valorEntrada;
        numeroParcelas = this.numeroParcelas;
        valorParcelaBruto = this.valorParcelaBruto;
        juros = this.juros;
        banco = this.banco;
        aprovado = this.aprovado;
        modeloVenda = this.modeloVenda;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }
}
