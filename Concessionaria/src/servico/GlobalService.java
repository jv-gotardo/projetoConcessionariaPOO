/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import java.time.LocalDate;

/**
 *
 * @author jvito
 */
public class GlobalService {
    public LocalDate formatarData(String dataRecebida){
        String[] conjuntoData = dataRecebida.split("/");
        LocalDate retornado = LocalDate.of(Integer.parseInt(conjuntoData[0]), 
                Integer.parseInt(conjuntoData[1]), 
                Integer.parseInt(conjuntoData[2]));
        return retornado;
    }
    
    public String imprimirData(LocalDate localDate){
        String data = (localDate.getDayOfMonth() + "/" + localDate.getMonth() +
                "/" + localDate.getYear());
        return data;
    }
}
