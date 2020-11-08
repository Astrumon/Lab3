package com.ua.seawar.score_players;

import com.ua.seawar.score_players.Score;

public class ScorePlayerTwo extends Score {
    private static int score = 0;

    public void addPoint() {
        score++;
    }
    public int getScore() {
        return score;
    }
}
