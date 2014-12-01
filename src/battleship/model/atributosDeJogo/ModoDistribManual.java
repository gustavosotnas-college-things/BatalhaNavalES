package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipHelper;
import battleship.controller.Posicao;
import battleship.model.elementos.Tabuleiro;
import battleship.model.elementos.embarcacoes.*;
import battleship.view.BattleshipGameUI;
import battleship.view.BattleshipMenuUI;

public class ModoDistribManual implements ModoDeDistribuicao{

    @Override
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro) {
        distribuirSubmarino(tabuleiro);
        mostrarPreviaTabuleiro(tabuleiro);

        distribuirNavioTamanho2(tabuleiro);
        mostrarPreviaTabuleiro(tabuleiro);

        distribuirNavioTamanho3(tabuleiro);
        mostrarPreviaTabuleiro(tabuleiro);

        distribuirNavioTamanho4(tabuleiro);
        mostrarPreviaTabuleiro(tabuleiro);

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
                    BattleshipHelper.sleep(1); //pausa de 1 segundo
                }
            }
        }
    }

    private void distribuirNavioTamanho2(Tabuleiro tabuleiro) {
        
        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho2(); i++)
        {
            finished = false;
            while (!finished) {
            
                try {
                    Posicao coordenada = BattleshipGameUI.menuDistribuicaoLinhaColuna(i, "navio de 2 posições");
                    String orientacao = BattleshipGameUI.menuDistribuicaoOrientacao();

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
                } catch (BattleshipException bex) {
                    System.err.println(bex.getMessage());
                    BattleshipHelper.sleep(1); //pausa de 1 segundo
                }
            }
        }
    }

    private void distribuirNavioTamanho3(Tabuleiro tabuleiro) {
        
        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho3(); i++)
        {
            finished = false;
            while (!finished) {
            
                try {
                    Posicao coordenada = BattleshipGameUI.menuDistribuicaoLinhaColuna(i, "navio de 3 posições");
                    String orientacao = BattleshipGameUI.menuDistribuicaoOrientacao();

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
                } catch (BattleshipException bex) {
                    System.err.println(bex.getMessage());
                    BattleshipHelper.sleep(1); //pausa de 1 segundo
                }
            }
        }
    }

    private void distribuirNavioTamanho4(Tabuleiro tabuleiro) {
        
        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho4(); i++)
        {
            finished = false;
            while (!finished) {
            
                try {
                    Posicao coordenada = BattleshipGameUI.menuDistribuicaoLinhaColuna(i, "navio de 4 posições");
                    String orientacao = BattleshipGameUI.menuDistribuicaoOrientacao();

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
                } catch (BattleshipException bex) {
                    System.err.println(bex.getMessage());
                    BattleshipHelper.sleep(1); //pausa de 1 segundo
                }
            }
        }
    }

    private void distribuirPortaAvioes(Tabuleiro tabuleiro) {
        
        boolean finished;

        for (int i = 0; i < tabuleiro.getQtdEmbarcacoes().getQtdNavioTamanho4(); i++)
        {
            finished = false;
            while (!finished) {
            
                try {
                    Posicao coordenada = BattleshipGameUI.menuDistribuicaoLinhaColuna(i, "porta aviões");
                    String orientacao = BattleshipGameUI.menuDistribuicaoOrientacao();

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
                } catch (BattleshipException bex) {
                    System.err.println(bex.getMessage());
                }
            }
        }
        tabuleiro.getQtdEmbarcacoes().setQtdEmbarcacoes();
    }
    
    private void mostrarPreviaTabuleiro(Tabuleiro tabuleiro) {
        
        BattleshipHelper.clearScreen();

        BattleshipMenuUI.menuHeaderBattleship();
        System.out.println("\nTABULEIRO DO JOGADOR " + tabuleiro.getNumeroJogador() + " A MOSTRA: \n");

        BattleshipGameUI.exibeTabuleiro(tabuleiro);
        BattleshipGameUI.legendaTabuleiro();

        BattleshipHelper.getchar(); //Aperte ENTER para continuar.
    }
}
