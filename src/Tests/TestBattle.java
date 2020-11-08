package Tests;

import com.ua.seawar.Battle;
import com.ua.seawar.Player;

public class TestBattle {


    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Battle battle = new Battle(player1, player2);


        player1.setSingleDeck(1, 'A');
        player2.setSingleDeck(1, 'A');

        battle.shootPlayerOne(1, 'A');

        player1.setFourDeck(1, 'B', 'v');
        player2.setFourDeck(1, 'B', 'v');


        battle.shootPlayerOne(1, 'A');
        battle.shootPlayerOne(1, 'B');
        battle.shootPlayerOne(2, 'B');
        battle.shootPlayerOne(3, 'B');
        battle.getField1().showField();
        battle.getField2().showField();
        System.out.println("player1: " + battle.getScorePlayerOne());


       // player1.setFourDeck(1, 'B', 'v');
       // player2.setFourDeck(1, 'B', 'v');

       // player1.setThreeDeck(1, 'D','v');
       // player1.setThreeDeck(1, 'E','h');
       // player2.setThreeDeck(1, 'D','v');
       // player2.setThreeDeck(1, 'F','g');
        //player2.setThreeDeck(6, 'H', 'g');
        /*Battle battle = new Battle(player1, player2);

        battle.shootPlayerTwo(1, 'C');
        battle.shootPlayerTwo(1, 'D');
        battle.shootPlayerTwo(2, 'C');
        battle.shootPlayerTwo(3, 'C');
        battle.shootPlayerTwo(4, 'C');
        battle.shootPlayerTwo(5, 'C');
        System.out.println("result " + battle.getScorePlayerTwo());
        battle.getField1().showField();

      *//*  battle.shootPlayerOne(1, 'A');
        battle.shootPlayerOne(1, 'F');
        battle.shootPlayerOne(1, 'G');
        battle.shootPlayerOne(1, 'H');
        System.out.println("result of player one" + battle.getScorePlayerOne());*/

    }
}
