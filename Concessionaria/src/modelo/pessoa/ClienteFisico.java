/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pessoa;

/**
 *
 * @author jvito
 */
public class ClienteFisico extends Cliente {
    private int cpf;
    
    public ClienteFisico(String nome, int telefone, String endereco, double rendaMensal, int cpf){
        super(nome, telefone, endereco, rendaMensal);
        cpf = this.cpf;
    }
}
