package modelo.marca;

import modelo.enums.TipoVeiculo;
import modelo.enums.TipoCarroceria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jvito
 */
public class Modelo extends Marca {
    protected String nomeModelo;
    protected TipoVeiculo tipoVeiculo;
    protected TipoCarroceria tipoCarroceria; 
    protected String transmissao;
    protected int anoFabricacao;
    protected String cor;

    public String getNomeModelo() {
        return nomeModelo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public TipoCarroceria getTipoCarroceria() {
        return tipoCarroceria;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public void setTipoCarroceria(TipoCarroceria tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public Modelo(String nomeModelo, TipoVeiculo tipoVeiculo, TipoCarroceria tipoCarroceria, String transmissao, int anoFabricacao, String cor, String nome, String paisOrigem, long cnpj) {
        super(nome, paisOrigem, cnpj);
        this.nomeModelo = nomeModelo;
        this.tipoVeiculo = tipoVeiculo;
        this.tipoCarroceria = tipoCarroceria;
        this.transmissao = transmissao;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
    }
    
    
    
}
