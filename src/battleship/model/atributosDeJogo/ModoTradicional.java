package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipHelper;
import battleship.controller.Posicao;
import battleship.model.Jogo;
import battleship.model.elementos.BombaExplosiva;
import battleship.model.elementos.Celula;
import battleship.model.elementos.Tabuleiro;
import battleship.view.BattleshipGameUI;

/**
 * Classe implementadora de ModoDeJogo, define comportamentos específicos de Modo Tradicional 
 * do Batalha Naval para cada uma das funções delegadas pela interface (padrão Strategy).
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class ModoTradicional implements ModoDeJogo {

    @Override
    public void setMunicaoInicial() {
        //faça nada
    }

    public void comecarTurno(Tabuleiro tabuleiro) {

        boolean acontecerAlgo = true;

        while (acontecerAlgo) {

            try {
                    BattleshipGameUI.exibeTabuleiroFiltrado(tabuleiro);

                    Posicao posicao = BattleshipGameUI.menuDetonaBomba(); //Pede a linha e coluna do alvo no tabuleiro
                    Celula alvo = tabuleiro.getElemento(posicao);

                    tabuleiro.setElementoDistrib(new BombaExplosiva(alvo), posicao);
                    acontecerAlgo = BattleshipGameUI.exibeTabuleiroFiltrado(tabuleiro);
                    BattleshipHelper.getchar();
                    verificaGameOver(tabuleiro);

            } catch (BattleshipException bex) {
                System.err.println(bex.getMessage());
                BattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }
    }

    public void verificaGameOver(Tabuleiro tabuleiro){
        
        if((tabuleiro.getQtdEmbarcacoes().getQtdSubmarino() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho2() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho3() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho4() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdPortaAvioes() == 0)) {

            Jogo.setGameOver(true);
        }
    }

}
