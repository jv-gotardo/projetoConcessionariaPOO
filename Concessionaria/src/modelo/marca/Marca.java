package modelo.marca;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jvito
 */
public abstract class Marca {
    protected String nome;
    protected String paisOrigem; 
    protected int cnpj; //Ou equivalente para registro de pessoa jurídica
    
    public Marca(String nome, String paisOrigem, int cnpj){
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.cnpj = cnpj;
    }
}
