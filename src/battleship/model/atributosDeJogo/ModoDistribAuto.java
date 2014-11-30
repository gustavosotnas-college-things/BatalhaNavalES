package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipGameException;
import battleship.controller.BattleshipHelper;
import battleship.controller.Posicao;
import battleship.model.elementos.Tabuleiro;
import battleship.model.elementos.embarcacoes.NavioTamanho2;
import battleship.model.elementos.embarcacoes.NavioTamanho3;
import battleship.model.elementos.embarcacoes.NavioTamanho4;
import battleship.model.elementos.embarcacoes.PortaAvioes;
import battleship.model.elementos.embarcacoes.Submarino;
import java.util.Random;

public class ModoDistribAuto implements ModoDeDistribuicao {

    private Random gerador = new Random();

    @Override
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro) throws BattleshipGameException {
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
                    tabuleiro.setElemento(new Submarino(tabuleiro.getElemento(coordenada)), coordenada);
                    finished = true;
                } catch (BattleshipGameException bgex) {
                    // faça nada, o while vai fazer gerar outra Posicao
                }
            }
        }
    }

    private void distribuirNavioTamanho2(Tabuleiro tabuleiro) throws BattleshipGameException {

        String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
        processaDistribuicaoNavioTamanho2(tabuleiro, orientacao);
    }

    private void processaDistribuicaoNavioTamanho2(Tabuleiro tabuleiro, String orientacao) {

        boolean sobreposicao = false;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho2(); i++) {

            do {
                try {
                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        sobreposicao = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 1);
                        if (sobreposicao == false) {
                            tabuleiro.setElemento(new NavioTamanho2(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 1));
                        }

                    }
                    if ("vertical".equals(orientacao)) {

                        sobreposicao = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 1, coordenada.getY());
                        if (sobreposicao == false) {
                            tabuleiro.setElemento(new NavioTamanho2(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 1));
                        }
                    }

                } catch (BattleshipGameException bgex) {
                    // teste de verificação
                }
            } while (sobreposicao);
        }
    }

    private void distribuirNavioTamanho3(Tabuleiro tabuleiro) throws BattleshipGameException {

        String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
        processaDistribuicaoNavioTamanho3(tabuleiro, orientacao);
    }

    private void processaDistribuicaoNavioTamanho3(Tabuleiro tabuleiro, String orientacao) {

        boolean sobreposicao = false;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho3(); i++) {
            try {
                do {

                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        boolean sobreposicao1 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 1);
                        boolean sobreposicao2 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 2);

                        if ((sobreposicao1 == false) && (sobreposicao2 == false)) {
                            tabuleiro.setElemento(new NavioTamanho3(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 1));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 2));
                            sobreposicao = false;
                        } else {
                            sobreposicao = true;
                        }
                    }
                    if ("vertical".equals(orientacao)) {

                        boolean sobreposicao1 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 1, coordenada.getY());
                        boolean sobreposicao2 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 2, coordenada.getY());
                        if ((sobreposicao1 == false) && (sobreposicao2 == false)) {
                            tabuleiro.setElemento(new NavioTamanho3(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 1, coordenada.getY()));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 2, coordenada.getY()));
                            sobreposicao = false;
                        } else {
                            sobreposicao = true;
                        }
                    }
                } while (sobreposicao);

            } catch (BattleshipGameException bgex) {
                // teste de verificação
            }

        }
    }

    private void distribuirNavioTamanho4(Tabuleiro tabuleiro) throws BattleshipGameException {
        String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
        processaDistribuicaoNavioTamanho4(tabuleiro, orientacao);
    }

    private void processaDistribuicaoNavioTamanho4(Tabuleiro tabuleiro, String orientacao) {

        boolean sobreposicao = false;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho4(); i++) {
            try {
                do {

                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        boolean sobreposicao1 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 1);
                        boolean sobreposicao2 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 2);
                        boolean sobreposicao3 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 3);

                        if ((sobreposicao1 == false) && (sobreposicao2 == false) && (sobreposicao3 == false)) {
                            tabuleiro.setElemento(new NavioTamanho4(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 1));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 2));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 3));
                            sobreposicao = false;
                        } else {
                            sobreposicao = true;
                        }
                    }
                    if ("vertical".equals(orientacao)) {

                        boolean sobreposicao1 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 1, coordenada.getY());
                        boolean sobreposicao2 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 2, coordenada.getY());
                        boolean sobreposicao3 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 3, coordenada.getY());

                        if ((sobreposicao1 == false) && (sobreposicao2 == false) && (sobreposicao3 == false)) {
                            tabuleiro.setElemento(new NavioTamanho4(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 1, coordenada.getY()));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 2, coordenada.getY()));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 3, coordenada.getY()));
                            sobreposicao = false;
                        } else {
                            sobreposicao = true;
                        }
                    }
                } while (sobreposicao);

            } catch (BattleshipGameException bgex) {
                // teste de verificação
            }

        }
    }

    private void distribuirPortaAvioes(Tabuleiro tabuleiro) throws BattleshipGameException {
        String orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(gerador.nextInt(2) + 1);
        processaDistribuicaoPortaAvioes(tabuleiro, orientacao);
    }

    private void processaDistribuicaoPortaAvioes(Tabuleiro tabuleiro, String orientacao) {

        boolean sobreposicao = false;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdPortaAvioes(); i++) {
            try {
                do {

                    Posicao coordenada = new Posicao(gerador.nextInt(tabuleiro.getTamanho()), gerador.nextInt(tabuleiro.getTamanho()));

                    if ("horizontal".equals(orientacao)) {

                        boolean sobreposicao1 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 1);
                        boolean sobreposicao2 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX(), coordenada.getY() + 2);
                        boolean sobreposicao3 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 1, coordenada.getY() + 1);
                        boolean sobreposicao4 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 2, coordenada.getY() + 1);

                        if ((sobreposicao1 == false) && (sobreposicao2 == false) && (sobreposicao3 == false) && (sobreposicao4 == false)) {
                            tabuleiro.setElemento(new NavioTamanho4(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 1));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX(), coordenada.getY() + 2));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() +1, coordenada.getY() + 1));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() +2, coordenada.getY() + 1));
                            sobreposicao = false;
                        } else {
                            sobreposicao = true;
                        }
                    }
                    if ("vertical".equals(orientacao)) {

                        boolean sobreposicao1 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 1, coordenada.getY());
                        boolean sobreposicao2 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 2, coordenada.getY());
                        boolean sobreposicao3 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 1, coordenada.getY()+1);
                        boolean sobreposicao4 = BattleshipHelper.verificaSobreposicao(tabuleiro, tabuleiro.getElemento(coordenada), coordenada.getX() + 1, coordenada.getY()+2);

                        if ((sobreposicao1 == false) && (sobreposicao2 == false) && (sobreposicao3 == false) && (sobreposicao4 == false)) {
                            tabuleiro.setElemento(new NavioTamanho4(tabuleiro.getElemento(coordenada)), coordenada);
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 1, coordenada.getY()));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 2, coordenada.getY()));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 1, coordenada.getY() + 1));
                            tabuleiro.setElemento(tabuleiro.getElemento(coordenada), new Posicao(coordenada.getX() + 1, coordenada.getY() + 2));
                            sobreposicao = false;
                        } else {
                            sobreposicao = true;
                        }
                    }
                } while (sobreposicao);

            } catch (BattleshipGameException bgex) {
                // teste de verificação
            }

        }
    }
}
