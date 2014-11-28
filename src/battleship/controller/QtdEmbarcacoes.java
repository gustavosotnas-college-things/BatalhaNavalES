/*
 * Classe que serve apenas para conter as variáveis do numero de navios que tem que ter no jogo ("Struct")
 */
package battleship.controller;

public abstract class QtdEmbarcacoes {
    
    private static final int qtdSubmarino = 4;
    private static final int qtdNavioTamanho2 = 3;
    private static final int qtdNavioTamanho3 = 2;
    private static final int qtdNavioTamanho4 = 1;
    private static final int qtdPortaAvioes = 1;
    
    public static int getQtdSubmarino() {
        return qtdSubmarino;
    }

    public static int getQtdNavioTamanho2() {
        return qtdNavioTamanho2;
    }

    public static int getQtdNavioTamanho3() {
        return qtdNavioTamanho3;
    }

    public static int getQtdNavioTamanho4() {
        return qtdNavioTamanho4;
    }

    public static int getQtdPortaAvioes() {
        return qtdPortaAvioes;
    }
}
