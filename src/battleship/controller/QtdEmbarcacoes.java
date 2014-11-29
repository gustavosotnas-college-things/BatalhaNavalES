/*
 * Classe que serve apenas para conter as variáveis do numero de navios que tem que ter no jogo ("Struct")
 */
package battleship.controller;

public class QtdEmbarcacoes {
    
    private int qtdSubmarino = 4;
    private int qtdNavioTamanho2 = 3;
    private int qtdNavioTamanho3 = 2;
    private int qtdNavioTamanho4 = 1;
    private int qtdPortaAvioes = 1;
    
    public int getQtdSubmarino() {
        return qtdSubmarino;
    }

    public int getQtdNavioTamanho2() {
        return qtdNavioTamanho2;
    }

    public int getQtdNavioTamanho3() {
        return qtdNavioTamanho3;
    }

    public int getQtdNavioTamanho4() {
        return qtdNavioTamanho4;
    }

    public int getQtdPortaAvioes() {
        return qtdPortaAvioes;
    }
    
    public void decrementarSubmarino() {
        qtdSubmarino--;
    }

    public void decrementarNavioTamanho2() {
        qtdNavioTamanho2--;
    }

    public void decrementarNavioTamanho3() {
        qtdNavioTamanho3--;
    }

    public void decrementarNavioTamanho4() {
        qtdNavioTamanho4--;
    }

    public void decrementarPortaAvioes() {
        qtdPortaAvioes--;
    }

    public void setQtdEmbarcacoes() {
        qtdNavioTamanho2 *= 2;
        qtdNavioTamanho3 *= 3;
        qtdNavioTamanho4 *= 4;
        qtdPortaAvioes *= 5;
    }
}
