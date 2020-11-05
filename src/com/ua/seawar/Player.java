package com.ua.seawar;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Field field;
    private String[][] arrayField;
    private List<Ship> singleDecks, doubleDecks, threeDecks, fourDecks;
    private int countSingleDeck = 4, countDoubleDeck = 3, countThreeDeck = 2, countFourDeck = 1;

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

    public void setSingleDeck(int x, int y) {
        try {
            arrayField[x][y] = singleDecks.get(countSingleDeck - 1).create()[0];
            countSingleDeck--;
            field.setArrayField(arrayField);
            field.showField();
        } catch (IndexOutOfBoundsException exc) {
            System.err.println("max of single-deck ship is 4");
        }

    }

    public void setDoubleDeck(int x, int y) {
        String[] partsOfShip;
        try {
            int count = getCountDeck(doubleDecks.get(0));
            partsOfShip = doubleDecks.get(countDoubleDeck - 1).create();
            for (int i = 0; i < count; i++) {
                arrayField[x++][y] = partsOfShip[i];
            }
            countDoubleDeck--;
            field.setArrayField(arrayField);
            field.showField();
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("max of double-deck ship is 3");
        }
    }

    public void setThreeDecks(int x, int y) {
        String[] partsOfShip;
        try {
            int count = getCountDeck(threeDecks.get(0));
            partsOfShip = threeDecks.get(countThreeDeck - 1).create();
            for (int i = 0; i < count; i++) {
                arrayField[x++][y] = partsOfShip[i];
            }
            countThreeDeck--;
            field.setArrayField(arrayField);
            field.showField();
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("max of three-deck ship is 2");
        }
    }


    public void setFourDecks(int x, int y) {
        String[] partsOfShip;
        try {
            int count = getCountDeck(fourDecks.get(0));
            partsOfShip = fourDecks.get(countFourDeck - 1).create();
            for (int i = 0; i < count; i++) {
                arrayField[x++][y] = partsOfShip[i];
            }
            countFourDeck--;
            field.setArrayField(arrayField);
            field.showField();
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("max of four-deck ship is 1");
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


}
