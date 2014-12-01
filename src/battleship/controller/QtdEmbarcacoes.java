/*
 * Classe que serve apenas para conter as variáveis do numero de navios que tem que ter no jogo ("Struct")
 */
package battleship.controller;

/**
 * Classe que gerencia a quantidade existente de navios.
 * @author Renan O
 */
public class QtdEmbarcacoes {
    
    private int qtdSubmarino = 4;
    private int qtdNavioTamanho2 = 3;
    private int qtdNavioTamanho3 = 2;
    private int qtdNavioTamanho4 = 1;
    private int qtdPortaAvioes = 1;
    
    /**
     * Retorna a quantidade de submarino.
     * @return quantidade de submarino.
     */
    public int getQtdSubmarino() {
        return qtdSubmarino;
    }

    /**
     * Retorna a quantidade de navios de tamanho 2.
     * @return quantidade de navio de tamanho 2.
     */
    public int getQtdNavioTamanho2() {
        return qtdNavioTamanho2;
    }

    /**
     * Retorna a quantidade de navios de tamanho 3.
     * @return quantidade de navios de tamanho 3.
     */
    public int getQtdNavioTamanho3() {
        return qtdNavioTamanho3;
    }

    /**
     * Retorna a quantidade de navios de tamanho 4.
     * @return quantidade de navios de tamanho 4.
     */
    public int getQtdNavioTamanho4() {
        return qtdNavioTamanho4;
    }

    /**
     *
     * @return quantidade de Porta Avioes;
     */
    public int getQtdPortaAvioes() {
        return qtdPortaAvioes;
    }
    
    /**
     * Decrementa a quantidade de submarino.
     */
    public void decrementarSubmarino() {
        qtdSubmarino--;
    }

    /**
     * Decrementa a quantidade de Navios de tamanho 2.
     */
    public void decrementarNavioTamanho2() {
        qtdNavioTamanho2--;
    }

    /**
     * Decrementa a quantidade de navios de tamanho 3.
     */
    public void decrementarNavioTamanho3() {
        qtdNavioTamanho3--;
    }

    /**
     * Decrementa a quantidade de navios de tamanho 4.
     */
    public void decrementarNavioTamanho4() {
        qtdNavioTamanho4--;
    }

    /**
     * Decrementa a quantidade de Porta avioes.
     */
    public void decrementarPortaAvioes() {
        qtdPortaAvioes--;
    }

    /**
     * Insere as quantidades de todos os tipo de embarcações.
     */
    public void setQtdEmbarcacoes() {
        qtdNavioTamanho2 *= 2;
        qtdNavioTamanho3 *= 3;
        qtdNavioTamanho4 *= 4;
        qtdPortaAvioes *= 5;
    }
}
