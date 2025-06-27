package servico;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jvito
 */
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import modelo.enums.TipoCarroceria;
import modelo.enums.TipoVeiculo;
import modelo.enums.statusVeiculo;
import modelo.marca.Marca;
import modelo.marca.Modelo;
import modelo.marca.Veiculo;
public class VeiculoService {
    Scanner sc = new Scanner(System.in);
    boolean marcaCriada = false;
    private static statusVeiculo sv;
    
    public statusVeiculo defineStatusVeiculo(double quilometragem, int anosUso){
        if(quilometragem < 50 && anosUso == 0){
            return statusVeiculo.NOVO;
        }else if(quilometragem < 30000 & anosUso <= 3){
            return statusVeiculo.SEMINOVO;
        }else{
            return statusVeiculo.USADO;
        }
    }
    
    public Marca criaMarca(){
        String nome, paisOrigem;
        long cnpj;
        System.out.println("Criação de Marca");
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("País de Origem: ");
        paisOrigem = sc.nextLine();
        System.out.print("CNPJ ou Equivalente: ");
        cnpj = sc.nextLong(); sc.nextLine();
        marcaCriada = true;
        return new Marca(nome, paisOrigem, cnpj);
    }
    
    public boolean marcaCriada(){
        return marcaCriada;
    }
    
    public Modelo criaModelo(Marca marca){
        String modeloNome, tipoVeiculo, tipoCarroceria, transmissao, cor;
        int anoFabricacao;
        System.out.println("Criação de Modelo");
        System.out.print("Nome do Modelo: ");
        modeloNome = sc.nextLine();
        System.out.print("Tipo do Veículo: ");
        tipoVeiculo = sc.nextLine();
        TipoVeiculo veiculo = TipoVeiculo.valueOf(tipoVeiculo);
        System.out.print("Tipo de Carroceria: ");
        tipoCarroceria = sc.nextLine();
        TipoCarroceria carroceria = TipoCarroceria.valueOf(tipoCarroceria);
        System.out.print("Transmissão (Automática ou Manual): ");
        transmissao = sc.nextLine();
        System.out.print("Ano de Fabricação: ");
        anoFabricacao = sc.nextInt();
        sc.nextLine();
        System.out.print("Cor: ");
        cor = sc.nextLine();
        return new Modelo(modeloNome, veiculo, carroceria, transmissao,
            anoFabricacao, cor, marca.getNome(), marca.getPaisOrigem(), marca.getCnpj());
    }
    
    public Veiculo criaVeiculo(Marca marca, Modelo modelo){
        //statusVeiculo status, double quilometragem, double precoBruto;
        double quilometragem, precoBruto;
        System.out.println("Criação de Veículo");
        System.out.print("Quilometragem: ");
        quilometragem = sc.nextDouble();
        System.out.print("Preço Bruto do Veículo: R$");
        precoBruto = sc.nextDouble();
        int chassi = ThreadLocalRandom.current().nextInt();
        return new Veiculo(chassi, defineStatusVeiculo(quilometragem, 2025 - modelo.getAnoFabricacao()), quilometragem, precoBruto, 
            modelo.getNomeModelo(), modelo.getTipoVeiculo(), modelo.getTipoCarroceria(), modelo.getTransmissao(),
            modelo.getAnoFabricacao(), modelo.getCor(), marca.getNome(), marca.getPaisOrigem(), marca.getCnpj());
    }
    
    public double calcularPrecoFinal(Veiculo veiculo){
        return veiculo.getPrecoBruto() - (sv.fatorUsoDescontoConcessionaria(veiculo.getPrecoBruto()));
    }
    
    public void atualizarQuilometragem(Veiculo veiculo){
        double kmnova;
        System.out.println("Quilometragem já cadastrada no veículo: " + veiculo.getQuilometragem());
        System.out.println("Digite a quilometragem adicionada: ");
        kmnova = sc.nextDouble();
        veiculo.setQuilometragem(veiculo.getQuilometragem() + kmnova);
    }
    
    public void atualizarStatus(Veiculo veiculo){
        veiculo.setStatus(defineStatusVeiculo(veiculo.getQuilometragem(), LocalDate.now().getYear() - veiculo.getAnoFabricacao()));
    }
    
    public Veiculo atualizaVeiculo(Marca marca, Modelo modelo, Veiculo veiculo){
        return veiculo;
    }
    
    public void lerVeiculo(Veiculo veiculo){
        System.out.println(veiculo.getNome() + " " + veiculo.getNomeModelo() + " " + veiculo.getAnoFabricacao()
            + " " + veiculo.getCor() + " " + veiculo.getQuilometragem() + " km rodados");
    }
}
