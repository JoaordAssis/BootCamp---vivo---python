/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto1;
import java.util.Scanner;
/**
 *
 * @author joao.assis FONTE CHUNKY
 */
public class teste {

    public static void main(String[] args) {
        System.out.println(" _______         __           _______                __\n"
                + "|   |   |.---.-.|  |_ .-----.|   |   |.---.-..-----.|__|.----..---.-.\n"
                + "|       ||  _  ||   _||  -__||       ||  _  ||  _  ||  ||  __||  _  |\n"
                + "|__|_|__||___._||____||_____||__|_|__||___._||___  ||__||____||___._|\n"
                + "                                             |_____|");

        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("1 - Instruções");
            System.out.println("2 - Jogar");
            System.out.println("3 - Créditos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1 -> System.out.println("Você escolheu a opção Instruções");
                case 2 -> System.out.println("Você escolheu a opção Jogar");
                case 3 -> System.out.println("Você escolheu a opção Créditos");
                case 4 -> System.out.println("Você escolheu a opção Sair");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }
}
