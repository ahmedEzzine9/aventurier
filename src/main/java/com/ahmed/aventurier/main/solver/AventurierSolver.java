package com.ahmed.aventurier.main.solver;

import com.ahmed.aventurier.main.exceptions.AlreadyInWoodsException;
import com.ahmed.aventurier.main.model.Aventurier;
import com.ahmed.aventurier.main.model.Card;

public class AventurierSolver {

    public Aventurier solve(Aventurier aventurier, Card card) throws AlreadyInWoodsException {
        int x = aventurier.getX();
        int y = aventurier.getY();

        if (isObstacle(card, x, y)) {
            throw new AlreadyInWoodsException();
           
        }

        for (String move : aventurier.getMoves()) {
            
            switch (move) {
                case "S":
                    if (canMoveSouth(card, x, y))
                        y++;
                    break;
                case "E":
                    if (canMoveEast(card, x, y))
                        x++;
                    break;
                case "N":
                    if (canMoveNorth(card, x, y))
                        y--;
                    break;
                case "O":
                    if (canMoveWest(card, x, y))
                        x--;
                    break;
                default:
                    break;
            }
            aventurier.setX(x);
            aventurier.setY(y);
        }

        return aventurier;
    }

    private boolean isObstacle(Card card, int x, int y) {
        return card.getCardAsList().get(y).get(x).equals("#");
    }

    private boolean canMoveSouth(Card card, int x, int y) {
        return y < card.getCardAsList().size() - 1 && !card.getCardAsList().get(y + 1).get(x).equals("#");
    }

    private boolean canMoveEast(Card card, int x, int y) {
        return x < card.getCardAsList().get(y).size() - 1 && !card.getCardAsList().get(y).get(x + 1).equals("#");
    }

    private boolean canMoveNorth(Card card, int x, int y) {
        return y > 0 && !card.getCardAsList().get(y - 1).get(x).equals("#");
    }

    private boolean canMoveWest(Card card, int x, int y) {
        return x > 0 && !card.getCardAsList().get(y).get(x - 1).equals("#");
    }
}
