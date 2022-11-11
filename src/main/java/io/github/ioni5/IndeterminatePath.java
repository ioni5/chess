package io.github.ioni5;

public class IndeterminatePath extends AbstractPath {

    public IndeterminatePath(Movement movement) {
        super(movement);
        assert movement.direction() == Direction.NONE;
        size = 2;
        coordinates = new Coordinate[] {
            movement.getOrigin(),
            movement.getTarget()
        };
        values = new boolean[size];
    }

    @Override
    public boolean isClearpath() {
        return false;
    }
    
}
