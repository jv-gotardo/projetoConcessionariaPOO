/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo.enums;

/**
 *
 * @author jvito
 */
public enum TipoVeiculo {
    CICLOMOTOR("Ciclomotor"),
    MOTONETA("Motoneta"),
    MOTOCICLETA("Motocicleta"),
    TRICICLO("Triciclo"),
    AUTOMOVEL("Automovel"),
    MICRO_ONIBUS("Micro-onibus"),
    ONIBUS("Onibus"),
    REBOQUE("Reboque"),
    SEMIRREBOQUE("Semirreboque"),
    CAMIONETA("Camioneta"),
    CAMINHAO("Caminhao"),
    TRATOR("Trator"),
    QUADRICICLO("Quadriciclo"),
    CAMINHONETE("Caminhonete"),
    UTILITARIO("Utilitario");
    
    public final String CODIGO;
    
    TipoVeiculo(String codigoString){
        this.CODIGO = codigoString;
    }
}
