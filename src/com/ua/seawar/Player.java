package com.ua.seawar;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Field field;
    private String[][] arrayField;
    private List<Ship> singleDecks, doubleDecks, threeDecks, fourDecks;
    private int countSingleDeck = 4, countDoubleDeck = 3, countThreeDeck = 2, countFourDeck = 1;
    private int iLet = 0;
    private int vOrient = 0, gOrient = 0;
    private int[] checkArray;

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
          /*  for (int i = 0; i < arrayField.length; i++) {
                for (int j = 0; j < arrayField[i].length; j++) {

                }
            } */

        if (isBorder(x, iLet)) {
            try {
                arrayField[x][iLet] = singleDecks.get(countSingleDeck - 1).create()[0];
                countSingleDeck--;
                field.setArrayField(arrayField);
                field.showField();
            } catch (IndexOutOfBoundsException exc) {
                System.err.println("max limit of this type ship");
            }
        } else {
            System.out.println("выход за границы");
        }
    }

    public void setDoubleDeck(int x, char y, char orientation) {
        iLet = getI(y);
        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);
        int[] buffs = bufferBorder(vOrient, gOrient, orientation, 0);
        if (isBorder(x+buffs[0], iLet+buffs[1])) {
            countDoubleDeck = locationShip(doubleDecks, countDoubleDeck, x);
        } else {
            System.out.println("выход за границы");
        }
    }

    public void setThreeDeck(int x, char y, char orientation) {
        iLet = getI(y);
        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);
        int[] buffs = bufferBorder(vOrient, gOrient, orientation, 1);
        if (isBorder(x+buffs[0], iLet+buffs[1])) {
            countThreeDeck = locationShip(threeDecks, countThreeDeck, x);
        } else {
            System.out.println("выход за границы");
        }
    }


    public void setFourDeck(int x, char y, char orientation) {
        iLet = getI(y);
        vOrient = getVOrientation(orientation);
        gOrient = getGOrientation(orientation);
        int[] buffs = bufferBorder(vOrient, gOrient, orientation, 2);
        if (isBorder(x+buffs[0], iLet+buffs[1])) {
            countFourDeck = locationShip(fourDecks, countFourDeck, x);
        } else {
            System.out.println("выход за границы");
        }
    }


    private void addShip(int countOfDeck, List<Ship> ships, Ship ship) {
        for (int i = 0; i < countOfDeck; i++) {
            ships.add(ship);
        }
    }

    public void showCount() {
        System.out.println(countSingleDeck);
    }

    private int getCountDeck(Ship ship) {
        return ship.getCOUNT_DECK();
    }

    private int getI(char y) {
        int iLet = 0;
        switch (y) {
            case 'A':
                iLet = 1;
                break;
            case 'B':
                iLet = 2;
                break;
            case 'C':
                iLet = 3;
                break;
            case 'D':
                iLet = 4;
                break;
            case 'E':
                iLet = 5;
                break;
            case 'F':
                iLet = 6;
                break;
            case 'G':
                iLet = 7;
                break;
            case 'H':
                iLet = 8;
                break;
            case 'I':
                iLet = 9;
                break;
            case 'J':
                iLet = 10;
                break;
        }
        return iLet;
    }

    private int getVOrientation(char orientation) {
        int or = 0;
        if (orientation == 'v') {
            or = 1;
        }
        return or;
    }

    private int getGOrientation(char orientation) {
        int or = 0;
        if (orientation == 'g') {
            or = 1;
        }
        return or;
    }

    private int locationShip(List<Ship> ships, int countNDeck, int x) {
        try {
            int count = getCountDeck(ships.get(0));
            String[] partsOfShip = ships.get(countNDeck - 1).create();
            for (int i = 0; i < count; i++) {
                arrayField[x][iLet] = partsOfShip[i];
                x += vOrient;
                iLet += gOrient;
            }
             countNDeck--;
            field.setArrayField(arrayField);
            field.showField();
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("max limit for this type ship ");
        }
        return countNDeck;
    }

    private boolean isBorder(int x, int y) {
        return (x > 0 && y > 0) && (x < 11 && y < 11);
    }

    private int[] bufferBorder(int buffV, int buffG, char orientation, int limit) {
        if (orientation == 'v') {
            buffV += limit;
            buffG = 0;
        } else if (orientation == 'g') {
            buffG += limit;
            buffV = 0;
        }
        System.out.println("v = " + buffV + " g = " + buffG);
        return new int[]{buffV, buffG};
    }

}
