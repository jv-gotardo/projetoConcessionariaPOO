/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pessoa;

/**
 *
 * @author jvito
 */
public class Vendedor extends Funcionario{
    public double comissaoPorVenda;
    
    public Vendedor(String nome, int telefone, String endereco, String cpf, double salario, double comissaoPorVenda){
        super(nome, telefone, endereco, cpf, salario);
        comissaoPorVenda = this.comissaoPorVenda;
    }
}
