package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipHelper;
import battleship.controller.BattleshipMenuException;
import battleship.controller.Posicao;
import battleship.model.Jogo;
import battleship.model.elementos.BombaExplosiva;
import battleship.model.elementos.BombaSinalizadora;
import battleship.model.elementos.Celula;
import battleship.model.elementos.Fogo;
import battleship.model.elementos.Tabuleiro;
import battleship.view.BattleshipGameUI;
import battleship.view.BattleshipMenuUI;

public class ModoPQQD implements ModoDeJogo {

    private int qtdBombasSinalizadoras;
    private int qtdBombasExplosivas;

    public void setMunicaoInicial() {

        boolean finished = false;

        while (!finished) {

            int[] bomb = null;
            try {
                bomb = BattleshipGameUI.menuSetarMunicaoPQQD();
                finished = true;
            } catch (BattleshipMenuException bmex) {
                System.err.println(bmex.getMessage());
                BattleshipHelper.sleep(1); //pausa de 1 segundo
            }
            this.qtdBombasSinalizadoras = bomb[0];
            this.qtdBombasExplosivas = bomb[1];
        }
    }

    public void comecarTurno(Tabuleiro tabuleiro) {

        boolean acontecerAlgo = true;

        while (acontecerAlgo) {

            try {
                    BattleshipGameUI.exibeTabuleiroFiltrado(tabuleiro);

                    Posicao posicao = BattleshipGameUI.menuDetonaBomba(); //Pede a linha e coluna do alvo no tabuleiro
                    Celula alvo = tabuleiro.getElemento(posicao);
                    Fogo bomba = BattleshipHelper.processarMenuTipoBombaPQQD(BattleshipGameUI.menuTipoBomba(), alvo, this); //pede para escolher qual tipo de bomba

                    tabuleiro.setElementoDistrib(bomba, posicao);
                    
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
        
        if((this.getQtdBombasExplosivas() == 0 || this.getQtdBombasSinalizadoras() == 0) ||
            ((tabuleiro.getQtdEmbarcacoes().getQtdSubmarino() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho2() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho3() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho4() == 0) || 
             (tabuleiro.getQtdEmbarcacoes().getQtdPortaAvioes() == 0))) {

            Jogo.setGameOver(true);
        }
    }

    public int getQtdBombasSinalizadoras() {
        return qtdBombasSinalizadoras;
    }

    public void setQtdBombasSinalizadoras(int qtdBombasSinalizadoras) {
        this.qtdBombasSinalizadoras = qtdBombasSinalizadoras;
    }

    public int getQtdBombasExplosivas() {
        return qtdBombasExplosivas;
    }

    public void setQtdBombasExplosivas(int qtdBombasExplosivas) {
        this.qtdBombasExplosivas = qtdBombasExplosivas;
    }

}
