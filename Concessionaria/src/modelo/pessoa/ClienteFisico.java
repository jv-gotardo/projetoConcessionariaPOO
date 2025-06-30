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
    private long cpf;
    
    public ClienteFisico(String nome, long telefone, String endereco, double rendaMensal, long cpf){
        super(nome, telefone, endereco, rendaMensal);
        this.cpf = cpf;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClienteFisico{" + "cpf=" + cpf + '}';
    }
}
