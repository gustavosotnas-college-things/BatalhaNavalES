package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.Posicao;
import battleship.controller.QtdEmbarcacoes;
import battleship.model.elementos.Tabuleiro;
import battleship.model.elementos.embarcacoes.Submarino;
import java.util.Random;

public class ModoDistribAuto implements ModoDeDistribuicao{

    @Override
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro) throws BattleshipException {
        Random gerador = new Random();
        for (int i = 0; i < QtdEmbarcacoes.getQtdSubmarino(); i++)
        {
            Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));
            tabuleiro.setElemento(new Submarino(tabuleiro.getElemento(coordenada)) ,coordenada);
        }
    }
}