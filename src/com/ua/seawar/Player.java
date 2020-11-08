package com.ua.seawar;

import java.util.ArrayList;
import java.util.List;

public class Player implements ConfigFrame {
    private Field field;
    private String[][] arrayField;
    private List<Ship> singleDecks, doubleDecks, threeDecks, fourDecks;
    private int countSingleDeck = 4, countDoubleDeck = 3, countThreeDeck = 2, countFourDeck = 1;
    private int letter = 0;
    private int vOrient = 0, gOrient = 0;

    protected final static String OUT_OF_FRAME = "выход за границы";
    protected final static String PLACE_TAKEN = "место занято";
    private final static String MAX_LIMIT = "достигнут лимит по количеству кораблей";
    private final static char ORIENTATION_VERTICAL = 'v';
    private final  static char ORIENTATION_HORIZONTAL = 'h';

    public Player() {
        field = new Field();
        arrayField = field.getArrayField();

        singleDecks = new ArrayList<Ship>();
        doubleDecks = new ArrayList<Ship>();
        threeDecks = new ArrayList<Ship>();
        fourDecks = new ArrayList<Ship>();

        addShip(countSingleDeck, singleDecks, new SingleDeck());
        addShip(countDoubleDeck, doubleDecks, new DoubleDeck());
        addShip(countThreeDeck, threeDecks, new ThreeDeck());
        addShip(countFourDeck, fourDecks, new FourDeck());
    }

    public void setSingleDeck(int number, char letter) {
        int iLetter = getI(letter);

        if (isBorder(number, iLetter)) {
            try {
                if (isEmpty(number, iLetter)) {
                    arrayField[number][iLetter] = singleDecks.get(countSingleDeck - 1).create()[0];
                } else {
                    System.out.println(PLACE_TAKEN);
                }
                countSingleDeck--;

                field.setArrayField(arrayField);
                field.showField();
            } catch (IndexOutOfBoundsException exc) {
                System.err.println(MAX_LIMIT);
            }
        } else {
            System.out.println(OUT_OF_FRAME);
        }
    }

    public void setDoubleDeck(int number, char letter, char orientation) {
        this.letter = getI(letter);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 0);

        if (isBorder(number + buffs[0], this.letter + buffs[1])) {
            countDoubleDeck = locationShip(doubleDecks, countDoubleDeck, number);
        } else {
            System.out.println(OUT_OF_FRAME);
        }
    }

    public void setThreeDeck(int number, char letter, char orientation) {
        this.letter = getI(letter);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 1);

        if (isBorder(number + buffs[0], this.letter + buffs[1])) {
            countThreeDeck = locationShip(threeDecks, countThreeDeck, number);
        } else {
            System.out.println(OUT_OF_FRAME);
        }
    }

    public void setFourDeck(int number, char letter, char orientation) {
        this.letter = getI(letter);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 2);

        if (isBorder(number + buffs[0], this.letter + buffs[1])) {
            countFourDeck = locationShip(fourDecks, countFourDeck, number);
        } else {
            System.out.println(OUT_OF_FRAME);
        }
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
        int or = 0;
        if (orientation == ORIENTATION_VERTICAL) {
            or = 1;
        }
        return or;
    }

    private int getGOrientation(char orientation) {
        int or = 0;
        if (orientation == ORIENTATION_HORIZONTAL) {
            or = 1;
        }
        return or;
    }

    private int locationShip(List<Ship> ships, int countNDeck, int number) {
        try {
            int count = getCountDeck(ships.get(0));
            String[] partsOfShip = ships.get(countNDeck - 1).create();

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
                    break;
                }
            }

            countNDeck--;

            field.setArrayField(arrayField);
            field.showField();
            
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(MAX_LIMIT);
        }
        return countNDeck;
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
