/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pessoa;

/**
 *
 * @author jvito
 */
public class ClienteJuridico extends Cliente {
    private int cnpj;
    
    public ClienteJuridico(String nome, int telefone, String endereco, double rendaMensal, int cnpj){
        super(nome, telefone, endereco, rendaMensal);
        cnpj = this.cnpj;
    }
}