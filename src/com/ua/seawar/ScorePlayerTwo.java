package com.ua.seawar;

public class ScorePlayerTwo extends Score {
    private static int score;

    public void addPoint() {
        score++;
    }
    public int getScore() {
        return score;
    }
}
