package com.ahmed.aventurier.main.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<List<String>> cardAsList;

    public Card() {
        this.cardAsList = new ArrayList<>();
    }

    public Card(List<List<String>> cardAsList) {
        this.cardAsList = cardAsList;
    }

    public List<List<String>> getCardAsList() {
        return cardAsList;
    }

    public void setCardAsList(List<List<String>> cardAsList) {
        this.cardAsList = cardAsList;
    }
}
