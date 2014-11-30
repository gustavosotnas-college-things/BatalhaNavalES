package battleship.model.elementos;

import battleship.controller.BattleshipGameException;
import battleship.controller.Posicao;
import battleship.controller.QtdEmbarcacoes;

/**
 * Classe que contém a abstração do tabuleiro, a parte fundamental do jogo de Batalha Naval.
 * Todos os dados necessários para a execução do Batalha Naval.
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class Tabuleiro {
    
    /**
     * Matriz de Célula: elemento base de tabuleiro - objetos decorados com elementos de jogo (padrão Decorator).
     */
    public Celula[][] tabuleiro;
    private final int numeroJogador;
    private final int tamanho;
    private QtdEmbarcacoes qtdEmbarcacoes;
    
    /**
     * Cria um novo tabuleiro com todas as células decoradas com água.
     * 
     * @param player  número do jogador (dono do tabuleiro)
     * @param tamanho  tamanho do tabuleiro (matriz de Celula)
     */
    public Tabuleiro(int player, int tamanho){
        this.tabuleiro = new Celula[tamanho][tamanho];
        this.numeroJogador = player;
        this.tamanho = tamanho;
        this.qtdEmbarcacoes = new QtdEmbarcacoes();
        inicializarCelulas();
    }
    
    private void inicializarCelulas(){
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                    Celula celula = new Terreno();
                    celula = new Agua(celula);
                    tabuleiro[i][j] = celula;
            }
        }
    }

    /**
     * Getter que retorna o conjunto de células que compõem um tabuleiro.
     * @return  a matriz de celula contendo todo o conteúdo do tabuleiro
     */
    public Celula[][] getTabuleiro() {
        return tabuleiro;
    }
    
    /**
     * Getter que retorna apenas uma célula do tabuleiro desejada.
     * 
     * @param coord uma Posicao do tabuleiro
     * @return uma Celula do tabuleiro
     */
    public Celula getElemento(Posicao coord){
        return tabuleiro[coord.getX()][coord.getY()];
    }

    public void setElemento(Celula conteudo,Posicao coord) throws BattleshipGameException {
        if(conteudo.getNome().equals(tabuleiro[coord.getX()][coord.getY()].getNome())) //se já tem tal elemento decorado anteriormente em dada posicao
        {
            throw new BattleshipGameException("Nesta posição já existe um " + conteudo.getNome());
        }else {
            tabuleiro[coord.getX()][coord.getY()] = conteudo;
            registrarExplosao(tabuleiro[coord.getX()][coord.getY()]);
        }
    }
    
    private void registrarExplosao(Celula celula) {
        switch(celula.whoami().substring(celula.whoami().length()-1)){
            case "1":
                qtdEmbarcacoes.decrementarSubmarino();
                break;
            case "2":
                qtdEmbarcacoes.decrementarNavioTamanho2();
                break;
            case "3":
                qtdEmbarcacoes.decrementarNavioTamanho3();
                break;
            case "4":
                qtdEmbarcacoes.decrementarNavioTamanho4();
                break;
            case "P":
                qtdEmbarcacoes.decrementarPortaAvioes();
                break;
        }
    }

    /**
     * Getter para obter o número do jogador (dono do tabuleiro).
     * 
     * @return o número do jogador
     */
    public int getNumeroJogador() {
        return numeroJogador;
    }

    /**
     * Getter para obter o tamanho do tabuleiro (tamanho da matriz de celula).
     * 
     * @return o tamanho do tabuleiro
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Getter para obter a quantidade de embarcações atual do tabuleiro
     * 
     * @return o objeto contendo a quantidade de embarcações do tabuleiro
     */
    public QtdEmbarcacoes getQtdEmbarcacoes() {
        return qtdEmbarcacoes;
    }
}
