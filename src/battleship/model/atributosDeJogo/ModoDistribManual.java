package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.Posicao;
import battleship.controller.QtdEmbarcacoes;
import battleship.model.elementos.Tabuleiro;
import battleship.model.elementos.embarcacoes.Submarino;
import battleship.view.BattleshipGameUI;

public class ModoDistribManual implements ModoDeDistribuicao{

    @Override
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro) throws BattleshipException {
        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdSubmarino(); i++)
        {
            Posicao coordenada = BattleshipGameUI.menuDistribuirEmbarcacoes(i, "submarino");
            tabuleiro.setElemento(new Submarino(tabuleiro.getElemento(coordenada)) ,coordenada);
        }
    }
    
}
