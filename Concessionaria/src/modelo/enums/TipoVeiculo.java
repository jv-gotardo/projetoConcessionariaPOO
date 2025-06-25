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
    AUTOMOVEL("Automóvel"),
    MICRO_ONIBUS("Micro-ônibus"),
    ONIBUS("Ônibus"),
    REBOQUE("Reboque"),
    SEMIRREBOQUE("Semirreboque"),
    CAMIONETA("Camioneta"),
    CAMINHAO("Caminhão"),
    TRATOR("Trator"),
    QUADRICICLO("Quadriciclo"),
    CAMINHONETE("Caminhonete"),
    UTILITARIO("Utilitário");
    
    public final String CODIGO;
    
    TipoVeiculo(String codigoString){
        this.CODIGO = codigoString;
    }
}
