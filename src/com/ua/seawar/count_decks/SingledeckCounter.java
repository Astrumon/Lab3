package com.ua.seawar.count_decks;

public class SingledeckCounter extends Counter {

    private  int count = 4;
    private  int countType = 0;

    @Override
    public void decrease() {
        count--;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void add() {
        countType++;
    }

    @Override
    public int getCountType() {
        return countType;
    }

    public void setCountType(int countType) {
        this.countType = countType;
    }
}
