/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Estoque;
import modelo.marca.Veiculo;

/**
 *
 * @author jvito
 */
public class EstoqueService {
    Scanner sc = new Scanner(System.in);
    VeiculoService vs = new VeiculoService();
    public Estoque criaEstoque(){
        int capacidadeTotal, capacidadeOcupada = 0;
        System.out.println("Criação de Estoque");
        System.out.print("Capacidade Total: ");
        capacidadeTotal = sc.nextInt(); sc.nextLine();
        List<Veiculo> veiculosDisponiveis = new ArrayList();
        return new Estoque(veiculosDisponiveis, capacidadeTotal, capacidadeOcupada);
    }
    
    public boolean capacidadeMaxima(Estoque estoque){
        return estoque.getCapacidadeTotal() - estoque.getCapacidadeOcupada() >= 0;
    }
    
    public Estoque adicionarVeiculo(Estoque estoque, Veiculo veiculo){
        estoque.getVeiculosDisponiveis().add(veiculo);
        estoque.setCapacidadeOcupada(estoque.getCapacidadeOcupada() + 1);
        return estoque;
    }
    
    public int consultarCapacidadeAtual(Estoque estoque){
        return estoque.getCapacidadeTotal() - estoque.getCapacidadeOcupada();
    }
    
    public void listarVeiculosDisponiveis(Estoque estoque){
        System.out.println("Lista de veículos disponíveis");
        for(int i = 0; i < estoque.getVeiculosDisponiveis().size(); i++){
            vs.lerVeiculo(estoque.getVeiculosDisponiveis().get(i));
        }
    }
    
    public void consultaVeiculoPorMarca(Estoque estoque, Veiculo veiculo){
        System.out.println("Veículos disponíveis da " + veiculo.getNome());
        for(int i = 0; i < estoque.getVeiculosDisponiveis().size(); i++){
            if(estoque.getVeiculosDisponiveis().get(i).getNome().equals(veiculo.getNome())){
                vs.lerVeiculo(estoque.getVeiculosDisponiveis().get(i));
            }
        }
    }
    
    public void removerVeiculo(Estoque estoque, Veiculo veiculo){
        System.out.println("Remover veículo do estoque");
        for(int i = 0; i < estoque.getVeiculosDisponiveis().size(); i++){
            if(estoque.getVeiculosDisponiveis().get(i).getChassi() == veiculo.getChassi()){
                estoque.getVeiculosDisponiveis().remove(i);
                break;
            }
        }
        estoque.setCapacidadeOcupada(estoque.getCapacidadeOcupada() - 1);
    }
}
