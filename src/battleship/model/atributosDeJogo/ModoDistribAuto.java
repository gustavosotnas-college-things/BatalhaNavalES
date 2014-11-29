package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipGameException;
import battleship.controller.BattleshipHelper;
import battleship.controller.Posicao;
import battleship.model.elementos.Tabuleiro;
import battleship.model.elementos.embarcacoes.NavioTamanho2;
import battleship.model.elementos.embarcacoes.Submarino;
import java.util.Random;

public class ModoDistribAuto implements ModoDeDistribuicao {

    private Random gerador = new Random();

    @Override
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro) {
        distribuirSubmarino(tabuleiro);
        distribuirNavioTamanho2(tabuleiro);
        distribuirNavioTamanho3(tabuleiro);
        distribuirNavioTamanho4(tabuleiro);
        distribuirPortaAvioes(tabuleiro);
    }

    private void distribuirSubmarino(Tabuleiro tabuleiro) {

        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdSubmarino(); i++) {

            finished = false;
            while (!finished) {
            
                try {
                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));
                    tabuleiro.setElemento(new Submarino(tabuleiro.getElemento(coordenada)) ,coordenada);
                    finished = true;
                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }
            }
        }
    }

    private void distribuirNavioTamanho2(Tabuleiro tabuleiro) {
        //a implementar 
        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdSubmarino(); i++) {

            finished = false;
            while (!finished) {

                try {
                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));
                    String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(3));
                    tabuleiro.setElemento(new NavioTamanho2(tabuleiro.getElemento(coordenada)) ,coordenada);
                    
                    if("horizontal".equals(orientacao)){
                        tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY()+1));
                    }
                    else{
                        tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX()+1, coordenada.getY()));
                    }
                    finished = true;
                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }
            }
        }
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