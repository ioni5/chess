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
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Coordinate[] path(Coordinate coordinate) {
        assert coordinate != null;
        assert this.direction(coordinate) != Direction.NONE;
        assert !this.equals(coordinate);
        Direction direction = this.direction(coordinate);
        Orientation orientation = this.orientation(coordinate);
        int pathSize;
        if (direction == Direction.HORIZONTAL) {
            pathSize = this.horizontalDistance(coordinate) + 1;
        } else {
            pathSize = this.verticalDistance(coordinate) + 1;
        }
        Coordinate[] path = new Coordinate[pathSize];
        path[0] = this;
        for (int i = 1; i < pathSize -1; i++) {
            path[i] = path[i - 1].displaced(direction, orientation);
        }
        path[pathSize - 1] = coordinate;
        return path;
    }

    private Orientation orientation(Coordinate coordinate) {
        assert coordinate != null;
        if (row >= coordinate.row && column >= coordinate.column) {
            return Orientation.NEGATIVE;
        }
        return Orientation.POSITIVE;
    }

    private Coordinate displaced(Direction direction, Orientation orientation) {
        assert direction != Direction.NONE;
        if (direction == Direction.VERTICAL) {
            return new Coordinate(row + orientation.number(), column);
        }
        if (direction == Direction.HORIZONTAL) {
            return new Coordinate(row, column + orientation.number());
        }
        return new Coordinate(row + orientation.number(), column + orientation.number());
    }

    public Direction direction(Coordinate coordinate) {
        assert coordinate != null;
        assert this.equals(coordinate);
        if (row == coordinate.row) {
            return Direction.HORIZONTAL;
        }
        if (column == coordinate.column) {
            return Direction.VERTICAL;
        }
        if (this.horizontalDistance(coordinate) == this.verticalDistance(coordinate)) {
            return Direction.DIAGONAL;
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
