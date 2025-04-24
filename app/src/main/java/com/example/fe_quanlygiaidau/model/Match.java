package com.example.fe_quanlygiaidau.model;

public class Match {
    private String team1;
    private String team2;
    private String score;
    private String time;

    public Match(String team1, String team2, String score, String time) {
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
        this.time = time;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getScore() {
        return score;
    }

    public String getTime() {
        return time;
    }
}
