/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Estoque;
import modelo.Loja;
import modelo.pessoa.Vendedor;
import modelo.pessoa.Gerente;
import modelo.Venda;

/**
 *
 * @author jvito
 */
public class LojaService {
    Scanner sc = new Scanner(System.in);
    boolean lojaCriada = false;
    PessoaService ps = new PessoaService();
    EstoqueService ess = new EstoqueService();
    VendaService vs = new VendaService();
    
    public Loja criarLoja(Estoque estoque){
        String nome, endereco, cidade, estado;
        System.out.println("Criação de Loja");
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.println("Endereço: ");
        endereco = sc.nextLine();
        System.out.println("Cidade: ");
        cidade = sc.nextLine();
        System.out.println("Estado: ");
        estado = sc.nextLine();
        System.out.println("O seguinte estoque será adicionado para a loja: ");
        ess.listarVeiculosDisponiveis(estoque);
        System.out.println("Adicione um gerente: ");
        Gerente gerente = (Gerente) ps.criarFuncionario();
        List<Vendedor> vendedores = new ArrayList();
        List<Venda> vendas = new ArrayList();
        Loja loja = new Loja(nome, endereco, cidade, estado, estoque, gerente, vendedores, vendas);
        lojaCriada = true;
        return loja;
    }
    
    public void contratarVendedor(Loja loja, Vendedor vendedor){
        System.out.print("Confirme a contratação de " + vendedor.getNome() + " (S/N): ");
        if(sc.nextLine().equals("S")){
            loja.getVendedores().add(vendedor);
        }else{
            System.out.println("A contratação está cancelada.");
        }
    }
    
    public Vendedor demitirVendedor(Loja loja, Vendedor vendedor){
        System.out.print("Confirme a demissão de " + vendedor.getNome() + " (S/N): ");
        if(sc.nextLine().equals("S")){
            for (Vendedor v : loja.getVendedores()){
                if(v.getNome().equals(vendedor.getNome())){
                    loja.getVendedores().remove(vendedor);
                    return vendedor;
                }
            }
        }
        return null;
    }
    
    public void adicionarVenda(Loja loja, Venda venda){
        loja.getVendas().add(venda);
    }
    
    public void listarFuncionarios(Loja loja){
        System.out.println("Lista de funcionários da Loja " + loja.getNome());
        System.out.println("Gerente: " + loja.getGerente().getNome());
        for(int i = 0; i < loja.getVendedores().size(); i++){
            System.out.println("Vendedor: " + loja.getVendedores().get(i).getNome());
        }
    }
    
    public void listarVendas(Loja loja){
        System.out.println("Lista de vendas da Loja " + loja.getNome());
        for(int i = 0; i < loja.getVendas().size(); i++){
            System.out.println("---------------");
            System.out.println("Venda " + i);
            vs.lerVenda(loja.getVendas().get(i));
            System.out.println("---------------");
        }
    } 
    
    public boolean verificaLojaCriada(){
        return lojaCriada;
    }
}
