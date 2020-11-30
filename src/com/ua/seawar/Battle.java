package com.ua.seawar;
import com.ua.seawar.score_players.Score;
import com.ua.seawar.score_players.ScorePlayerOne;
import com.ua.seawar.score_players.ScorePlayerTwo;

public class Battle implements ConfigFrame{

    private Player player1, player2;
    private Field field1, field2;
    private String[][] arrayField1, arrayField2;
    private final String MISS_VALUE = "x";
    private final String HIT_VALUE = "*";
    private ScorePlayerOne scorePlayerOne;
    private ScorePlayerTwo scorePlayerTwo;
    private boolean flag =false;


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

    public boolean shootPlayerOne(int number, char letter) {
        int iLetter = getI(letter);
        if (isBorder(number, iLetter)) {
            arrayField2[number][iLetter] = shipChecker(arrayField2[number][iLetter], scorePlayerOne);
            return flag;
        } else {
            System.out.println(Player.OUT_OF_FRAME);
        }

        return false;
    }

    public boolean shootPlayerTwo(int number, char letter) {
        int iLetter = getI(letter);

        if (isBorder(number, iLetter)) {
            arrayField1[number][iLetter] = shipChecker(arrayField1[number][iLetter], scorePlayerTwo);
            return flag;
        } else {
            System.out.println(Player.OUT_OF_FRAME);
        }
        return false;
    }

    public String shipChecker(String cordShip, Score score) {

        if (cordShip.equals(Field.VALUE_DEFAULT)) {
            cordShip = MISS_VALUE;
            flag = false;
        } else if (cordShip.equals(HIT_VALUE) ) {
            cordShip = HIT_VALUE;
            flag = false;
        } else if (cordShip.equals(MISS_VALUE)) {
            cordShip = MISS_VALUE;
            flag = false;
        }
        else if (cordShip.equals("s") || cordShip.equals("d") || cordShip.equals("t") || cordShip.equals("f")){
            cordShip = HIT_VALUE;
           score.addPoint();
           flag = true;
        }
        return cordShip;
    }

    public Field getField1() {
        return field1;
    }

    public int getScorePlayerOne() {
        return scorePlayerOne.getScore();
    }

    public int getScorePlayerTwo() {
        return scorePlayerTwo.getScore();
    }

    public Field getField2() {
        return field2;
    }
}
