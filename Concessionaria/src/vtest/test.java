package vtest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import locators.ServiceLocator;
import modelo.marca.Marca;
import modelo.marca.Modelo;
import modelo.marca.Veiculo;
import modelo.pessoa.Cliente;
import modelo.Estoque;
import modelo.Financiamento;
import modelo.Loja;
import modelo.Pagamento;
import modelo.Venda;
import modelo.pessoa.Vendedor;

/**
 *
 * @author jvito
 */
public class test {
    public static void main(String[] args) {
        ServiceLocator sl = new ServiceLocator();
        
        //Teste de criação de veículo
        Marca marca = sl.veiculoService.criaMarca();
        //Automóvel, Cabine Dupla
        Modelo modelo = sl.veiculoService.criaModelo(marca);
        Veiculo veiculo = sl.veiculoService.criaVeiculo(marca, modelo);
        
        //Teste de criação e abastecimento de loja
        Estoque estoque = sl.estoqueService.criaEstoque();
        sl.estoqueService.adicionarVeiculo(estoque, veiculo);
        Loja loja = sl.lojaService.criarLoja(estoque);
        
        //Teste de venda
        Cliente cliente = sl.pessoaService.criarCliente();
        Vendedor vendedor = (Vendedor) sl.pessoaService.criarFuncionario();
        sl.lojaService.contratarVendedor(loja, vendedor);
        sl.estoqueService.listarVeiculosDisponiveis(estoque);
        Venda venda = sl.vendaService.criarVenda(veiculo, vendedor, cliente, loja);
        Financiamento financiamento = sl.financiamentoService.criarFinanciamento(venda);
        
        //Simulação de Pagamento 
        sl.pagamentoService.pagarEntrada(financiamento);
        Pagamento pagamento = sl.pagamentoService.criarPagamento(venda);
        sl.pagamentoService.validarPagamento(venda, pagamento, financiamento);
        sl.pagamentoService.pagarEntrada(financiamento);
        
        //Verificação das atualizações
        financiamento.getNumeroParcelas();
        venda.getPagamentos().forEach(System.out::println);
    }
}
