package com.ua.seawar;

import java.util.Arrays;

public class ThreeDeck extends Ship {
    private String deckValue = "t";
    private final int COUNT_DECK = 3;

    public String[] create() {
        String[] ship = new String[COUNT_DECK];
        Arrays.fill(ship, deckValue);

        return ship;
    }

    public int getCOUNT_DECK() {
        return COUNT_DECK;
    }
}
