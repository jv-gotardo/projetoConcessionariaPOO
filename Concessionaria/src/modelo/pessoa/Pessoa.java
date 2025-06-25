package modelo.pessoa;

public abstract class Pessoa {
    protected String nome;
    protected long telefone;
    protected String endereco;
    
    public Pessoa(String nome, long telefone, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco; 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
