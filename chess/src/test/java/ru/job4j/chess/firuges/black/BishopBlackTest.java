package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void checkPosition() {
        Cell actual = Cell.C8;
        BishopBlack figure = new BishopBlack(actual);
        assertEquals(figure.position(), actual);
    }

    @Test
    public void checkCopy() {
        BishopBlack initial = new BishopBlack(Cell.A3);
        Figure actual = initial.copy(Cell.C6);
        assertEquals(actual.position(), Cell.C6);
    }

    @Test
    public void checkWayFromC1ToG5() {
        BishopBlack initial = new BishopBlack(Cell.C1);
        Cell[] actual = initial.way(Cell.G5);
        assertArrayEquals(actual, new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    public void checkWayFromG5ToC1() {
        BishopBlack initial = new BishopBlack(Cell.G5);
        Cell[] actual = initial.way(Cell.C1);
        assertArrayEquals(actual, new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1});
    }

    @Test (expected = ImpossibleMoveException.class)
    public void checkWayFromA1ToB5() {
        BishopBlack initial = new BishopBlack(Cell.A1);
        initial.way(Cell.B5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void checkWayFromA1ToA3() {
        BishopBlack initial = new BishopBlack(Cell.A1);
        initial.way(Cell.A3);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void checkWayFromH8ToC8() {
        BishopBlack initial = new BishopBlack(Cell.H8);
        initial.way(Cell.C8);
    }
}