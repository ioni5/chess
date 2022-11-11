package io.github.ioni5;

public abstract class AbstractPath {

    protected Movement movement;

    protected Coordinate[] coordinates;

    protected boolean[] values;

    protected int size;

    public AbstractPath(Movement movement) {
        this.movement = movement;
    }

    public Coordinate get(int index) {
        assert index < size;
        return coordinates[index];
    }

    public int size() {
        return size;
    }

    public void setValues(boolean[] values) {
        assert values != null;
        assert values.length == this.values.length;
        this.values = values;
    }

    public boolean isDirection(Direction direction) {
        return movement.direction() == direction;
    }

    public boolean isVerticalDistance(int distance) {
        return movement.verticalDistance() == distance;
    }

    public boolean isHorizontalDistance(int distance) {
        return movement.horizontalDistance() == distance;
    }

    public boolean isOrientation(Orientation orientation) {
        return movement.orientation() == orientation;
    }

    public abstract boolean isClearpath();

    public boolean isClearTarget() {
        return !values[size - 1];
    }

    public void show() {
        for (Coordinate c: coordinates) {
            new Console().write("\n" + c.getRow() + ", " + c.getColumn());
        }
    }

}
