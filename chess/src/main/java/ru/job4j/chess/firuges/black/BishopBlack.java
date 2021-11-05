package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest));
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        /**
        * deltaX и deltaY будут -1, если движение в обратном направлении, и 1, если движение вперед
        * */
        int deltaX = (dest.getX() - position.getX()) / size;
        int deltaY = (dest.getY() - position.getY()) / size;
        steps[0] = Cell.findBy(position.getX() + deltaX,
                position.getY() + deltaY);
        for (int index = 1; index < size; index++) {
            steps[index] = Cell.findBy(steps[index - 1].getX() + deltaX,
                    steps[index - 1].getY() + deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
