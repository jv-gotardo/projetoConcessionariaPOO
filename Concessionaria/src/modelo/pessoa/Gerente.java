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
    
    public Gerente(String nome, long telefone, String endereco, long cpf, double salario, 
            LocalDate tempoCargo, double bonusTempoCargo){
        super(nome, telefone, endereco, cpf, salario);
        tempoCargo = this.tempoCargo;
        bonusTempoCargo = this.bonusTempoCargo;
    }

    public LocalDate getTempoCargo() {
        return tempoCargo;
    }

    public void setTempoCargo(LocalDate tempoCargo) {
        this.tempoCargo = tempoCargo;
    }

    public double getBonusTempoCargo() {
        return bonusTempoCargo;
    }

    public void setBonusTempoCargo(double bonusTempoCargo) {
        this.bonusTempoCargo = bonusTempoCargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
