/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pessoa;

import java.time.LocalDate;

/**
 *
 * @author jvito
 */
public class Gerente extends Funcionario{
    public LocalDate tempoCargo;
    public double bonusTempoCargo;
    
    public Gerente(String nome, int telefone, String endereco, String cpf, double salario, 
            LocalDate tempoCargo, double bonusTempoCargo){
        super(nome, telefone, endereco, cpf, salario);
        tempoCargo = this.tempoCargo;
        bonusTempoCargo = this.bonusTempoCargo;
    }
}
