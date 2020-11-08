package com.ua.seawar.ships;

import java.util.Arrays;

public class SingleDeck extends Ship {
    private String deckValue = "s";
    private final int COUNT_DECK = 1;

    public String[] create() {
        String[] ship = new String[COUNT_DECK];
        Arrays.fill(ship, deckValue);

        return ship;
    }

    public int getCOUNT_DECK() {
        return COUNT_DECK;
    }
}
