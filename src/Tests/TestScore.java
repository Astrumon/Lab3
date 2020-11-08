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

        while (battle.getScorePlayerTwo() != 4) {
            int nm = new Random().nextInt(10);
            battle.shootPlayerTwo(nm, 'D');
            System.out.println("num = " + nm + " D");
        }

      // battle.shootPlayerOne(5, 'D');

        battle.getField2().showField();
        battle.getField1().showField();
       // battle.getField1().showField();
        System.out.println(battle.getScorePlayerTwo());
        System.out.println(battle.getScorePlayerOne());
    }
}
