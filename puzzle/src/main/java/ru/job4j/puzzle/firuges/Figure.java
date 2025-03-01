package ru.job4j.puzzle.firuges;

public interface Figure {
    default boolean movable() {
        return true;
    }

    Cell position();

    Cell[] way(Cell dest, Cell source);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
