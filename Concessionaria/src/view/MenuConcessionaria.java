/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import locators.ServiceLocator;
import java.util.*;
import modelo.marca.Marca;

/**
 *
 * @author jvito
 */
public class MenuConcessionaria { 
    List<String> opcoesDisponiveis = new ArrayList();
    ServiceLocator serviceLocator = new ServiceLocator();
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    CoordenadorAcoes ca = new CoordenadorAcoes(serviceLocator, opcoesDisponiveis);
    
    public void chamarMenu(){
        opcoesDisponiveis.add("Criar marca");
        opcoesDisponiveis.add("Criar funcionário");
        opcoesDisponiveis.add("Criar cliente");
        
        while(continuar){
            System.out.println("\nOpções disponíveis:");
            for (int i = 0; i < opcoesDisponiveis.size(); i++) {
                System.out.println((i + 1) + " - " + opcoesDisponiveis.get(i));
            }
         
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            int escolha = sc.nextInt();
            sc.nextLine();
            if(escolha == 0){
                System.out.println("Programa encerrado. \n");
                continuar = false;
            }else if(escolha >= 1 && escolha <= opcoesDisponiveis.size()){
                String acao = opcoesDisponiveis.get(escolha - 1);
                ca.executarAcao(acao, sc);
            }else{
                System.out.println("Opção inválida.\n");
            }
        }
    }
}
