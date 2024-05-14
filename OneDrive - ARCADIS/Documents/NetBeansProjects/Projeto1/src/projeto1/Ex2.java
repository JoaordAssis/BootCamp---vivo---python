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
public class Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int N = input.nextInt();
        
        int contador = 0;
        
        while(contador < N){
            contador++;
            System.out.println("A soma de " + N + " e " + contador + " e:" + (contador + N));
        }
    }
}
