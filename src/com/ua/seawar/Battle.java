package com.ua.seawar;
import com.ua.seawar.Player;
public class Battle implements ConfigFrame{
    private Player player1, player2;
    private Field field1, field2;
    private String[][] arrayField1, arrayField2;
    private final String MISS_VALUE = "x";
    private final String HIT_VALUE = "*";
    private ScorePlayerOne scorePlayerOne;
    private ScorePlayerTwo scorePlayerTwo;
    private int i = 0;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;


    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        scorePlayerTwo = new ScorePlayerTwo();
        scorePlayerOne = new ScorePlayerOne();

        field1 = player1.getField();
        field2 = player2.getField();

        arrayField1 = field1.getArrayField();
        arrayField2 = field2.getArrayField();
    }

    public void shootPlayerOne(int x, char y) {
        int iLet = getI(y);
        if (isBorder(x, iLet)) {
            arrayField2[x][iLet] = shipChecker(arrayField2[x][iLet], scorePlayerOne);
        } else {
            System.out.println(Player.OUT_OF_FRAME);
        }
    }

    public void shootPlayerTwo(int x, char y) {
        int iLet = getI(y);

        if (isBorder(x, iLet)) {
            arrayField1[x][iLet] = shipChecker(arrayField1[x][iLet], scorePlayerTwo);
        } else {
            System.out.println(Player.OUT_OF_FRAME);
        }
    }

    public String shipChecker(String cordShip, Score score) {

        if (cordShip.equals(Field.VALUE_DEFAULT)) {
            cordShip = MISS_VALUE;
        } else {
            cordShip = HIT_VALUE;
           score.setScore(i++);
        }
        return cordShip;
    }

    public Field getField1() {
        return field1;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public int getScorePlayerOne() {
        return scorePlayerOne.getScore();
    }

    public int getScorePlayerTwo() {
        return scorePlayerTwo.getScore();
    }



}
