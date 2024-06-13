package com.ahmed.aventurier.main.model;

import java.util.List;

/**
 * this class illustrate the aventurier
 */
public class Aventurier {
    private int x;

    private int y;

    private List<String> moves;

    public Aventurier() {
    }

    public Aventurier(int x, int y, List<String> moves) {
        this.x = x;
        this.y = y;
        this.moves = moves;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public void incrementX() {
        this.x++;
    }

    public void incrementY() {
        this.y++;
    }
}
