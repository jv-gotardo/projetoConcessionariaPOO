/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import servico.ContratoService;
import servico.EstoqueService;
import servico.FinanciamentoService;
import servico.GlobalService;
import servico.LojaService;
import servico.PagamentoService;
import servico.PessoaService;
import servico.VeiculoService;
import servico.VendaService;

/**
 *
 * @author jvito
 */
public class ServiceLocator {
    public final ContratoService contratoService;
    public final EstoqueService estoqueService;
    public final FinanciamentoService financiamentoService;
    public final GlobalService globalService;
    public final LojaService lojaService;
    public final PagamentoService pagamentoService;
    public final PessoaService pessoaService;
    public final VeiculoService veiculoService;
    public final VendaService vendaService;
    
    public ServiceLocator(){
        this.contratoService = new ContratoService();
        this.estoqueService = new EstoqueService();
        this.financiamentoService = new FinanciamentoService();
        this.globalService = new GlobalService();
        this.lojaService = new LojaService();
        this.pagamentoService = new PagamentoService();
        this.pessoaService = new PessoaService();
        this.veiculoService = new VeiculoService();
        this.vendaService = new VendaService();
        
    }
}
