package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Celula;

/**
 * Classe que possui as funções que gerenciam as decorações de submarino.
 *
 * @author Renan O
 * @author Gustavo Moraes
 */
public class Submarino extends Embarcacao {

    Celula tabuleiro;
    private final String nome = "Submarino";

    /**
     * Construtor seta a celula recebida para uma variavel de Celula.
     *
     * @param tabuleiro celula de tabuleiro.
     */
    public Submarino(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    /**
     * Retorna os conteudos de celula mais da classe.
     *
     * @return conteudo da celula incrementado do conteudo de classe.
     *
     */
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "S";
    }

    /**
     * Retorna nome da celula.
     * @return nome da celula
     */
    @Override
    public String getNome() {
        return nome;
    }
}
