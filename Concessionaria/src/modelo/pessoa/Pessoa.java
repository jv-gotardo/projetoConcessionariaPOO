package modelo.pessoa;

public abstract class Pessoa {
    protected String nome;
    protected int telefone;
    protected String endereco;
    
    public Pessoa(String nome, int telefone, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco; 
    }
}
