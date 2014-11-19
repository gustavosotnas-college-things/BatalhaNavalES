package battleship.view;

import battleship.controller.BattleshipException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        try {
            int modoDeJogo = mainMenuBattleship();
            int nivelDificuldade = menuModoTradicional();
            
        } catch (BattleshipException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private static void menuHeaderBattleship()
    {
        System.out.println("\n=================================================");
        System.out.println("\t\tBATALHA NAVAL");
        System.out.println("=================================================");
        System.out.println("\nMENU\n");
    }
    
    public static int mainMenuBattleship() throws BattleshipException
    {
        Scanner leitor = new Scanner(System.in);
        int opcao;

//        while (!finished)
//        {
        menuHeaderBattleship();
        System.out.println("Escolha o modo do jogo: \n");
        System.out.println("1 - Modo Tradicional");
        System.out.println("2 - Modo PQQD");
        System.out.println("0 - Sair");
        System.out.print("\nOpção: ");
        try {
            opcao = Integer.parseInt(leitor.nextLine().trim());
        } catch (NumberFormatException ex) { // Este catch faz o programa inteiro parar, pois o catch está para o "main"
            throw new BattleshipException("EXCEÇÃO: Opção inválida. Digite apenas números!");
        }
//        }
        return opcao;
    }

    public static int menuModoTradicional() throws BattleshipException
    {
        Scanner leitor = new Scanner(System.in);
        boolean finished = false;
        int opcao = 0;

        while (!finished)
        {
            menuHeaderBattleship();
            System.out.println("Escolha a dificulade: \n");
            System.out.println("1 - Fácil");
            System.out.println("2 - Intermediário");
            System.out.println("3 - Difícil");
            System.out.print("\nOpção: ");
            try {
                opcao = Integer.parseInt(leitor.nextLine().trim());
            } catch (NumberFormatException ex) { // Este catch faz o programa inteiro parar, pois o catch está para o "main"
                throw new BattleshipException("EXCEÇÃO: Opção inválida. Digite apenas números!");
            }
        }
        return opcao;
    }
}
