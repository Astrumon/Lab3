package Tests;

import com.ua.seawar.Battle;
import com.ua.seawar.Player;

import java.util.Random;

public class TestScore {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        Battle battle = new Battle(player1, player2);

        player1.setFourDeck(3,'D', 'v');
        player2.setFourDeck(3,'D', 'h');

        do {

        } while (  battle.shootPlayerOne(1 ,'D'));


      // battle.shootPlayerOne(5, 'D');

        battle.getField2().showField();
        battle.getField1().showField();
       // battle.getField1().showField();
        System.out.println(battle.getScorePlayerTwo());
        System.out.println(battle.getScorePlayerOne());
    }
}
