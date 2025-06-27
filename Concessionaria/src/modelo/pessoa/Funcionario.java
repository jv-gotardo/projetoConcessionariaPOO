package modelo.pessoa;

public abstract class Funcionario extends Pessoa {
    protected long cpf;
    protected double salario;
    
    public Funcionario(String nome, long telefone, String endereco, long cpf, double salario){
        super(nome, telefone, endereco);
        this.cpf = cpf;
        this.salario = salario;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
