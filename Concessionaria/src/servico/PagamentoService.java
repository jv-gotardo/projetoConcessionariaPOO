/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.time.LocalDate;
import java.util.Scanner;
import modelo.Financiamento;
import modelo.Pagamento;
import modelo.Venda;
import modelo.enums.ModeloVenda;
import modelo.enums.StatusPagamento;
import modelo.enums.TipoPagamento;

/**
 *
 * @author jvito
 */
public class PagamentoService {
    VendaService vs = new VendaService();
    GlobalService gs = new GlobalService();
    FinanciamentoService fs = new FinanciamentoService();
    Scanner sc = new Scanner(System.in);
    public Pagamento criarPagamento(Venda venda){
        String tipoPagamento, dataPagamento;
        double valorPago;
        System.out.println("Criação de Pagamento");
        System.out.println("--------------------");
        System.out.println("Venda: "); vs.lerVenda(venda);
        System.out.print("Tipo de Pagamento: ");
        tipoPagamento = sc.nextLine();
        TipoPagamento pagamentot = TipoPagamento.valueOf(tipoPagamento);
        System.out.println("Valor Pago: R$");
        valorPago = sc.nextLong(); sc.nextLine();
        System.out.println("Data de Pagamento, digite no formato DD/MM/AAAA:");
        dataPagamento = sc.nextLine();
        LocalDate dp = gs.formatarData(dataPagamento);
        Pagamento pagamento = new Pagamento(venda, pagamentot, valorPago, dp);
        pagamento.setStatusPagamento(StatusPagamento.PENDENTE);
        return pagamento;
    }
    
    public boolean pagarEntrada(Financiamento financiamento){
        System.out.println("Aplicação especial para pagamento da entrada");
        if(!financiamento.getModeloVenda().equals(ModeloVenda.A_PRAZO)){
            return true;
        }
        criarPagamento(financiamento.getVenda());
        financiamento.setEntradaPaga(true);
        return true;
    }
    
    public boolean validarPagamento(Venda venda, Pagamento pagamento, Financiamento financiamento){
        if(!financiamento.isEntradaPaga()){
            System.out.println("A entrada deve ser paga antes de qualquer parcela");
            return false;
        } 
        if(financiamento.getDataProximoPagamento().isBefore(pagamento.getDataPagamento())){
            System.out.println("A parcela está atrasada e o contrato será encerrado.");
            pagamento.setStatusPagamento(StatusPagamento.CANCELADO);
            return false;
        }
        if(pagamento.getValorPago() == financiamento.getValorParcela()){
            System.out.println("Pagamento aprovado!");
            pagamento.setStatusPagamento(StatusPagamento.PAGO);
            financiamento.setNumeroParcelas(financiamento.getNumeroParcelas()-1);
            System.out.println("Valor da parcela paga: R$" + financiamento.getValorParcela());
            fs.recalcularParcela(financiamento);
            System.out.println("Valor da próxima parcela: R$" + financiamento.getValorParcela());
            adicionarPagamento(venda, pagamento);
        }
        return true;
    }
    
    public void adicionarPagamento(Venda venda, Pagamento pagamento){
        venda.getPagamentos().add(pagamento);
    }
}
