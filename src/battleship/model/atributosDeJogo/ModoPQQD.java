package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipHelper;
import battleship.controller.BattleshipMenuException;
import battleship.controller.Posicao;
import battleship.model.Jogo;
import battleship.model.elementos.Celula;
import battleship.model.elementos.Fogo;
import battleship.model.elementos.Tabuleiro;
import battleship.view.BattleshipGameUI;
import battleship.view.BattleshipMenuUI;

/**
 * Classe implementadora de ModoDeJogo, define comportamentos específicos de Modo PQQD
 * ("Professor Quer Quebrar o meu Design") do Batalha Naval para cada uma 
 * das funções delegadas pela interface (padrão Strategy).
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
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
                    Fogo bomba = BattleshipHelper.processarMenuTipoBombaPQQD(BattleshipMenuUI.MenuTipoBomba(), alvo, this); //pede para escolher qual tipo de bomba

                    tabuleiro.setElemento(bomba, posicao);
                    
                    acontecerAlgo = BattleshipGameUI.exibeTabuleiroFiltrado(tabuleiro);
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

    /**
     * Getter específico de ModoPQQD, da variável contadora de bombas sinalizadoras, 
     * definidas inicialmente pelo usuário.
     * 
     * @return  a quantidade de bombas sinalizadoras atual no jogo.
     */
    public int getQtdBombasSinalizadoras() {
        return qtdBombasSinalizadoras;
    }

    /**
     * Setter específico de ModoPQQD, da variável contadora de bombas sinalizadoras, 
     * usado para definir inicialmente a quantidade de bombas sinalizadoras para uso no Batalha Naval.
     * 
     * @param qtdBombasSinalizadoras  a quantidade de bombas sinalizadoras desejada pelo usuário.
     */
    public void setQtdBombasSinalizadoras(int qtdBombasSinalizadoras) {
        this.qtdBombasSinalizadoras = qtdBombasSinalizadoras;
    }

    /**
     * Getter específico de ModoPQQD, da variável contadora de bombas explosivas, 
     * definidas inicialmente pelo usuário.
     * 
     * @return  a quantidade de bombas explosivas atual no jogo.
     */
    public int getQtdBombasExplosivas() {
        return qtdBombasExplosivas;
    }

    /**
     * Setter específico de ModoPQQD, da variável contadora de bombas explosivas, 
     * usado para definir inicialmente a quantidade de bombas explosivas para uso no Batalha Naval.
     * 
     * @param qtdBombasExplosivas  a quantidade de bombas explosivas desejada pelo usuário.
     */
    public void setQtdBombasExplosivas(int qtdBombasExplosivas) {
        this.qtdBombasExplosivas = qtdBombasExplosivas;
    }

}
