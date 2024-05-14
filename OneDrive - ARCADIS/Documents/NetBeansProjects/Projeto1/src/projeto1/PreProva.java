/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto1;
import java.util.Scanner;
/**
 *
 * @author joao.assis
 */
public class PreProva {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("IMPAR / PAR");
        System.out.print("DIGITE O NUMERO LIMITE:");
        int Lim = input.nextInt();
                
        for(int i = 0; i < Lim + 1; i++){
            if(i % 2 == 0){
                System.out.println(i + " e par");
            }else{
                System.out.println(i + " e impar");
            }
        }
        
    }
}

