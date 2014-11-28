/*
 * Classe que contém o log do jogo em HashMap.
 * É usada só para manter o controle das mensagens durante o jogo, 
 * para não imprimir a mensagem de que fez alguma coisa no Tabuleiro mais de uma vez (explodiu, errou o alvo, etc.).
 */
package battleship.controller;

import java.util.HashMap;
import java.util.Map;

public class BattleshipLogger {
    private static Map<Posicao, String> BattleshipGameLog = new HashMap<>();
    
    public static boolean consultaPosicaoLog(Posicao pos) {
        return BattleshipGameLog.containsKey(pos);
    }
    
    public static void adicionaLog(Posicao pos, String textoDoLog) {
        BattleshipGameLog.putIfAbsent(pos, textoDoLog);
    }
}
