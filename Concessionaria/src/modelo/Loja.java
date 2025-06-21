package modelo;

import modelo.pessoa.Funcionario;
import java.util.List;

public class Loja {
    private String nome;
    private String endereco;
    private String cidade;
    private char estado;
    private Estoque estoque;
    private List<Funcionario> funcionarios;
    private List<Venda> vendas;
    
    public Loja(String nome, String endereco, String cidade, char estado, Estoque estoque, 
            List<Funcionario> funcionarios, List<Venda> vendas){
        nome = this.nome;
        endereco = this.endereco;
        cidade = this.cidade;
        estado = this.estado;
        estoque = this.estoque;
        funcionarios = this.funcionarios;
        vendas = this.vendas;
    }
}
