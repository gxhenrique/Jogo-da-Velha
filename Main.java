import java.util.Scanner;

public class Main {

    static char[][] tabuleiro = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
    public static void main(String[] args) {

        char jogador = 'X';
        boolean jogoAtual = true;

        Scanner sc = new Scanner(System.in);
       

        while (jogoAtual) {
            System.out.println("Tabuleiro...");
            mostrarTabuleiro();

            System.out.println("Digite as posições de 0 a 2:");
            System.out.print("Linha: ");
            int linha = sc.nextInt();
            System.out.print("Coluna: ");
            int coluna = sc.nextInt();

            if((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2)){
                System.out.println("Somente numeros entre 0 e 2;");
                continue;
            }

            if(tabuleiro[linha][coluna] != ' '){
                System.out.println("posição já ocupada...");
                continue;
            }

            tabuleiro[linha][coluna] = jogador;


            if(verificarVitoria(tabuleiro, jogador)){
                System.out.println("Jogador: " + jogador + " Venceu");
                mostrarTabuleiro();
                jogoAtual = false;
            } else if(verificarEmpate()){
                System.out.println("Empate...");
                mostrarTabuleiro();
                jogoAtual = false;
            }else{
               char outroJogador = (jogador == 'X') ? 'O' : 'X';
               jogador = outroJogador;    
            }
            
        }
        



        sc.close();
    }

    public static void mostrarTabuleiro(){
        for (char[] tab : tabuleiro) {
            for (char c : tab) {
                System.out.print("|" + c  );
            }
            System.out.println("|");
        }
    }


    public static boolean verificarVitoria(char[][] tabJogo, char jogador){

        for(int i = 0; i < 3; i++){
            if((tabJogo[0][i] == jogador) && (tabJogo[1][i] == jogador) && (tabJogo[2][i] == jogador)){
                return true;
            }
        }

        for(int i = 0; i < 3; i++){
            if((tabJogo[i][0] == jogador) && (tabJogo[i][1] == jogador) && (tabJogo[i][2] == jogador)){
                return true;
            }
        }

        if((tabJogo[0][0] == jogador) && (tabJogo[1][1] == jogador) && (tabJogo[2][2] == jogador)){
            return true;
        }

        if((tabJogo[0][2] == jogador) && (tabJogo[1][1] == jogador) && (tabJogo[2][0] == jogador)){
            return true;
        }
        return false;
    }

    public static boolean verificarEmpate(){
           
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tabuleiro[i][j] == ' '){
                    return false;
                }
            }
        }

        return true;
    }
}
