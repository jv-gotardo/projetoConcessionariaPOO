/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locators;

import modelo.Contrato;
import modelo.Estoque;
import modelo.Financiamento;
import modelo.Loja;
import modelo.Pagamento;
import modelo.Venda;
import modelo.marca.Marca;
import modelo.marca.Modelo;
import modelo.marca.Veiculo;
import modelo.pessoa.Cliente;
import modelo.pessoa.ClienteFisico;
import modelo.pessoa.ClienteJuridico;
import modelo.pessoa.Funcionario;
import modelo.pessoa.Gerente;
import modelo.pessoa.Pessoa;
import modelo.pessoa.Vendedor;

/**
 *
 * @author jvito
 */
public class ModelLocator {
    public static final Class<Contrato> CONTRATO = Contrato.class;
    public static final Class<Estoque> ESTOQUE = Estoque.class;
    public static final Class<Financiamento> FINANCIAMENTO = Financiamento.class;
    public static final Class<Loja> LOJA = Loja.class;
    public static final Class<Pagamento> PAGAMENTO = Pagamento.class;
    public static final Class<Venda> VENDA = Venda.class;
    public static final Class<Marca> MARCA = Marca.class;
    public static final Class<Modelo> MODELO = Modelo.class;
    public static final Class<Veiculo> VEICULO = Veiculo.class;
    public static final Class<Cliente> CLIENTE = Cliente.class;
    public static final Class<ClienteFisico> CLIENTEFISICO = ClienteFisico.class;
    public static final Class<ClienteJuridico> CLIENTEJURIDICO = ClienteJuridico.class;
    public static final Class<Funcionario> FUNCIONARIO = Funcionario.class;
    public static final Class<Gerente> GERENTE = Gerente.class;
    public static final Class<Pessoa> PESSOA = Pessoa.class;
    public static final Class<Vendedor> VENDEDOR = Vendedor.class;
}
