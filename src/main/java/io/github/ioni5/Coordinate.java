package io.github.ioni5;

public class Coordinate {

    private int row;

    private int column;

    public Coordinate() {}

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void obtain(Intervale LIMIT) {
        Console console = new Console();
        boolean error = false;
        int row = 0;
        int column = 0;
        do {
            row = console.readInt("\nrow: ");
            column = console.readInt("column: ");
            error = !LIMIT.include(row) || !LIMIT.include(column);
            if (error) {
                console.write("\nError: coordinates out of range.");
                console.write("\nEnter value between [1-8].");
            }
        } while (error);
        this.row = row - 1;
        this.column = column - 1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Orientation orientation(Coordinate coordinate) {
        assert coordinate != null;
        assert !this.equals(coordinate);
        assert this.direction(coordinate) != Direction.NONE;
        Direction direction = this.direction(coordinate);
        if (direction == Direction.HORIZONTAL && column > coordinate.column
            || direction != Direction.HORIZONTAL && row > coordinate.row) {
            return Orientation.NEGATIVE;
        }
        return Orientation.POSITIVE;
    }

    public Coordinate displaced(Direction direction, Orientation orientation) {
        assert direction != Direction.NONE;
        if (direction == Direction.VERTICAL) {
            return new Coordinate(row + orientation.number(), column);
        }
        if (direction == Direction.HORIZONTAL) {
            return new Coordinate(row, column + orientation.number());
        }
        if (direction == Direction.DIAGONAL) {
            return new Coordinate(row + orientation.number(), column - orientation.number());
        }
        return new Coordinate(row + orientation.number(), column + orientation.number());
    }

    public Direction direction(Coordinate coordinate) {
        assert coordinate != null;
        assert !this.equals(coordinate);
        if (row == coordinate.row) {
            return Direction.HORIZONTAL;
        }
        if (column == coordinate.column) {
            return Direction.VERTICAL;
        }
        if (row < coordinate.row && column > coordinate.column
            || row > coordinate.row && column < coordinate.column) {
            return Direction.DIAGONAL;
        }
        if (row < coordinate.row && column < coordinate.column
            || row > coordinate.row && column > coordinate.column) {
            return Direction.INVERSE;
        }
        return Direction.NONE;
    }

    public int horizontalDistance(Coordinate coordinate) {
        return Math.abs(column - coordinate.column);
    }

    public int verticalDistance(Coordinate coordinate) {
        return Math.abs(row - coordinate.row);
    }

    public boolean equals(Coordinate coordinate) {
        return row == coordinate.row && column == coordinate.column;
    }

}
