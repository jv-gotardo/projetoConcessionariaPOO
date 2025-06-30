package view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import locators.ModelLocator;
import locators.ServiceLocator;
import modelo.Estoque;
import modelo.Financiamento;
import modelo.Loja;
import modelo.Pagamento;
import modelo.Venda;
import modelo.marca.Marca;
import modelo.marca.Modelo;
import modelo.marca.Veiculo;
import modelo.pessoa.Cliente;
import modelo.pessoa.Funcionario;
import modelo.pessoa.Vendedor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jvito
 */
public class CoordenadorAcoes {
    private final ServiceLocator sl;
    private final List<String> opcoesDisponiveis;
    
    public CoordenadorAcoes(ServiceLocator sl, List<String> opcoesDisponiveis){
        this.sl = sl;
        this.opcoesDisponiveis = opcoesDisponiveis;
    }
    
    public void executarAcao(String acao, Scanner sc){
        switch(acao){
            case "Criar marca" -> acaoCriarMarca();
            case "Criar modelo" -> acaoCriarModelo(sc);
            case "Criar funcionario" -> acaoCriarFuncionario();
            case "Criar cliente" -> acaoCriarCliente();
            case "Criar veiculo" -> acaoCriarVeiculo(sc);
            case "Criar estoque" -> acaoCriarEstoque(sc);
            case "Adicionar veiculo ao estoque" -> acaoAdicionarVeiculoEstoque(sc);
            case "Criar loja" -> acaoCriarLoja(sc);
            case "Contratar vendedor" -> acaoContratarVendedor(sc);
            case "Demitir vendedor" -> acaoDemitirVendedor(sc);
            case "Criar venda" -> acaoCriarVenda(sc);
            case "Criar financiamento" -> acaoCriarFinanciamento(sc);
            case "Validar financiamento" -> acaoValidarFinanciamento(sc);
            case "Gerar contrato" -> acaoGerarContrato(sc);
            case "Pagar entrada" -> acaoPagarEntrada(sc);
            case "Registrar pagamento" -> acaoRegistrarPagamento(sc);
        }
    }
    
    public void acaoCriarMarca(){
        BancoObjetos.salvar(ModelLocator.MARCA, sl.veiculoService.criaMarca());
        opcoesDisponiveis.add("Criar modelo");
    }
    
    public Cliente acaoCriarCliente(){
        Cliente cliente = sl.pessoaService.criarCliente();
        BancoObjetos.salvar(ModelLocator.CLIENTE, cliente);
        return cliente;
    }
    
    public Funcionario acaoCriarFuncionario(){
        Funcionario funcionario = sl.pessoaService.criarFuncionario();
        BancoObjetos.salvar(ModelLocator.FUNCIONARIO, funcionario);
        return funcionario;
    }
    
    public Optional<Marca> selecionarMarca(Scanner sc){
        List<Marca> marcas = BancoObjetos.listar(ModelLocator.MARCA);
        System.out.println("Marcas disponíveis: ");
        
        marcas.forEach(System.out::println);
        System.out.println("Escolha uma marca: ");
        String marca = sc.nextLine();
        
        return marcas.stream()
                .filter(m -> m.getNome().equalsIgnoreCase(marca))
                .findFirst();
    }
    
    public Optional<Modelo> selecionarModelo(Scanner sc){
        Optional<Marca> marcaEscolhida = selecionarMarca(sc);
        
        if(marcaEscolhida.isPresent()){
            List<Modelo> modelos = BancoObjetos.listar(ModelLocator.MODELO);
            System.out.println("Modelos disponíveis: ");
            
            modelos.forEach(System.out::println);
            System.out.println("Escolha um modelo: ");
            String modelo = sc.nextLine();
            
            return modelos.stream()
                    .filter(m -> m.getNomeModelo().equalsIgnoreCase(modelo))
                    .findFirst();
        }else{
            System.out.println("Marca inválida. Crie-a e tente novamente");
            return Optional.empty();
        }
    }
    
    public Optional<Veiculo> selecionarVeiculo(Scanner sc){
        Optional<Modelo> modeloEscolhido = selecionarModelo(sc);
        if(modeloEscolhido.isEmpty()){
            System.out.println("Modelo inválido. Crie-o com a marca desejada e tente novamente");
            return Optional.empty();
        }
        
        List<Veiculo> veiculos = BancoObjetos.listar(ModelLocator.VEICULO);
        veiculos.forEach(System.out::println);
        System.out.println("Escolha um veículo através de sua marca e modelo. O primeiro encontrado será selecionado: ");
        String veiculo = sc.nextLine();
        String dadosVeiculo[] = veiculo.split(" ");
        
        return veiculos.stream()
                .filter(mc -> mc.getNome().equalsIgnoreCase(dadosVeiculo[0]))
                .filter(md -> md.getNomeModelo().equalsIgnoreCase(dadosVeiculo[1]))
                .findFirst();
    }
    
    public void acaoCriarModelo(Scanner sc){
        Optional<Marca> marcaEscolhida = selecionarMarca(sc);
        
        if(marcaEscolhida.isPresent()){
            BancoObjetos.salvar(ModelLocator.MODELO, sl.veiculoService.criaModelo(marcaEscolhida.get()));
        } else {
            System.out.println("Marca inválida. Crie-a e tente novamente.");
        }
        opcoesDisponiveis.add("Criar veiculo");
    }

    public void acaoCriarVeiculo(Scanner sc){
        Optional<Modelo> modeloEscolhido = selecionarModelo(sc);

        if (modeloEscolhido.isEmpty()) {
            System.out.println("Modelo inválido. Crie-o com a marca desejada e tente novamente.");
            return;
        }

        Marca marca = modeloEscolhido.get().getMarca();
        Modelo modelo = modeloEscolhido.get();

        BancoObjetos.salvar(ModelLocator.VEICULO, sl.veiculoService.criaVeiculo(marca, modelo));
        opcoesDisponiveis.add("Criar estoque");
    }
    
    public void acaoCriarEstoque(Scanner sc){
        BancoObjetos.salvar(ModelLocator.ESTOQUE, sl.estoqueService.criaEstoque());
        opcoesDisponiveis.add("Adicionar veiculo ao estoque");
        opcoesDisponiveis.add("Criar loja");
    }
    
    public void acaoAdicionarVeiculoEstoque(Scanner sc){
        Estoque estoque = BancoObjetos.listar(ModelLocator.ESTOQUE).stream().findFirst().orElse(null);
        sl.estoqueService.adicionarVeiculo(estoque, selecionarVeiculo(sc).get());
    }
    
    public void acaoCriarLoja(Scanner sc){
        List<Estoque> estoques = BancoObjetos.listar(ModelLocator.ESTOQUE);
        System.out.println("Estoques criados: ");
        
        estoques.forEach(System.out::println);
        System.out.println("Selecione um dos estoques, pela capacidade total: ");
        int qt = sc.nextInt();
        sc.nextLine();
        
        Estoque estoque = estoques.stream().filter(e -> e.getCapacidadeTotal() == qt)
                .findFirst().get();
        
        BancoObjetos.salvar(ModelLocator.LOJA, sl.lojaService.criarLoja(estoque));
        opcoesDisponiveis.add("Contratar vendedor");
        opcoesDisponiveis.add("Demitir vendedor");
        opcoesDisponiveis.add("Criar venda");
    }
    
    public Optional<Loja> selecionarLoja(Scanner sc){
        List<Loja> lojas = BancoObjetos.listar(ModelLocator.LOJA);
        System.out.println("Lojas disponíveis: ");
        
        lojas.forEach(System.out::println);
        System.out.println("Selecione uma das lojas, pelo seu nome: ");
        String nome = sc.nextLine();
        
        return lojas.stream().filter(lj -> lj.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
    
    public void acaoContratarVendedor(Scanner sc){
        Optional<Loja> loja = selecionarLoja(sc);
        
        if(loja.isEmpty()){
            System.out.println("Loja não encontrada");
            return;
        }
        Funcionario vendedor = acaoCriarFuncionario();
        if(vendedor instanceof Vendedor vendedor1){
            sl.lojaService.contratarVendedor(loja.get(), vendedor1);
            BancoObjetos.salvar(ModelLocator.VENDEDOR, vendedor1);
        }else{
            System.out.println("O funcionário deve ser um vendedor, tente novamente.");
        }
    }
    
    public void acaoDemitirVendedor(Scanner sc){
        Optional<Loja> optloja = selecionarLoja(sc);
        
        if(optloja.isEmpty()){
            System.out.println("Loja não encontrada");
            return;
        }
        
        Loja loja = optloja.get();
        List<Vendedor> vendedores = loja.getVendedores();
        
        sl.lojaService.listarFuncionarios(loja);
        System.out.println("Selecione um dos funcionários (pelo nome completo): ");
        String demitido = sc.nextLine();
        
        Optional<Vendedor> vendedorDemitido = vendedores.stream().filter(
                v -> v.getNome().equalsIgnoreCase(demitido)).findFirst();
        
        if(vendedorDemitido.isEmpty()){
            System.out.println("Vendedor não encontrado, tente novamente a ação. ");
            return;
        }
        
        BancoObjetos.remover(ModelLocator.VENDEDOR, sl.lojaService.demitirVendedor(loja, 
                vendedorDemitido.get()));
    }
    
    public Optional<Cliente> selecionarCliente(Scanner sc){
        List<Cliente> clientes = BancoObjetos.listar(ModelLocator.CLIENTE);

        System.out.println("Selecione um cliente existente (pelo nome completo): ");
        clientes.forEach(System.out::println);
        String cliente = sc.nextLine();
        
        return clientes.stream().filter(
            c -> c.getNome().equalsIgnoreCase(cliente)).findFirst();
    }
    
    public Optional<Vendedor> selecionarVendedor(Loja loja, Scanner sc){
        List<Vendedor> vendedores = loja.getVendedores();
        
        sl.lojaService.listarFuncionarios(loja);
        System.out.println("Selecione um dos funcionários (pelo nome completo): ");
        String vendedor = sc.nextLine();
        
        return vendedores.stream().filter(
                v -> v.getNome().equalsIgnoreCase(vendedor)).findFirst();  
    }
    
    public void acaoCriarVenda(Scanner sc){
        Optional<Loja> optLoja = selecionarLoja(sc);
        Optional<Veiculo> optVeiculo = selecionarVeiculo(sc);
        Optional<Cliente> optCliente = selecionarCliente(sc);
        
        if(optLoja.isEmpty()){
            System.out.println("Loja não encontrada");
            return;
        }
        if(optVeiculo.isEmpty()){
            System.out.println("Veículo não encontrado");
            return;
        }
        if(optCliente.isEmpty()){
            System.out.println("Cliente não encontrado");
        }
        
        Loja loja = optLoja.get();
        Veiculo veiculo = optVeiculo.get();
        Cliente cliente = optCliente.get();
        
        Optional<Vendedor> optVendedor = selecionarVendedor(loja, sc);
        if(optVendedor.isEmpty()){
            System.out.println("Vendedor não encontrado");
            return;
        }
        Vendedor vendedor = optVendedor.get();
                
        BancoObjetos.salvar(ModelLocator.VENDA, sl.vendaService.criarVenda(
                veiculo, vendedor, cliente, loja));
        opcoesDisponiveis.add("Criar financiamento");
    }
    
    public Optional<Venda> selecionarVenda(Scanner sc){
        System.out.println("Vendas realizadas: ");
        List<Venda> vendas = BancoObjetos.listar(ModelLocator.VENDA);
        vendas.forEach(System.out::println);
        System.out.println("Selecione, separado por espaços, o nome "
                + "da marca do veiculo, do modelo do veiculo"
                + " do cliente e do vendedor, nessa ordem: ");
        String dados = sc.nextLine();
        String dadosVenda[] = dados.split(" ");
        
        return vendas.stream().
                filter(v -> v.getVeiculo().getNome().equalsIgnoreCase(dadosVenda[0])).
                filter(v -> v.getVeiculo().getNomeModelo().equalsIgnoreCase(dadosVenda[1])).
                filter(v -> v.getCliente().getNome().equals(dadosVenda[2])).
                filter(v -> v.getVendedor().getNome().equalsIgnoreCase(dadosVenda[3])).
                findFirst();        
    }
    
    public void acaoCriarFinanciamento(Scanner sc){
        Optional<Venda> venda = selecionarVenda(sc);
        
        if(venda.isEmpty()){
            System.out.println("Não é possível criar financiamento, venda não encontrada");
        }
        BancoObjetos.salvar(ModelLocator.FINANCIAMENTO, sl.financiamentoService.
                criarFinanciamento(venda.get()));
        opcoesDisponiveis.add("Validar financiamento");
    }
    
    public Optional<Financiamento> selecionarFinanciamento(Scanner sc){
        Optional<Venda> venda = selecionarVenda(sc);
        List<Financiamento> financiamentos = BancoObjetos.listar(ModelLocator.FINANCIAMENTO);
        
        return financiamentos.stream().filter(f -> f.getVenda().equals(venda.get()))
                .findFirst();
    }
    
    public void acaoValidarFinanciamento(Scanner sc){
        Optional<Cliente> cliente = selecionarCliente(sc);
        Optional<Financiamento> financiamento = selecionarFinanciamento(sc);
        
        if(cliente.isEmpty()){
            System.out.println("O cliente não foi encontrado. ");
            return;
        }
        if(financiamento.isEmpty()){
            System.out.println("O financiamento não foi encontrado. ");
            return;
        }
        
        sl.financiamentoService.aprovarFinanciamento(financiamento.get(), cliente.get());
        sl.financiamentoService.atualizarFinanciamento(financiamento.get(), cliente.get());
        opcoesDisponiveis.add("Gerar contrato");
    }
    
    public void acaoGerarContrato(Scanner sc){
        Optional<Cliente> cliente = selecionarCliente(sc);
        Optional<Financiamento> financiamento = selecionarFinanciamento(sc);
        
        if(cliente.isEmpty()){
            System.out.println("O cliente não foi encontrado. ");
            return;
        }
        if(financiamento.isEmpty()){
            System.out.println("O financiamento não foi encontrado. ");
            return;
        }
        
        BancoObjetos.salvar(ModelLocator.CONTRATO, sl.contratoService.gerarContrato(
                financiamento.get(), cliente.get()));
        opcoesDisponiveis.add("Pagar entrada");
    }
    
    public void acaoPagarEntrada(Scanner sc){
        //    public boolean pagarEntrada(Financiamento financiamento){
        Optional<Financiamento> financiamento = selecionarFinanciamento(sc);
        
        if(financiamento.isEmpty()){
            System.out.println("O financiamento não foi encontrado");
            return;
        }
        sl.pagamentoService.pagarEntrada(financiamento.get());
        opcoesDisponiveis.add("Registrar pagamento");
    }
    
    public void acaoRegistrarPagamento(Scanner sc){
        Optional<Financiamento> financiamento = selecionarFinanciamento(sc);
        
        if(financiamento.isEmpty()){
            System.out.println("O financiamento não foi encontrado");
        }
        
        Pagamento pagamento = sl.pagamentoService.criarPagamento(financiamento.get().getVenda());
        BancoObjetos.salvar(ModelLocator.PAGAMENTO, sl.pagamentoService.
                criarPagamento(pagamento.getVenda()));
        
        boolean validacao = sl.pagamentoService.validarPagamento(financiamento.get().
                getVenda(), pagamento, financiamento.get());
        
        if(validacao){
            sl.pagamentoService.adicionarPagamento(financiamento.get().getVenda(), pagamento);
            BancoObjetos.remover(ModelLocator.PAGAMENTO, pagamento);
        }
    }
}

