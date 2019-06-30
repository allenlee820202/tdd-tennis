package tdd;

import java.util.HashMap;

public class Game {
    private int firstPlayerScore;
    private int secondPlayerScore;
    private HashMap<Integer, String> scoreMap;
    private String firstPlayerName;
    private String secondPlayerName;

    public Game(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
        scoreMap = new HashMap<>();
        scoreMap.put(0, "Love");
        scoreMap.put(1, "Fifteen");
        scoreMap.put(2, "Thirty");
        scoreMap.put(3, "Forty");
    }

    public String score() {
        return isScoreNotEqual() ? isGamePoint() ? getGamePointStatus() : getScoreStatus()
               : isDeuce() ? deuce() : allPostfix();
    }

    private boolean isScoreNotEqual() {
        return firstPlayerScore != secondPlayerScore;
    }

    private String allPostfix() {
        return scoreMap.get(firstPlayerScore) + " All";
    }

    private String deuce() {
        return "Deuce";
    }

    private boolean isDeuce() {
        return firstPlayerScore > 2;
    }

    private boolean isGamePoint() {
        return firstPlayerScore > 3 || secondPlayerScore > 3;
    }

    private String getScoreStatus() {
        return scoreMap.get(firstPlayerScore) + " " + scoreMap.get(secondPlayerScore);
    }

    private String getGamePointStatus() {
        return getLeader()
               + ((Math.abs(firstPlayerScore - secondPlayerScore) >= 2) ? " win" : " Adv");
    }

    private String getLeader() {
        return (firstPlayerScore > secondPlayerScore) ? firstPlayerName : secondPlayerName;
    }

    public void firstPlayerScores() {
        this.firstPlayerScore += 1;
    }

    public void secondPlayerScores() {
        this.secondPlayerScore += 1;
    }
}
