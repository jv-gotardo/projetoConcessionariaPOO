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
public class Menu { 
    List<String> opcoesDisponiveis = new ArrayList();
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    ServiceLocator sl = new ServiceLocator();
    
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
                executarAcao(acao, sc);
            }else{
                System.out.println("Opção inválida.\n");
            }
        }
    }
    
    private void executarAcao(String acao, Scanner sc){
            }
}
