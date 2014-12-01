package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipGameException;
import battleship.controller.BattleshipHelper;
import battleship.controller.Posicao;
import battleship.model.elementos.Tabuleiro;
import battleship.model.elementos.embarcacoes.*;
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
                    BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                    tabuleiro.setElementoDistrib(new Submarino(tabuleiro.getElemento(coordenada)), coordenada);
                    finished = true;
                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }
            }
        }
    }

    private void distribuirNavioTamanho2(Tabuleiro tabuleiro) {

        boolean finished = false;
        while (!finished) {
 
            processaDistribuicaoNavioTamanho2(tabuleiro);
            finished = true;
        }

    }

    private void processaDistribuicaoNavioTamanho2(Tabuleiro tabuleiro) {

        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho2(); i++) {

            finished = false;
            while (!finished) {
                try {
                    String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX(), coordenada.getY() + 1);

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));

                        tabuleiro.setElementoDistrib(new NavioTamanho2(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);

                        finished = true;
                    }
                    if ("vertical".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX() + 1, coordenada.getY());

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));

                        tabuleiro.setElementoDistrib(new NavioTamanho2(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);

                        finished = true;
                    }

                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }
            }
        }
    }

    private void distribuirNavioTamanho3(Tabuleiro tabuleiro) {

        boolean finished = false;
        while (!finished) {
          
            processaDistribuicaoNavioTamanho3(tabuleiro);
            finished = true;
        }

    }

    private void processaDistribuicaoNavioTamanho3(Tabuleiro tabuleiro) {

        boolean finished = false;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho3(); i++) {

            if (i != tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho2()) {
                finished = false;
            }
            while (!finished) {
                try {
                    String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX(), coordenada.getY() + 1);
                        Posicao coordenada3 = new Posicao(coordenada.getX(), coordenada.getY() + 2);

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada3));

                        tabuleiro.setElementoDistrib(new NavioTamanho3(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada3);
                        finished = true;

                    }
                    if ("vertical".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX() + 1, coordenada.getY());
                        Posicao coordenada3 = new Posicao(coordenada.getX() + 2, coordenada.getY());

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada3));

                        tabuleiro.setElementoDistrib(new NavioTamanho3(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada3);

                        finished = true;
                    }

                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }
            }

        }

    }

    private void distribuirNavioTamanho4(Tabuleiro tabuleiro) {

        boolean finished = false;
        while (!finished) {
            
            processaDistribuicaoNavioTamanho4(tabuleiro);
            finished = true;
        }
    }

    private void processaDistribuicaoNavioTamanho4(Tabuleiro tabuleiro) {

        boolean finished = false;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho4(); i++) {
            while (!finished) {
                try {
                    String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX(), coordenada.getY() + 1);
                        Posicao coordenada3 = new Posicao(coordenada.getX(), coordenada.getY() + 2);
                        Posicao coordenada4 = new Posicao(coordenada.getX(), coordenada.getY() + 3);

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada3));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada4));

                        tabuleiro.setElementoDistrib(new NavioTamanho4(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada3);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada4);

                        finished = true;

                    }
                    if ("vertical".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX() + 1, coordenada.getY());
                        Posicao coordenada3 = new Posicao(coordenada.getX() + 2, coordenada.getY());
                        Posicao coordenada4 = new Posicao(coordenada.getX() + 3, coordenada.getY());

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada3));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada4));

                        tabuleiro.setElementoDistrib(new NavioTamanho4(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada3);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada4);

                        finished = true;
                    }

                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }
            }

        }
    }

    private void distribuirPortaAvioes(Tabuleiro tabuleiro) {

        boolean finished = false;
        while (!finished) {
            
            processaDistribuicaoPortaAvioes(tabuleiro);
            finished = true;
        }
    }

    private void processaDistribuicaoPortaAvioes(Tabuleiro tabuleiro) {

        boolean finished = false;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdPortaAvioes(); i++) {
            while (!finished) {
                try {
                    String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX(), coordenada.getY() + 1);
                        Posicao coordenada3 = new Posicao(coordenada.getX(), coordenada.getY() + 2);
                        Posicao coordenada4 = new Posicao(coordenada.getX() + 1, coordenada.getY() + 1);
                        Posicao coordenada5 = new Posicao(coordenada.getX() + 2, coordenada.getY() + 1);

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada3));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada4));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada5));

                        tabuleiro.setElementoDistrib(new PortaAvioes(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada3);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada4);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada5);

                        finished = true;

                    }
                    if ("vertical".equals(orientacao)) {

                        Posicao coordenada2 = new Posicao(coordenada.getX() + 1, coordenada.getY());
                        Posicao coordenada3 = new Posicao(coordenada.getX() + 2, coordenada.getY());
                        Posicao coordenada4 = new Posicao(coordenada.getX() + 1, coordenada.getY() + 1);
                        Posicao coordenada5 = new Posicao(coordenada.getX() + 1, coordenada.getY() + 1);

                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada2));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada3));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada4));
                        BattleshipHelper.verificaSobreposicao(tabuleiro.getElemento(coordenada5));

                        tabuleiro.setElementoDistrib(new PortaAvioes(tabuleiro.getElemento(coordenada)), coordenada);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada2);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada3);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada4);
                        tabuleiro.setElementoDistrib(tabuleiro.getElemento(coordenada), coordenada5);

                        finished = true;
                    }
                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }

            }
        }
    }
}
