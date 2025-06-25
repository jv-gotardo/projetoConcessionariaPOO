package modelo;

import modelo.marca.Veiculo;
import java.util.List;

public class Estoque {
    private List<Veiculo> veiculosDisponiveis;
    private int capacidadeTotal;
    private int capacidadeOcupada;

    public Estoque(List<Veiculo> veiculosDisponiveis, int capacidadeTotal, int capacidadeOcupada) {
        veiculosDisponiveis = this.veiculosDisponiveis;
        capacidadeTotal = this.capacidadeTotal;
        capacidadeOcupada = this.capacidadeOcupada;
    }
    
    public Estoque(int capacidadeTotal, int capacidadeOcupada) {
        capacidadeTotal = this.capacidadeTotal;
        capacidadeOcupada = this.capacidadeOcupada;
    }

    public List<Veiculo> getVeiculosDisponiveis() {
        return veiculosDisponiveis;
    }

    public void setVeiculosDisponiveis(List<Veiculo> veiculosDisponiveis) {
        this.veiculosDisponiveis = veiculosDisponiveis;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public int getCapacidadeOcupada() {
        return capacidadeOcupada;
    }

    public void setCapacidadeOcupada(int capacidadeOcupada) {
        this.capacidadeOcupada = capacidadeOcupada;
    }
}
