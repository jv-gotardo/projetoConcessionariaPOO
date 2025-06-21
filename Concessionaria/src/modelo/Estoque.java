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
    
    
}
