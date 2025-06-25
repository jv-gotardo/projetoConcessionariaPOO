/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.marca;

import modelo.enums.*;

/**
 *
 * @author jvito
 */
public class Veiculo extends Modelo {
    private int chassi;
    private statusVeiculo status;
    private double quilometragem;
    private double precoBruto;
    
    public Veiculo(int chassi, String nome, String paisOrigem, int cnpj, String modeloNome, TipoVeiculo tipoVeiculo, 
            TipoCarroceria tipoCarroceria, String transmissao, int anoFabricacao, String cor, statusVeiculo status, 
            double quilometragem, double precoBruto){
        super(nome, paisOrigem, cnpj, modeloNome, tipoVeiculo, tipoCarroceria, transmissao, anoFabricacao, cor);
        chassi = this.chassi;
        status = this.status;
        quilometragem = this.quilometragem;
        precoBruto = this.precoBruto;
    }

    public double getPrecoBruto() {
        return precoBruto;
    }

    public void setPrecoBruto(double precoBruto) {
        this.precoBruto = precoBruto;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setStatus(statusVeiculo status) {
        this.status = status;
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }
}
