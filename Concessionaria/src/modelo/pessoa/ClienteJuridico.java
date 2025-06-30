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
    private long cnpj;
    
    public ClienteJuridico(String nome, long telefone, String endereco, double rendaMensal, long cnpj){
        super(nome, telefone, endereco, rendaMensal);
        this.cnpj = cnpj;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ClienteJuridico{" + "cnpj=" + cnpj + '}';
    }
}