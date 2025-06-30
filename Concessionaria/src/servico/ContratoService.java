/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.time.LocalDate;
import java.util.Scanner;
import modelo.Contrato;
import modelo.Loja;
import modelo.Financiamento;
import modelo.Pagamento;
import modelo.Venda;
import modelo.enums.StatusPagamento;
import modelo.pessoa.Cliente;

/**
 *
 * @author jvito
 */
public class ContratoService {
    Scanner sc = new Scanner(System.in);
    FinanciamentoService fs = new FinanciamentoService();
    VendaService vs = new VendaService();
    
    public Contrato gerarContrato(Financiamento financiamento, Cliente cliente){
        if(!fs.aprovarFinanciamento(financiamento, cliente)){
            System.out.println("O contrato não pode ser gerado sem aprovação do financiamento.");
            return null;
        }
        System.out.println("Financiamento: ");
        fs.lerFinanciamento(financiamento);
        System.out.println("Termos de Contrato: ");
        String termosContrato = sc.nextLine();
        LocalDate dataAssinatura = LocalDate.now();
        LocalDate dataVencimento = LocalDate.now().plusMonths(financiamento.getNumeroParcelas());
        System.out.println("Contrato gerado!");
        return new Contrato(financiamento, termosContrato, dataAssinatura, dataVencimento);
    }
    
    public void cancelarContrato(Pagamento pagamento, Venda venda, Loja loja){
        if(pagamento.getStatusPagamento().equals(StatusPagamento.CANCELADO)){
            vs.removerVenda(loja, venda);
            System.out.println("O contrato foi cancelado.");
        }
    }
    
    public boolean encerrarContrato(Financiamento financiamento){
        if(financiamento.getNumeroParcelas() == 0){
            System.out.println("O contrato foi encerrado após o fim dos pagamentos.");
            return true;
        }
        return false;
    }
}
