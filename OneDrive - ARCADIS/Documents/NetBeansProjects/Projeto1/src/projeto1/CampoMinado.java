import java.util.Random;
import java.util.Scanner;

public class CaminhoMinado {
    private int[] caminho;
    private int tamanhoCaminho;
    private int numBombas;
    private int pontos;

    // Construtor
    public CaminhoMinado(int tamanhoCaminho, int numBombas) {
        this.tamanhoCaminho = tamanhoCaminho;
        this.numBombas = numBombas;
        caminho = new int[tamanhoCaminho];
        pontos = 0;
    }

    // Método para iniciar o jogo
    public void iniciarJogo() {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Colocar bombas aleatoriamente no caminho
        for (int i = 0; i < numBombas; i++) {
            int posicao = rand.nextInt(tamanhoCaminho);
            while (caminho[posicao] == -1) {
                posicao = rand.nextInt(tamanhoCaminho);
            }
            caminho[posicao] = -1;
        }

        // Jogar
        while (true) {
            imprimirCaminho();
            System.out.print("Escolha uma posição (0-" + (tamanhoCaminho - 1) + "): ");
            int posicaoEscolhida = scanner.nextInt();

            if (posicaoEscolhida < 0 || posicaoEscolhida >= tamanhoCaminho) {
                System.out.println("Posição inválida. Tente novamente.");
                continue;
            }

            if (caminho[posicaoEscolhida] == -1) {
                System.out.println("Game Over!");
                break;
            }

            if (caminho[posicaoEscolhida] == 0) {
                if (temBombaProxima(posicaoEscolhida)) {
                    System.out.println("Cuidado: bomba próxima!");
                }
                caminho[posicaoEscolhida] = 1;
                pontos++;
            }

            if (pontos == tamanhoCaminho - numBombas) {
                System.out.println("Parabéns, você ganhou o jogo!");
                break;
            }
        }
        scanner.close();
    }

    // Método para verificar se há bombas próximas
    private boolean temBombaProxima(int posicao) {
        if ((posicao > 0 && caminho[posicao - 1] == -1) || (posicao < tamanhoCaminho - 1 && caminho[posicao + 1] == -1)) {
            return true;
        }
        return false;
    }

    // Método para imprimir o caminho
    private void imprimirCaminho() {
        for (int i = 0; i < tamanhoCaminho; i++) {
            if (caminho[i] == 1) {
                System.out.print(" x ");
            } else if (caminho[i] == -1) {
                System.out.print(" b ");
            } else {
                System.out.print(" _ ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Caminho Minado!");
        System.out.print("Digite o tamanho do caminho: ");
        int tamanhoCaminho = scanner.nextInt();
        System.out.print("Digite o número de bombas: ");
        int numBombas = scanner.nextInt();

        CaminhoMinado jogo = new CaminhoMinado(tamanhoCaminho, numBombas);
        jogo.iniciarJogo();

        scanner.close();
    }
}
