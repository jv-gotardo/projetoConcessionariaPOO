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

    public Veiculo(int chassi, statusVeiculo status, double quilometragem, double precoBruto, String nomeModelo, TipoVeiculo tipoVeiculo, 
            TipoCarroceria tipoCarroceria, String transmissao, int anoFabricacao, String cor, String nome, String paisOrigem, long cnpj) {
        super(nomeModelo, tipoVeiculo, tipoCarroceria, transmissao, anoFabricacao, cor, nome, paisOrigem, cnpj);
        this.chassi = chassi;
        this.status = status;
        this.quilometragem = quilometragem;
        this.precoBruto = precoBruto;
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

    @Override
    public String toString() {
        return "Veiculo{" + "chassi=" + chassi + ", status=" + status + 
                ", quilometragem=" + quilometragem + ", precoBruto=" + precoBruto + '}';
    }
    
    
}
