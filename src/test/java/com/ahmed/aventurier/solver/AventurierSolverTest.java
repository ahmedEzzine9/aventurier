package com.ahmed.aventurier.solver;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ahmed.aventurier.main.exceptions.AlreadyInWoodsException;
import com.ahmed.aventurier.main.model.Aventurier;
import com.ahmed.aventurier.main.model.Card;
import com.ahmed.aventurier.main.solver.AventurierSolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;

public class AventurierSolverTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSolveWithoutObstacles() throws AlreadyInWoodsException {

        Aventurier aventurier = new Aventurier();
        aventurier.setX(1);
        aventurier.setY(1);
        aventurier.setMoves(Arrays.asList("N", "E", "S", "O"));

        Card card = new Card();
        card.getCardAsList().add(Arrays.asList(" ", " ", " "));
        card.getCardAsList().add(Arrays.asList(" ", " ", " "));
        card.getCardAsList().add(Arrays.asList(" ", " ", " "));

        AventurierSolver solver = new AventurierSolver();

        // get Result
        Aventurier result = solver.solve(aventurier, card);

        // assert result
        assertEquals(1, result.getX());
        assertEquals(1, result.getY());
    }

    @Test
    public void testSolveWithObstacles() throws AlreadyInWoodsException {
        // prepare aventurier
        Aventurier aventurier = new Aventurier();
        aventurier.setX(1);
        aventurier.setY(1);
        aventurier.setMoves(Arrays.asList("N", "E", "S", "O"));

        Card card = new Card();
        card.getCardAsList().add(Arrays.asList(" ", "#", " "));
        card.getCardAsList().add(Arrays.asList(" ", " ", "#"));
        card.getCardAsList().add(Arrays.asList("#", " ", " "));

        AventurierSolver solver = new AventurierSolver();

        // get result
        Aventurier result = solver.solve(aventurier, card);

        // Assert result
        assertEquals(1, result.getX());
        assertEquals(2, result.getY());
    }

    @Test
    public void testSolveStartInObstacle() throws AlreadyInWoodsException {
        // preapre aventurier
        Aventurier aventurier = new Aventurier();
        aventurier.setX(1);
        aventurier.setY(1);
        aventurier.setMoves(Arrays.asList("N", "E", "S", "O"));

        Card card = new Card();
        card.getCardAsList().add(Arrays.asList("#", "#", "#"));
        card.getCardAsList().add(Arrays.asList("#", "#", "#"));
        card.getCardAsList().add(Arrays.asList("#", "#", "#"));

        AventurierSolver solver = new AventurierSolver();

        // set the exception rules
        exceptionRule.expect(AlreadyInWoodsException.class);
        exceptionRule.expectMessage("Aventurier is Already in woods so he can't move");
        // try to throw AlreadyInWoodsException
        solver.solve(aventurier, card);
    }
}
