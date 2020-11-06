package com.ua.seawar;

import java.util.ArrayList;
import java.util.List;

public class Player implements ConfigFrame {
    private Field field;
    private String[][] arrayField;
    private List<Ship> singleDecks, doubleDecks, threeDecks, fourDecks;
    private int countSingleDeck = 4, countDoubleDeck = 3, countThreeDeck = 2, countFourDeck = 1;
    private int iLet = 0;
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

    public void setSingleDeck(int x, char y) {
        int iLet = getI(y);

        if (isBorder(x, iLet)) {
            try {
                if (isEmpty(x, iLet)) {
                    arrayField[x][iLet] = singleDecks.get(countSingleDeck - 1).create()[0];
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

    public void setDoubleDeck(int x, char y, char orientation) {
        iLet = getI(y);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 0);

        if (isBorder(x + buffs[0], iLet + buffs[1])) {
            countDoubleDeck = locationShip(doubleDecks, countDoubleDeck, x);
        } else {
            System.out.println(OUT_OF_FRAME);
        }
    }

    public void setThreeDeck(int x, char y, char orientation) {
        iLet = getI(y);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 1);

        if (isBorder(x + buffs[0], iLet + buffs[1])) {
            countThreeDeck = locationShip(threeDecks, countThreeDeck, x);
        } else {
            System.out.println(OUT_OF_FRAME);
        }
    }

    public void setFourDeck(int x, char y, char orientation) {
        iLet = getI(y);

        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);

        int[] buffs = range(vOrient, gOrient, orientation, 2);

        if (isBorder(x + buffs[0], iLet + buffs[1])) {
            countFourDeck = locationShip(fourDecks, countFourDeck, x);
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

    private int locationShip(List<Ship> ships, int countNDeck, int x) {
        try {
            int count = getCountDeck(ships.get(0));
            String[] partsOfShip = ships.get(countNDeck - 1).create();

            int firstx = x;
            int firstIlet = iLet;
            for (int i = 0; i < count; i++) {
                //TODO изменить алгоритм для горизонтального положения(работает некорректно)
                if (isEmpty(x, iLet)) {
                    arrayField[x][iLet] = partsOfShip[i];
                    x += vOrient;
                    iLet += gOrient;
                } else {
                    if (i == count-1) {
                        arrayField[x-vOrient][iLet-gOrient] = Field.VALUE_DEFAULT;
                        arrayField[firstx][firstIlet] = Field.VALUE_DEFAULT;
                    }
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

    private boolean isEmpty(int x, int y) {
        return arrayField[x][y].equals(Field.VALUE_DEFAULT);
    }

    public Field getField() {
        return field;
    }
}
