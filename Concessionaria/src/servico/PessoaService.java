/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.time.LocalDate;
import java.util.Scanner;
import modelo.pessoa.Cliente;
import modelo.pessoa.ClienteFisico;
import modelo.pessoa.ClienteJuridico;
import modelo.pessoa.Funcionario;
import modelo.pessoa.Gerente;
import modelo.pessoa.Vendedor;

/**
 *
 * @author jvito
 */
public class PessoaService {
    Scanner sc = new Scanner(System.in);
    GlobalService gb = new GlobalService();
    
    public Funcionario criarFuncionario(){
        System.out.println("Criação de Funcionário");
        String nome, endereco;
        long telefone, cpf;
        char func;
        double salario;
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Telefone: ");
        telefone = sc.nextLong(); sc.nextLine();
        System.out.print("Endereço: ");
        endereco = sc.nextLine();
        System.out.print("CPF: ");
        cpf = sc.nextLong(); sc.nextLine();
        System.out.print("Salário: R$");
        salario = sc.nextDouble(); sc.nextLine();
        System.out.print("Defina se o funcionário é um vendedor ou gerente (V/G): ");
        func = sc.next().charAt(0); sc.nextLine();
        
        switch (func) {
            case 'V' -> {
                double comissaoPorVenda;
                System.out.print("Comissão por Venda do Vendedor: ");
                comissaoPorVenda = sc.nextDouble(); sc.nextLine();
                return new Vendedor(nome, telefone, endereco, cpf, salario, comissaoPorVenda);
            }
            case 'G' -> {
                double bonusTempoCargo; String dataEntrada;
                System.out.print("Digite no formato DD/MM/AAAA, a data de entrada do gerente: ");
                dataEntrada = sc.nextLine(); 
                LocalDate dataEntr = gb.formatarData(dataEntrada);
                bonusTempoCargo = dataEntr.getYear()*0.01 * salario;
                return new Gerente(nome, telefone, endereco, cpf, salario, dataEntr, bonusTempoCargo);
            }
            default -> {
                System.out.println("Valor inválido. Favor reiniciar a criação de funcionário.");
                return null;
            }
        }
    }
    
    public void lerFuncionario(Funcionario funcionario){
        System.out.println("-------------------------------");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Endereço: " + funcionario.getEndereco());
        System.out.println("Telefone: " + funcionario.getTelefone());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("Salário Bruto: R$" + funcionario.getSalario()); 
        
        switch (funcionario) {
            case Vendedor vendedor -> System.out.println("Comissão por venda: R$" + vendedor.getComissaoPorVenda());
            case Gerente gerente -> System.out.println("Bônus por tempo de cargo: R$" + gerente.getBonusTempoCargo());
            default -> {
            }
        }
        System.out.println("-------------------------------");
    }
    
    public int calcularTempoServico(Gerente gerente){
        LocalDate dataEntrada = gerente.getTempoCargo();
        return LocalDate.now().getYear() - dataEntrada.getYear();
    }
    
    public double calcularBonus(Gerente gerente){
        return gerente.getTempoCargo().getYear() * 0.01 * gerente.getSalario();
    } 
    
    public Cliente criarCliente(){
        String nome, endereco;
        long telefone;
        double rendaMensal;
        char cli;
        System.out.println("Criação de Cliente");
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Telefone: ");
        telefone = sc.nextLong(); sc.nextLine();
        System.out.print("Endereço: ");
        endereco = sc.nextLine();
        System.out.print("Renda Mensal: R$");
        rendaMensal = sc.nextDouble(); sc.nextLine();
        System.out.print("Defina se o cliente é físico ou jurídico (F / J): ");
        cli = sc.next().charAt(0); sc.nextLine();
        
        switch(cli){
            case 'F' -> {
                long cpf;
                System.out.print("CPF: ");
                cpf = sc.nextLong(); sc.nextLine();
                return new ClienteFisico(nome, telefone, endereco, rendaMensal, cpf);
            }
            case 'J' -> {
                long cnpj;
                System.out.println("CNPJ: ");
                cnpj = sc.nextLong(); sc.nextLine();
                return new ClienteJuridico(nome, telefone, endereco, rendaMensal, cnpj);
            }
            default -> {
                System.out.println("Valor inválido. Favor reiniciar a criação de cliente");
                return null;
            }
        }
    }
    
    public void lerCliente(Cliente cliente){
        System.out.println("-------------------------------");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Renda Mensal: R$" + cliente.getRendaMensal()); 
        
        switch (cliente) {
            case ClienteJuridico cj -> System.out.println("CNPJ: " + cj.getCnpj());
            case ClienteFisico cf -> System.out.println("CPF: " + cf.getCpf());
            default -> {
            }
        }
        System.out.println("-------------------------------");
    }
}
