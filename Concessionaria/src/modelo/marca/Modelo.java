package modelo.marca;

import java.time.LocalDate;
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
public abstract class Modelo extends Marca {
    protected String nomeModelo;
    protected TipoVeiculo tipoVeiculo;
    protected TipoCarroceria tipoCarroceria; 
    protected String transmissao;
    protected int anoFabricacao;
    protected String cor;
    
    public Modelo(String nome, String paisOrigem, int cnpj, String modeloNome, TipoVeiculo tipoVeiculo,
                  TipoCarroceria tipoCarroceria, String transmissao, int anoFabricacao, String cor){
        super(nome, paisOrigem, cnpj);
        modeloNome = this.nomeModelo;
        tipoVeiculo = this.tipoVeiculo;
        tipoCarroceria = this.tipoCarroceria;
        transmissao = this.transmissao;
        anoFabricacao = this.anoFabricacao;
        cor = this.cor;
    }
}
