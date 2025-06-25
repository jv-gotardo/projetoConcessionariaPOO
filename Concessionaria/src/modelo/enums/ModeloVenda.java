/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.enums;

/**
 *
 * @author jvito
 */
public enum ModeloVenda {
    A_VISTA("A Vista"), 
    A_PRAZO("A Prazo"),
    CONSORCIO("Consorcio"),
    PARCELADO("Parcelado");
    
    public final String CODIGO;
    
    ModeloVenda(String codigoString){
        this.CODIGO = codigoString;
    }
}
