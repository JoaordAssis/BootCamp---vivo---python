/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto1;

/**
 *
 * @author joao.assis
 */
public class DesenhoConsole {

    public static void main(String[] args) {
        desenharQuadrados();
    }

    public static void desenharQuadrados() {
        int tamanho1 = 3;
        int tamanho2 = 4;
        int tamanho3 = 5;
        
        // Desenha o quadrado 3x3
        for (int i = 0; i < tamanho1; i++) {
            for (int j = 0; j < tamanho1; j++) {
                System.out.print("x ");
            }
            // Adiciona espaço entre os quadrados
            System.out.print("   ");
            // Desenha o quadrado 4x4
            for (int j = 0; j < tamanho2; j++) {
                System.out.print("x ");
            }
            System.out.print("   ");
            for (int j = 0; j < tamanho3; j++) {
                System.out.print("x ");
            }
            System.out.println(); // Quebra de linha entre os quadrados
        }
    }
}



