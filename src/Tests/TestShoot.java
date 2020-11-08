package Tests;

import com.ua.seawar.Battle;
import com.ua.seawar.Player;

import java.util.Base64;
import java.util.Scanner;

public class TestShoot {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        Battle battle = new Battle(player1, player2);

        player1.setFourDeck(1, 'A', 'v');
        player2.setFourDeck(10, 'A', 'h');

        Scanner key = new Scanner(System.in);
        int num;
        char let;
        System.out.println("Player1 :");

        boolean flag;
        do {
            num = key.nextInt();
            let = key.next().charAt(0);
            flag = battle.shootPlayerOne(num, let);
        } while (flag);

        battle.getField2().showField();
    }
}
