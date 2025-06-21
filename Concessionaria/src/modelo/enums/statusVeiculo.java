/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo.enums;

/**
 *
 * @author jvito
 */
public enum statusVeiculo {
    NOVO{
        @Override
        public double fatorUsoDescontoConcessionaria(double preco){
            return preco * 0.01;
        }
    },
    SEMINOVO{
        @Override
        public double fatorUsoDescontoConcessionaria(double preco){
            return preco * 0.03;
        } 
    },
    USADO{
        @Override
        public double fatorUsoDescontoConcessionaria(double preco){
            return preco * 0.07;
        }  
    };
    public abstract double fatorUsoDescontoConcessionaria(double preco);
}
