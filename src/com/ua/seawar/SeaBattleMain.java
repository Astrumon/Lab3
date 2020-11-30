package com.ua.seawar;

import com.ua.seawar.count_decks.*;

import java.io.IOException;
import java.util.Scanner;

public class SeaBattleMain {
    private static final String TEXT_INFO_SINGLE = " для однопалубного корабля в виде числа 1..10 и символа A..J (1 А)";
    private static final String TEXT_INFO_DOUBLE = " для двухпалубного корабля в виде числа 1..10 и символа A..J, и расположения h/v (1 А h)";
    private static final String TEXT_INFO_THREE = " для трёхпалубного корабля в виде числа 1..10 и символа A..J, и расположения h/v (1 А h)";
    private static final String TEXT_INFO_FOUR = " для четырёхпалубного корабля в виде числа 1..10 и символа A..J, и расположения h/v (1 А h)";
    static Player player1 = new Player("PlayerOne");
    static Player player2 = new Player("PlayerTwo");
    static Battle battle = new Battle(player1, player2);
    static int number = 0;
    static char letter = 0, orientation;
    static Scanner keyInput1 = new Scanner(System.in);
    static Scanner keyInput2 = new Scanner(System.in);
    static SingledeckCounter singledeckCounter = new SingledeckCounter();
    static DoubledeckCounter doubledeckCounter = new DoubledeckCounter();
    static ThreedeckCounter threedeckCounter = new ThreedeckCounter();
    static FourdeckCounter fourdeckCounter = new FourdeckCounter();
    static boolean flagSingle, flagDouble, flagThree, flagFour;
    private static SaveFile saveFile;
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

        shooting();

        if (battle.getScorePlayerOne() == 20) {
            System.out.println(" Первый игрок победил!");
            battle.getField2().showField();
        } else if (battle.getScorePlayerTwo() == 20) {
            System.out.println(" Второй игрок победил!");
            battle.getField1().showField();
        }

        System.out.println("Общий результат:");
        showResult(battle.getField1().getArrayField(), battle.getField2().getArrayField());

        Scanner keyInput = new Scanner(System.in);
        Scanner keyInput1 = new Scanner(System.in);
        System.out.println("Сохранить данные результаты?(y/n)");
        String save = keyInput.nextLine();
        if (save.equals("y")) {
            System.out.println("Желаете ввести указанный путь? (y/n)");
            String keyPath = keyInput1.nextLine();
            if (keyPath.equals("y")) {
                System.out.println("Введите свой путь: ");
                saveFile = new SaveFile(keyInput1.nextLine(), battle.getField1().getArrayField(), battle.getField2().getArrayField());
            } else {
                saveFile = new SaveFile(battle.getField1().getArrayField(), battle.getField2().getArrayField());
            }
            if (saveFile.saveData()) {
                System.out.println("Результаты сохранены на: " + saveFile.getPathname());
            }
        } else if (save.equals("n")) {
            System.out.println("Выход из игры");
        }
    }

    public static void setShipPlayerOne() {
       for (; ; ) {
            if (exitStatus || singledeckCounter.getCountType() == 4) break;
            exitStatus = set(TEXT_INFO_SINGLE, "single", player1, singledeckCounter).equals("q");
        }

        for (; ; ) {
            if (exitStatus || doubledeckCounter.getCountType() == 3) break;
            exitStatus = set(TEXT_INFO_DOUBLE, "double", player1, doubledeckCounter).equals("q");
        }

        for (; ; ) {
            if (exitStatus || threedeckCounter.getCountType() == 2) break;
            exitStatus = set(TEXT_INFO_THREE, "three", player1, threedeckCounter).equals("q");
        }

        for (; ; ) {
            if (exitStatus || fourdeckCounter.getCountType() == 1) break;
            exitStatus = set(TEXT_INFO_FOUR, "four", player1, fourdeckCounter).equals("q");
        }

    }

    public static void setShipPlayerTwo() {
        for (; ; ) {
            if (exitStatus || singledeckCounter.getCountType() == 4) break;
            exitStatus = set(TEXT_INFO_SINGLE, "single", player2, singledeckCounter).equals("q");
        }

        for (; ; ) {
            if (exitStatus || doubledeckCounter.getCountType() == 3) break;
            exitStatus = set(TEXT_INFO_DOUBLE, "double", player2, doubledeckCounter).equals("q");
        }

        for (; ; ) {
            if (exitStatus || threedeckCounter.getCountType() == 2) break;
            exitStatus = set(TEXT_INFO_THREE, "three", player2, threedeckCounter).equals("q");
        }
        for (; ; ) {
            if (exitStatus || fourdeckCounter.getCountType() == 1) break;
            exitStatus = set(TEXT_INFO_FOUR, "four", player2, fourdeckCounter).equals("q");
        }
    }

    public static String set(String text, String type, Player player, Counter counter) {
        boolean flag;
        System.out.println(player.getName() + " ваш ход. Введите координаты для" + text);
        do {
            while (!keyInput1.hasNextInt()) {
                System.out.println("Вы ввели некорректное значение. Нужно ввести число от 1 до 10");
                keyInput1.next();
            }
            number = keyInput1.nextInt();
            flag = false;
        } while (flag);

        letter = keyInput2.next().charAt(0);
        orientation = type.equals("single") ? ' ' : keyInput1.next().charAt(0);
        System.out.println("Вы подтверждаете свой выбор? (\'y\' - yes, \'n\' - no)");
        String result = new Scanner(System.in).nextLine();

        if (result.equals("y")) {
            switch (type) {
                case "single":
                    flagSingle = player.setSingleDeck(number, letter);
                    if (flagSingle) counter.add();
                    break;
                case "double":
                    flagDouble = player.setDoubleDeck(number, letter, orientation);
                    if (flagDouble) counter.add();
                    break;
                case "three":
                    flagThree = player.setThreeDeck(number, letter, orientation);
                    if (flagThree) counter.add();
                    break;
                case "four":
                    flagFour = player.setFourDeck(number, letter, orientation);
                    if (flagFour) counter.add();
                    break;
            }

        } else if (result.equals("n")) {
            System.out.println("Желаете выйти? (\'y\', \'n\')");
            String exit = new Scanner(System.in).nextLine();
            if (exit.equals("y")) {
                return "q";
            }
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

    public static void showResult(String[][] array1, String[][] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("@1");
                }
                System.out.print(array1[i][j] + "\t");
            }
            for (int j = 0; j < array2[0].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("@2");
                }
                System.out.print(array2[i][j] + "\t");


            }
            System.out.println();
        }
    }

    public static void shooting() {
        boolean flag;
        do {
            if (battle.getScorePlayerOne() == 20 || battle.getScorePlayerTwo() == 20) {
                break;
            }
            do {
                System.out.println("Первый игрок введите координаты для выстрела - число, символ: ");

                while (!keyInput1.hasNextInt()) {
                    System.out.println("Вы ввели некорректное значение. Нужно ввести число от 1 до 10");
                    keyInput1.next();
                }
                flag = battle.shootPlayerOne(keyInput1.nextInt(), keyInput2.next().charAt(0));
                System.out.println("score1 = " + battle.getScorePlayerOne());
            } while (flag);

            do {
                System.out.println("Второй игрок введите координаты для выстрела - число, символ: ");
                while (!keyInput1.hasNextInt()) {
                    System.out.println("Вы ввели некорректное значение. Нужно ввести число от 1 до 10");
                    keyInput1.next();
                }
                flag = battle.shootPlayerTwo(keyInput1.nextInt(), keyInput2.next().charAt(0));
                System.out.println("score2 = " + battle.getScorePlayerTwo());
            } while (flag);
        } while ((battle.getScorePlayerOne() != 20) || (battle.getScorePlayerTwo() != 20));
    }

}


