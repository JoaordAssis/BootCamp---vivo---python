/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto1;
import java.util.Scanner;
/**
 *
 * @author joao.assis
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----- QUIZ MATEMATICA -----\n");
        
        System.out.println("Qual e a representacao hexadecimal do numero decimal 9876?\n");
        System.out.println("(A) - 26A4\n");
        System.out.println("(B) - 27AC\n");
        System.out.println("(C) - 2768\n");
        System.out.println("(D) - 2510\n");
        System.out.println("(E) - 26F4\n");
        int tentativas = 0;
         
        do{
            System.out.println("Digite sua resposta:");
            char resp = input.next().charAt(0);
               
            switch(resp){
                case 'A':
                case 'a':
                case 'C':
                case 'c':
                case 'D':
                case 'd':
                case 'E':
                case 'e':
                    System.out.println("Resposta Incorreta! Tente Novamente.");
                    tentativas++;
                    break;
                case 'B':
                case 'b':
                    System.out.println("Resposta Correta!");
                    return;
                default:
                    System.out.println("Opcao Invalida.");
            }
        }while(tentativas < 3);
            System.out.println("As tentativas acabaram.");
        }
        
    }

