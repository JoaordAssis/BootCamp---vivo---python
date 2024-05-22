import java.util.Scanner;

/*********************************************************************/
/** Centro Universitario Senac                                      **/
/** TADS - 1o semestre de 2024                                      **/
/** Professor: Fernando Almeida                                     **/
/**                                                                 **/
/** Projeto SEMESTRAL I                                             **/
/** Arquivo: JogoVelha.java                                         **/
/**                                                                 **/
/** Ana Beatriz Santos Tolentino                                    **/
/** Igor Souza Pureza                                               **/
/** João Carlos Rodrigues de Assis                                  **/
/**                                                                 **/
/** 27 de maio de 2024                                              **/
/*********************************************************************/

public class JogoVelha {

    static Scanner input = new Scanner(System.in);
    
    static int linha;
    static int coluna;
    
    static String jogador1;
    static String jogador2;
    
    static char[][] tabuleiro = new char[3][3];
    
    static int pontosJogador1 = 0;
    static int pontosJogador2 = 0;

    public static void main(String[] args) {
        imprimeMenuPrincipal();
    }

    public static void imprimeMenuPrincipal() {
        boolean escolha;
        do {
            
            System.out.println("""
                               -----  MENU  -----
                               (1) Modo Jogador
                               (2) Modo Fácil
                               (3) Modo Difícil
                               (4) Sair
                               """);
            
            System.out.println("Digite a opcaoo desejada: ");
            int op = input.nextInt();
            
            switch (op) {
                case 1 -> {
                    modoJogador();
                    escolha = true;
                }
                case 2 -> {
                    modoFacil();
                    escolha = true;
                }
                case 3 -> {
                    modoDificil();
                    escolha = true;
                }
                case 4 -> {
                    System.out.println("Você escolheu sair.");
                    escolha = true;
                }
                default -> {
                    System.out.println("Opção inválida!!!");
                    escolha = false;
                }
            }

        } while (escolha == false);
    }

    public static void modoJogador() {
        
        System.out.println("Você escolheu o modo Jogador.");
        
        inicializarTabuleiro();
        
        jogadores();
        
        while (pontosJogador1 < 3 && pontosJogador2 < 3) {
            boolean jogoTerminado = false;
            
            char jogadorAtual = 'X';
            
            while (jogoTerminado == false) {
                
                impimeTabuleiro();
                
                if (jogadorAtual == 'X') {
                    System.out.println("Vez do jogador " + jogador1 + " (X)");
                } else {
                    System.out.println("Vez do jogador " + jogador2 + " (O)");
                }
                
                linha = leiaCoordenadaLinha();
                coluna = leiaCoordenadaColuna();
                
                while (!posicaoValida(linha, coluna)) {
                    System.out.println("Posição inválida. Tente novamente.");
                    linha = leiaCoordenadaLinha();
                    coluna = leiaCoordenadaColuna();
                }
                
                jogar(linha, coluna, jogadorAtual);
                
                if (verificaVencedor(jogadorAtual)) {
                    impimeTabuleiro();
                    if (jogadorAtual == 'X') {
                        System.out.println("Jogador " + jogador1 + " venceu!");
                        pontosJogador1++;
                    } else {
                        System.out.println("Jogador " + jogador2 + " venceu!");
                        pontosJogador2++;
                    }
                    jogoTerminado = true;
                } else if (verificaVelha()) {
                    impimeTabuleiro();
                    System.out.println("Deu velha!");
                    jogoTerminado = true;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }
            inicializarTabuleiro();
            imprimePontuacao();
        }
        System.out.println("Partida encerrada. Jogador " + (pontosJogador1 == 3 ? jogador1 : jogador2) + " venceu a partida!");
    }

    public static void jogadores() {
        System.out.print("Digite o nome do jogador 1 (X): ");
        jogador1 = input.next();
        System.out.print("Digite o nome do jogador 2 (O): ");
        jogador2 = input.next();
    }

    public static void modoFacil() {
        System.out.println("Você escolheu o modo fácil.");
        // Implementação similar ao modo jogador, mas com jogadas da máquina fáceis
    }

    public static void modoDificil() {
        System.out.println("Modo difícil");
        // Implementação similar ao modo jogador, mas com jogadas da máquina difíceis
    }

    public static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '_';
            }
        }
    }

    public static void impimeTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public static int leiaCoordenadaLinha() {
        System.out.println("Digite a linha desejada (0, 1 ou 2):");
        return input.nextInt();
    }

    public static int leiaCoordenadaColuna() {
        System.out.println("Digite a coluna desejada (0, 1 ou 2):");
        return input.nextInt();
    }

    public static boolean posicaoValida(int l, int c) {
        if(tabuleiro[l][c] != '_') {
            return false;
        }
        return true;
    }

    public static void jogar(int l, int c, char jogador) {
        tabuleiro[l][c] = jogador;
    }

    public static boolean verificaVencedor(char jogador) {
        //verificando linhas do tabuleiro
        
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }
        // verificando colunas do tabuleirp
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true;
            }
        }
        //verificanco diagonais do tabuleiro
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }
        
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }
        return false;
    }

    public static boolean verificaVelha() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimePontuacao() {
        System.out.println("Pontuação:");
        System.out.println(jogador1 + " (X): " + pontosJogador1);
        System.out.println(jogador2 + " (O): " + pontosJogador2);
    }
    
    
}
