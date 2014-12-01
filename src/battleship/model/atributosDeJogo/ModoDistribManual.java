package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.Posicao;
import battleship.model.elementos.Tabuleiro;
import battleship.model.elementos.embarcacoes.Submarino;
import battleship.view.BattleshipGameUI;

/**
 * Realiza todas as operações necessarias para que o jogo execute com sucesso realizando 
 * distribuição automatica.
 * @author Renan O
 * @author Gustavo Moraes
 */
public class ModoDistribManual implements ModoDeDistribuicao{

    @Override
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro) {
        distribuirSubmarino(tabuleiro);
        distribuirNavioTamanho2(tabuleiro);
        distribuirNavioTamanho3(tabuleiro);
        distribuirNavioTamanho4(tabuleiro);
        distribuirPortaAvioes(tabuleiro);
    }
    private void distribuirSubmarino (Tabuleiro tabuleiro) {

        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdSubmarino(); i++)
        {
            finished = false;
            while (!finished) {
            
                try {
                    Posicao coordenada = BattleshipGameUI.menuDistribuicaoLinhaColuna(i, "submarino");
                    tabuleiro.setElementoDistrib(new Submarino(tabuleiro.getElemento(coordenada)) ,coordenada);
                    finished = true;
                } catch (BattleshipException bex) {
                    System.err.println(bex.getMessage());
                }
            }
        }
    }

    private void distribuirNavioTamanho2(Tabuleiro tabuleiro) {
       //a implementar
    }

    private void distribuirNavioTamanho3(Tabuleiro tabuleiro) {
        //a implementar
    }

    private void distribuirNavioTamanho4(Tabuleiro tabuleiro) {
        //a implementar
    }

    private void distribuirPortaAvioes(Tabuleiro tabuleiro) {
        //a implementar
        tabuleiro.getQtdEmbarcacoes().setQtdEmbarcacoes();
    }
}
