package com.ua.seawar.ships;

import com.ua.seawar.ships.Ship;

import java.util.Arrays;

public class FourDeck extends Ship {
    private String deckValue = "f";
    private final int COUNT_DECK = 4;

    public String[] create() {
        String[] ship = new String[COUNT_DECK];
        Arrays.fill(ship, deckValue);

        return ship;
    }

    public int getCOUNT_DECK() {
        return COUNT_DECK;
    }
}
