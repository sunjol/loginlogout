package com.example.loginlogout;

public class high {
    String username;
    int score;
    String category;

    public high() {
    }

    public high(String username, int score, String category) {
        this.username = username;
        this.score = score;
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public String getCategory() {
        return category;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
