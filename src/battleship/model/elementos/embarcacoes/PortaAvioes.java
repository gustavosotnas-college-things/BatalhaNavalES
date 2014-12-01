package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Celula;

/**
 * Classe que possui as funções que gerenciam as decorações de um Porta Avioes.
 *
 * @author Renan O
 * @author Gustavo Moraes
 */
public class PortaAvioes extends Embarcacao {

    Celula tabuleiro;
    private final String nome = "Porta Aviões (T)";

    /**
     * Construtor seta a celula recebida para uma variavel de Celula.
     *
     * @param tabuleiro celula de tabuleiro.
     */
    public PortaAvioes(Celula tabuleiro) {
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
        return tabuleiro.whoami() + "P";
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
