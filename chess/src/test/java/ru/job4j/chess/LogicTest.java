package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {
    @Test (expected = OccupiedCellException.class)
    public void moveViaFigure() throws FigureNotFoundException, OccupiedCellException,
            ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = FigureNotFoundException.class)
    public void moveNothing() throws FigureNotFoundException, OccupiedCellException,
            ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new PawnBlack(Cell.D2));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void moveIncorrectMethod() throws FigureNotFoundException, OccupiedCellException,
            ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        logic.move(Cell.C1, Cell.C6);
    }
}