package com.ua.seawar;

import com.ua.seawar.count_decks.Counter;
import com.ua.seawar.count_decks.DoubledeckCounter;
import com.ua.seawar.count_decks.FourdeckCounter;
import com.ua.seawar.count_decks.ThreedeckCounter;
import com.ua.seawar.ships.*;

import java.util.ArrayList;
import java.util.List;

public class Player implements ConfigFrame {
    private Field field;
    private String[][] arrayField;
    private int countPlayers = 0;

    private DoubledeckCounter doubledeckCounter;
    private ThreedeckCounter threedeckCounter;
    private FourdeckCounter fourdeckCounter;
    private List<Ship> singleDecks, doubleDecks, threeDecks, fourDecks;

    private int countSingleDeck = 4, countDoubleDeck, countThreeDeck, countFourDeck;

    private int letter = 0;
    private int vOrient = 0, gOrient = 0;

    protected final static String OUT_OF_FRAME = "выход за границы";
    protected final static String PLACE_TAKEN = "место занято";
    private final static String MAX_LIMIT = "достигнут лимит по количеству кораблей";
    private final static char ORIENTATION_VERTICAL = 'v';
    private final  static char ORIENTATION_HORIZONTAL = 'h';

    private String name;

    public Player() {
        countPlayers++;
        name = "Player" + 1;
        field = new Field();
        arrayField = field.getArrayField();

        doubledeckCounter = new DoubledeckCounter();
        threedeckCounter = new ThreedeckCounter();
        fourdeckCounter = new FourdeckCounter();

        countDoubleDeck = doubledeckCounter.getCount();
        countThreeDeck = threedeckCounter.getCount();
        countFourDeck = fourdeckCounter.getCount();

        singleDecks = new ArrayList<Ship>();
        doubleDecks = new ArrayList<Ship>();
        threeDecks = new ArrayList<Ship>();
        fourDecks = new ArrayList<Ship>();

        addShip(countSingleDeck, singleDecks, new SingleDeck());
        addShip(countDoubleDeck, doubleDecks, new DoubleDeck());
        addShip(countThreeDeck, threeDecks, new ThreeDeck());
        addShip(countFourDeck, fourDecks, new FourDeck());
    }

    public Player(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean setSingleDeck(int number, char letter) {
        int iLetter = getI(letter);

        if (isBorder(number, iLetter)) {
            try {
                if (isEmpty(number, iLetter)) {
                    arrayField[number][iLetter] = singleDecks.get(countSingleDeck - 1).create()[0];
                } else {
                    System.out.println(PLACE_TAKEN);
                    return false;
                }
                countSingleDeck--;

                field.setArrayField(arrayField);
                field.showField();
                return true;
            } catch (IndexOutOfBoundsException exc) {
                System.err.println(MAX_LIMIT);
            }
        } else {
            System.out.println(OUT_OF_FRAME);
        }
        return false;
    }

    public boolean setDoubleDeck(int number, char letter, char orientation) {
        this.letter = getI(letter);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 0);

        if (isBorder(number + buffs[0], this.letter + buffs[1])) {
            return locationShip(doubleDecks, doubledeckCounter, number);
        } else {
            System.out.println(OUT_OF_FRAME);
        }

        return false;
    }

    public boolean setThreeDeck(int number, char letter, char orientation) {
        this.letter = getI(letter);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 1);

        if (isBorder(number + buffs[0], this.letter + buffs[1])) {
            return locationShip(threeDecks, threedeckCounter, number);
        } else {
            System.out.println(OUT_OF_FRAME);
        }
        return false;
    }

    public boolean setFourDeck(int number, char letter, char orientation) {
        this.letter = getI(letter);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 2);

        if (isBorder(number + buffs[0], this.letter + buffs[1])) {
           return locationShip(fourDecks, fourdeckCounter, number);
        } else {
            System.out.println(OUT_OF_FRAME);
        }
        return false;
    }

    private void addShip(int countOfDeck, List<Ship> ships, Ship ship) {
        for (int i = 0; i < countOfDeck; i++) {
            ships.add(ship);
        }
    }

    private int getCountDeck(Ship ship) {
        return ship.getCOUNT_DECK();
    }

    private int getVOrientation(char orientation) {
        return  (orientation == ORIENTATION_VERTICAL) ? 1 : 0;
    }

    private int getGOrientation(char orientation) {
        return (orientation == ORIENTATION_HORIZONTAL) ? 1 : 0;
    }

    private boolean locationShip(List<Ship> ships, Counter countNDeck, int number) {
        try {
            int count = getCountDeck(ships.get(0));
            String[] partsOfShip = ships.get(countNDeck.getCount() - 1).create();

            int firstNumber = number;
            int firstLetter = letter;
            boolean flag = true;
            for (int j = 0; j < partsOfShip.length; j++ ) {
                if (!isEmpty(number, letter)) {
                    flag = false;
                    break;
                }
                number += vOrient;
                letter += gOrient;
            }

            number = firstNumber;
            letter = firstLetter;
            for (int i = 0; i < count; i++) {
                if (flag) {
                    arrayField[number][letter] = partsOfShip[i];
                    number += vOrient;
                    letter += gOrient;
                } else {
                    System.out.println(PLACE_TAKEN);
                    return false;
                }
            }

            countNDeck.decrease();

            field.setArrayField(arrayField);
            field.showField();
            
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(MAX_LIMIT);
            System.out.println(exc);
        }
        return true;
    }

    private int[] range(int buffV, int buffG, char orientation, int limit) {
        if (orientation == ORIENTATION_VERTICAL) {
            buffV += limit;
            buffG = 0;
        } else if (orientation == ORIENTATION_HORIZONTAL) {
            buffG += limit;
            buffV = 0;
        }
        return new int[]{buffV, buffG};
    }

    private boolean isEmpty(int number, int letter) {
        return arrayField[number][letter].equals(Field.VALUE_DEFAULT);
    }

    public Field getField() {
        return field;
    }
}
