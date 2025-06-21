/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import modelo.marca.Veiculo;
import modelo.pessoa.Cliente;
import modelo.pessoa.Vendedor;

/**
 *
 * @author jvito
 */
public class Venda {
    private Veiculo veiculo;
    private Vendedor vendedor;
    private Cliente cliente;
    private int quantidade;
    private final double precoFinal = quantidade * veiculo.getPrecoBruto();
    private LocalDate dataVenda;
    
    public Venda(Veiculo veiculo, Vendedor vendedor, Cliente cliente, int quantidade,
            LocalDate dataVenda){
        veiculo = this.veiculo;
        vendedor = this.vendedor;
        cliente = this.cliente;
        quantidade = this.quantidade;
        dataVenda = this.dataVenda; 
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
