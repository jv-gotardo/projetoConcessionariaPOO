/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author jvito
 */
public class BancoObjetos {
    private static final Map<Class<?>, List<Object>> bancoObjetos = new HashMap<>();

    public static <T> void salvar(Class<T> clazz, T objeto) {
        bancoObjetos.computeIfAbsent(clazz, k -> new ArrayList<>()).add(objeto);
    }
    
    public static <T> List<T> listar(Class<T> clazz) {
        return (List<T>) (List<?>) bancoObjetos.getOrDefault(clazz, new ArrayList<>());
    }
    
    public static <T> void remover(Class<T> clazz, T objeto) {
        listar(clazz).remove(objeto);
    }
}
