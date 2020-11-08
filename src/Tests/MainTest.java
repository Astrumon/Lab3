package Tests;

import com.ua.seawar.Battle;
import com.ua.seawar.Field;
import com.ua.seawar.Player;
import com.ua.seawar.count_decks.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainTest {
    static Player player1 = new Player("PlayerOne");
    static Player player2 = new Player("PlayerTwo");

    static Battle battle = new Battle(player1, player2);

    static int number = 0;
    static char letter = 0, orientation;

   // static Scanner keyInput = new Scanner(System.in);
   static Random random = new Random();

    static SingledeckCounter singledeckCounter = new SingledeckCounter();
    static DoubledeckCounter doubledeckCounter = new DoubledeckCounter();
    static ThreedeckCounter threedeckCounter = new ThreedeckCounter();
    static FourdeckCounter fourdeckCounter = new FourdeckCounter();

    static boolean flagSingle, flagDouble, flagThree, flagFour;

    private static final String TEXT_INFO_SINGLE = " для однопалубного корабля в виде числа и символа (1 А)";
    private static final String TEXT_INFO_DOUBLE = " для двухпалубного корабля в виде числа и символа и расположения h/v (1 А h)";
    private static final String TEXT_INFO_THREE = " для трёхпалубного корабля в виде числа и символа и расположения h/v (1 А h)";
    private static final String TEXT_INFO_FOUR = " для четырёхпалубного корабля в виде числа и символа и расположения h/v (1 А h)";

    private static boolean exitStatus = false;

    public static void main(String[] args) throws IOException {

        System.out.println("Добро пожаловать в игру!");
        setShipPlayerOne();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        reset();
        setShipPlayerTwo();

        Field field = new Field();
        field.hideBattleField();
        do {
            if (battle.getScorePlayerOne() == 20 || battle.getScorePlayerTwo() == 20) {
                break;
            }
            System.out.println("Первый игрок введите координаты для выстрела - число, символ: ");
            field.showField();
            battle.shootPlayerOne(random.nextInt(10), getLetter(random.nextInt(10)));
            System.out.println("score1 = " + battle.getScorePlayerOne());
            System.out.println("Второй игрок введите координаты для выстрела - число, символ: ");
            field.showField();
            battle.shootPlayerTwo(random.nextInt(10), getLetter(random.nextInt(10)));
            System.out.println("score2 = " + battle.getScorePlayerTwo());
        } while ((battle.getScorePlayerOne() != 20) || (battle.getScorePlayerTwo() != 20));


        if (battle.getScorePlayerOne() == 20) {
            System.out.println(" Первый игрок победил!");
            battle.getField2().showField();
        } else if (battle.getScorePlayerTwo() == 20){
            System.out.println(" Второй игрок победил!");
            battle.getField1().showField();
        }

        System.out.println("Общий результат:");
        //TODO запихнуть боевые поля в файл в строку и взять с файла и отобразить в консоле

    }

    public static void setShipPlayerOne() {
        for (;;) {
            if (exitStatus || singledeckCounter.getCountType() == 4) break;
            exitStatus = set(TEXT_INFO_SINGLE, "single", player1, singledeckCounter).equals("q");
        }

        for (;;) {
            if (exitStatus || doubledeckCounter.getCountType() == 3) break;
            exitStatus = set(TEXT_INFO_DOUBLE, "double", player1, doubledeckCounter).equals("q");
        }

        for (;;) {
            if (exitStatus || threedeckCounter.getCountType() == 2) break;
            exitStatus = set(TEXT_INFO_THREE, "three", player1, threedeckCounter).equals("q");
        }
        for (;;) {
            if (exitStatus || fourdeckCounter.getCountType() == 1) break;
            exitStatus = set(TEXT_INFO_FOUR, "four", player1, fourdeckCounter).equals("q");
        }

    }

    public static void setShipPlayerTwo() {
        for (;;) {
            if (exitStatus || singledeckCounter.getCountType() == 4) break;
            exitStatus = set(TEXT_INFO_SINGLE, "single", player2, singledeckCounter).equals("q");
        }

        for (;;) {
            if (exitStatus || doubledeckCounter.getCountType() == 3) break;
            exitStatus = set(TEXT_INFO_DOUBLE, "double", player2, doubledeckCounter).equals("q");
        }

        for (;;) {
            if (exitStatus || threedeckCounter.getCountType() == 2) break;
            exitStatus = set(TEXT_INFO_THREE, "three", player2, threedeckCounter).equals("q");
        }
        for (;;) {
            if (exitStatus || fourdeckCounter.getCountType() == 1) break;
            exitStatus = set(TEXT_INFO_FOUR, "four", player2, fourdeckCounter).equals("q");
        }

    }

    public static String set(String text, String type, Player player, Counter counter) {
        System.out.println(player.getName() + " ваш ход. Введите координаты для" + text);
        number = random.nextInt(10);
        letter = getLetter(random.nextInt(10));
        orientation = type.equals("single") ? ' ' : 'v';
       // System.out.println("Вы подтверждаете свой выбор? (\'y\' - yes, \'n\' - no)");
       // String result = new Scanner(System.in).nextLine();

            switch (type) {
                case "single" : flagSingle = player.setSingleDeck(number, letter); if (flagSingle) counter.add();
                break;
                case "double" : flagDouble = player.setDoubleDeck(number, letter, orientation); if (flagDouble) counter.add();
                break;
                case "three" : flagThree = player.setThreeDeck(number, letter, orientation); if (flagThree) counter.add();
                break;
                case "four" : flagFour = player.setFourDeck(number, letter, orientation); if (flagFour) counter.add();
                break;
            }

        return "";
    }

    public static void reset() {
        exitStatus = false;
        singledeckCounter.setCountType(0);
        doubledeckCounter.setCountType(0);
        threedeckCounter.setCountType(0);
        fourdeckCounter.setCountType(0);
        flagSingle = false;
        flagDouble = false;
        flagThree = false;
        flagFour = false;
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


