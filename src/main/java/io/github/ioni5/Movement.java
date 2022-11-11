package io.github.ioni5;

public class Movement {

    private Color color;

    private Coordinate origin;

    private Coordinate target;

    public Movement(Color color) {
        this.color = color;
        origin = new Coordinate();
        target = new Coordinate();
        this.obtainCoordinates();
    }

    public void obtainCoordinates() {
        Intervale LIMIT = new Intervale(1, Board.DIMENSION);
        Console console = new Console();
        boolean error = false;
        do {
            console.write("\nFrom what position? ");
            origin.obtain(LIMIT);
            console.write("\nTo what position? ");
            target.obtain(LIMIT);
            error = origin.equals(target);
            if (error) {
                console.write("\nYou can't move to the same position.");
            }
        } while (error);
    }

    public Coordinate getOrigin() {
        return origin;
    }

    public Coordinate getTarget() {
        return target;
    }

    public Color getColor() {
        return color;
    }

    public boolean isDirection(Direction direction) {
        return origin.direction(target) == direction;
    }

    public Direction direction() {
        return origin.direction(target);
    }

    public int verticalDistance() {
        return origin.verticalDistance(target);
    }

    public int horizontalDistance() {
        return origin.horizontalDistance(target);
    }

    public Orientation orientation() {
        return origin.orientation(target);
    }
}
