/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
    private final double precoFinal;
    private LocalDate dataVenda;
    private Financiamento financiamento;
    private List<Pagamento> pagamentos;
    
    public Venda(Veiculo veiculo, Vendedor vendedor, Cliente cliente, int quantidade,
            LocalDate dataVenda){
        veiculo = this.veiculo;
        vendedor = this.vendedor;
        cliente = this.cliente;
        quantidade = this.quantidade;
        dataVenda = this.dataVenda; 
        precoFinal = quantidade * veiculo.getPrecoBruto();
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

    public double getPrecoFinal() {
        return precoFinal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public Financiamento getFinanciamento() {
        return financiamento;
    }
    
    public void setFinanciamento(Financiamento financiamento) {
        this.financiamento = financiamento;
        if(financiamento.getVenda() != this){
            financiamento.setVenda(this);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoFinal) != Double.doubleToLongBits(other.precoFinal)) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        if (!Objects.equals(this.vendedor, other.vendedor)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return Objects.equals(this.dataVenda, other.dataVenda);
    }
}
