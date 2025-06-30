/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.time.LocalDate;
import java.util.Scanner;
import modelo.Financiamento;
import modelo.Venda;
import modelo.enums.ModeloVenda;
import modelo.pessoa.Cliente;

/**
 *
 * @author jvito
 */
public class FinanciamentoService {
    Scanner sc = new Scanner(System.in);
    VendaService vs = new VendaService();

    public int defineNumeroParcelas(ModeloVenda mv){
        switch (mv) {
            case A_PRAZO -> {
                return 24;
            }
            case A_VISTA -> {
                return 1;
            }
            case PARCELADO -> {
                return 48;
            }
            default -> {
            }
        }
        return -1;
    }    

    public Financiamento criarFinanciamento(Venda venda){
        double valorEntrada, valorParcelaBruto, juros; int numeroParcelas;
        String banco, mv; ModeloVenda modeloVenda;
        System.out.println("Criação de Financiamento");
        System.out.println("Venda: "); vs.lerVenda(venda);
        System.out.println("Modelo da Venda: ");
        mv = sc.nextLine();
        modeloVenda = ModeloVenda.valueOf(mv);
        System.out.println("Banco: ");
        banco = sc.nextLine();
        if(modeloVenda.equals(ModeloVenda.A_PRAZO)){
            System.out.println("Defina o valor da entrada: R$");
            valorEntrada = sc.nextDouble(); sc.nextLine();
            if(valorEntrada > venda.getPrecoFinal() || valorEntrada <= 0){
                System.out.println("Valor inválido. Favor reiniciar o financiamento.");
                return null;
            }
        }else{
            valorEntrada = 0;
        }
        numeroParcelas = defineNumeroParcelas(modeloVenda);
        if(!modeloVenda.equals(ModeloVenda.A_VISTA)){
            System.out.println("Defina a taxa de juros: ");
            juros = sc.nextDouble(); sc.nextLine();
        }else{
            juros = 0;
        }
        valorParcelaBruto = (venda.getPrecoFinal() - valorEntrada) / numeroParcelas;
        valorParcelaBruto = Math.round(valorParcelaBruto * 100.0) / 100.0;
        System.out.println("O valor da parcela bruto é R$" + valorParcelaBruto);
        Financiamento financiamento = new Financiamento(
                venda, valorEntrada, numeroParcelas, valorParcelaBruto, banco, false, modeloVenda, juros);
        if(modeloVenda.equals(ModeloVenda.A_VISTA)){
            financiamento.setDataProximoPagamento(LocalDate.now());
        }else{
            financiamento.setDataProximoPagamento(LocalDate.now().plusMonths(1));
        }
        return financiamento;
    }
    
    public void lerFinanciamento(Financiamento financiamento){
        System.out.println("Venda: ");
        vs.lerVenda(financiamento.getVenda());
        System.out.println("Modelo da Venda: " + financiamento.getModeloVenda().CODIGO);
        System.out.println("Banco: " + financiamento.getBanco());
        System.out.println("Valor total" + financiamento.getVenda().getPrecoFinal());
    }
    
    public boolean aprovarFinanciamento(Financiamento financiamento, Cliente cliente){
        return defineNumeroParcelas(financiamento.getModeloVenda()) != -1 &&
                cliente.getRendaMensal() > financiamento.getValorParcela();
    }
    
    public void atualizarFinanciamento(Financiamento financiamento, Cliente cliente){
        if(aprovarFinanciamento(financiamento, cliente)){
            financiamento.setAprovado(true);
        }
    }
    
    public double recalcularParcela(Financiamento financiamento){
        financiamento.setValorParcela(financiamento.getValorParcela() + 
                (financiamento.getValorParcela() * financiamento.getJuros()));
        return financiamento.getValorParcela();
    }
}