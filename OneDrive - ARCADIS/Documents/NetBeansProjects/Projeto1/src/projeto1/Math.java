/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto1;
import java.util.Random;
/**
 *
 * @author joao.assis
 */
public class Math {
    public static void main(String[] args) {
        
        int totalLancamentos = 1000000;
        int[] contagemFaces = new int[6];

        Random random = new Random();

        for (int i = 0; i < totalLancamentos; i++) {
            int resultado = random.nextInt(6) + 1;
            contagemFaces[resultado - 1]++;
        }

        System.out.println("Porcentagem de vezes que cada face apareceu:");
        for (int i = 0; i < 6; i++) {
            double porcentagem = (double) contagemFaces[i] / totalLancamentos * 100;
            System.out.printf("Face %d: %.2f%%\n", i + 1, porcentagem);
        }
    }
}
