package modelo.pessoa;

public abstract class Funcionario extends Pessoa {
    protected String cpf;
    protected double salario;
    
    public Funcionario(String nome, int telefone, String endereco, String cpf, double salario){
        super(nome, telefone, endereco);
        cpf = this.cpf;
        salario = this.salario;
    }
}
