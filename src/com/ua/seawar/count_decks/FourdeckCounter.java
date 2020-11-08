package com.ua.seawar.count_decks;

public class FourdeckCounter extends Counter {

    private  int count = 1;
    private  int countType = 0;

    public void add() {
        countType++;
    }

    public int getCountType() {
        return countType;
    }

    public void setCountType(int countType) {
        this.countType = countType;
    }

    @Override
    public void decrease() {
        count--;
    }

    @Override
    public int getCount() {
        return count;
    }
}
