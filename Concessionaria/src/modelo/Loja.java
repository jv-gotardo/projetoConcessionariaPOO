package modelo;

import modelo.pessoa.Funcionario;
import java.util.List;
import modelo.pessoa.Gerente;
import modelo.pessoa.Vendedor;

public class Loja {
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private Estoque estoque;
    private Gerente gerente;
    private List<Vendedor> vendedores;
    private List<Venda> vendas;
    
    public Loja(String nome, String endereco, String cidade, String estado, Estoque estoque, 
            Gerente gerente, List<Vendedor> vendedores, List<Venda> vendas){
        nome = this.nome;
        endereco = this.endereco;
        cidade = this.cidade;
        estado = this.estado;
        estoque = this.estoque;
        gerente = this.gerente;
        vendedores = this.vendedores;
        vendas = this.vendas;
    }
    
    public Loja(String nome, String endereco, String cidade, String estado, Estoque estoque){
        nome = this.nome;
        endereco = this.endereco;
        cidade = this.cidade;
        estado = this.estado;
        estoque = this.estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
