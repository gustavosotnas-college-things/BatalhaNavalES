package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipHelper;
import battleship.controller.BattleshipMenuException;
import battleship.controller.Posicao;
import battleship.model.Jogo;
import battleship.model.elementos.BombaExplosiva;
import battleship.model.elementos.BombaSinalizadora;
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

    public void comecarTurno(Tabuleiro tabuleiro) throws BattleshipException {
        boolean acontecerAlgo = true;
        while (acontecerAlgo) {
            //System.out.println("Vez do jogador 1...");
            BattleshipGameUI.exibeTabuleiroFiltrado(tabuleiro);
            int x = BattleshipMenuUI.MenuTipoBomba(); //pede para escolher qual tipo de bomba
            Posicao posicao = BattleshipGameUI.menuDetonaBomba();
            switch (x){
                case 1:
                    tabuleiro.setElemento(new BombaExplosiva(tabuleiro.getElemento(posicao)), posicao);
                    break;
                case 2:
                    tabuleiro.setElemento(new BombaSinalizadora(tabuleiro.getElemento(posicao)), posicao);
                    break;
            }
            acontecerAlgo = BattleshipGameUI.exibeTabuleiroFiltrado(tabuleiro);
        }
    }
    
    private static boolean verificaFaltaBomba(ModoPQQD modo){
        
        if(modo.getQtdBombasExplosivas() == 0 || modo.getQtdBombasSinalizadoras() == 0){
            Jogo.setGameOver(true);
            return true;
        }
        return false;
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
