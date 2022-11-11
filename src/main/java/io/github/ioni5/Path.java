package io.github.ioni5;

public class Path extends AbstractPath {

    public Path(Movement movement) {
        super(movement);
        assert movement.direction() != Direction.NONE;
        assert movement.verticalDistance() > 0 || movement.horizontalDistance() > 0;
        size = (movement.direction() == Direction.HORIZONTAL 
            ? movement.horizontalDistance() + 1 
            : movement.verticalDistance()) + 1;
        coordinates = new Coordinate[size];
        values = new boolean[size];
        this.fillPath();
    }

    private void fillPath() {
        Direction direction = movement.direction();
        Orientation orientation = movement.orientation();
        coordinates[0] = movement.getOrigin();
        for (int i = 1; i < size - 1; i++) {
            coordinates[i] = coordinates[i - 1].displaced(direction, orientation);
        }
        coordinates[size - 1] = movement.getTarget();
    }

    @Override
    public boolean isClearpath() {
        assert values != null;
        for (int i = 1; i < size - 1; i++) {
            if (values[i]) {
                return false;
            }
        }
        return true;
    }
    
}
