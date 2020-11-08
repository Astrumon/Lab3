package Tests;

import com.ua.seawar.Battle;
import com.ua.seawar.Player;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class TestApp {
    private final int FINAL_SCORE = 20;

    public static void main(String[] args) {
        Scanner keyInput = new Scanner(System.in);
        boolean flag;
        Player player1 = new Player();
        Player player2 = new Player();

        Battle battle = new Battle(player1, player2);

        Random random = new Random();
        int num = random.nextInt(10);
        char sym = getLetter(random.nextInt());


        System.out.println("Добро пожаловать в игру!");
        System.out.println("Первый игрок расставьте свой флот: ");
        player1.getField().showField();

        System.out.println("Введите координаты для однопалубного - число,символ: ");
        player1.setSingleDeck(5, 'B');
        player1.setSingleDeck(3, 'G');
        player1.setSingleDeck(3, 'I');
        player1.setSingleDeck(7, 'J');

        System.out.println("Введите координаты для двухпалубного - число,символ,расположение(v, h): ");
        player1.setDoubleDeck(7, 'A', 'v');
        player1.setDoubleDeck(1, 'I', 'h');
        player1.setDoubleDeck(3, 'B', 'v');

        System.out.println("Введите координаты для трёхпалубного - число,символ,расположение(v, h): ");
        player1.setThreeDeck(2, 'H', 'h');
        player1.setThreeDeck(5, 'E', 'h');

        System.out.println("Введите координаты для четырехпалубного - число,символ,расположение(v, h): ");
        player1.setFourDeck(1, 'A', 'h');

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Второй игрок расставьте свой флот: ");
        player2.getField().showField();

        System.out.println("Введите координаты для однопалубного - число,символ: ");
        player2.setSingleDeck(1, 'A');
        player2.setSingleDeck(3, 'A');
        player2.setSingleDeck(5, 'A');
        player2.setSingleDeck(7, 'A');

        System.out.println("Введите координаты для двухпалубного - число,символ,расположение(v, h): ");
        player2.setDoubleDeck(1, 'C', 'v');
        player2.setDoubleDeck(4, 'C', 'h');
        player2.setDoubleDeck(6, 'C', 'v');

        System.out.println("Введите координаты для трёхпалубного - число,символ,расположение(v, h): ");
        player2.setThreeDeck(1, 'E', 'h');
        player2.setThreeDeck(5, 'E', 'h');

        System.out.println("Введите координаты для четырехпалубного - число,символ,расположение(v, h): ");
        player2.setFourDeck(1, 'J', 'v');

        System.out.println("------------------------------------");
        System.out.println("Поле первого игрока");
        battle.getField1().showField();

        System.out.println("------------------------------------");
        System.out.println("Поле второго игрока");
        battle.getField2().showField();

        do {
            if (battle.getScorePlayerOne() == 20 || battle.getScorePlayerTwo() == 20) {
                break;
            }
           /* boolean flag = true;
            do {
                if (flag = false) break;
                num = key.nextInt();
                let = key.next().charAt(0);
                flag = battle.shootPlayerOne(num, let);
            } while (flag); */

            do {
                System.out.println("Первый игрок введите координаты для выстрела - число, символ: ");
                num = random.nextInt(10);
                sym = getLetter(random.nextInt(10));
                flag = battle.shootPlayerOne(num, sym);
                System.out.println(flag);
                System.out.println("number: " + num + "letter " + sym);
                System.out.println("score1 = " + battle.getScorePlayerOne());
            } while (flag);
            //flag = false;
            do {
                System.out.println("Второй игрок введите координаты для выстрела - число, символ: ");
                flag = battle.shootPlayerTwo(num, sym);
                System.out.println("score2 = " + battle.getScorePlayerTwo());
            } while (flag);

        } while ((battle.getScorePlayerOne() != 20) || (battle.getScorePlayerTwo() != 20));


        if (battle.getScorePlayerOne() == 20) {
            System.out.println(" Первый игрок победил!");
            battle.getField2().showField();
           // battle.getField1().showField();
        } else if (battle.getScorePlayerTwo() == 20){
            System.out.println(" Второй игрок победил!");
            battle.getField1().showField();
           // battle.getField2().showField();
        }

        System.out.println("BOTH: ----------------------");
        battle.getField1().showField();
        battle.getField2().showField();
    }

    public static char getLetter(int number) {
        char ch = 'O';
        switch (number) {
            case 0 : ch = 'O';
                break;
            case 1 : ch ='A';
                break;
            case 2 : ch ='B';
                break;
            case 3 : ch ='C';
                break;
            case 4 : ch ='D';
                break;
            case 5 : ch ='E';
                break;
            case 6 : ch ='F';
                break;
            case 7 : ch ='G';
                break;
            case 8 : ch ='H';
                break;
            case 9 : ch ='I';
                break;
            case 10 : ch ='J';
                break;
        }
        return ch;
    }

}
