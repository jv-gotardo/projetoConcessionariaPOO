/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.time.LocalDate;
import java.util.Scanner;
import modelo.Loja;
import modelo.Venda;
import modelo.marca.Veiculo;
import modelo.pessoa.Cliente;
import modelo.pessoa.Vendedor;

/**
 *
 * @author jvito
 */
public class VendaService {
    VeiculoService vs = new VeiculoService();
    PessoaService ps = new PessoaService();
    EstoqueService es = new EstoqueService();
    GlobalService gs = new GlobalService();
    Scanner sc = new Scanner(System.in);
    public Venda criarVenda(Veiculo veiculo, Vendedor vendedor, Cliente cliente, Loja loja){
        System.out.println("Criação de venda");
        System.out.print("Veículo: "); vs.lerVeiculo(veiculo);
        System.out.print("Vendedor: "); ps.lerFuncionario(vendedor);
        System.out.print("Cliente: "); ps.lerCliente(cliente);
        System.out.println("Selecione a quantidade de veículos a serem comprados: ");
        int quantidade = sc.nextInt();
        es.removerVeiculo(loja.getEstoque(), veiculo);
        LocalDate dataVenda = LocalDate.now();
        Venda venda = new Venda(veiculo, vendedor, cliente, quantidade, dataVenda);
        
        loja.getVendas().add(venda);
        return venda;
    }
    
    public void lerVenda(Venda venda){
        System.out.println("--------------");
        System.out.print("Veículo: "); vs.lerVeiculo(venda.getVeiculo());
        System.out.print("Vendedor: "); ps.lerFuncionario(venda.getVendedor());
        System.out.print("Cliente: "); ps.lerCliente(venda.getCliente());
        System.out.print("Quantidade comprada: " + venda.getQuantidade());
        System.out.print("Data da Venda: " + gs.imprimirData(venda.getDataVenda()));
        System.out.print("Preço Final da Venda: R$" + venda.getPrecoFinal());
        System.out.println("--------------");
    }
    
    public boolean removerVenda(Loja loja, Venda venda){
        for(Venda v: loja.getVendas()){
            if(venda.equals(v)){
                loja.getVendas().remove(venda);
                return true;
            }
        }
        return false;
    }
}
