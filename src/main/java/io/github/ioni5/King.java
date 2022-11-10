package io.github.ioni5;

public class King extends Piece {

    private static final char[] SYMBOLS = {'\u2654', '\u265A'};

    public King(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Movement movement, boolean isClearpath, boolean isClearTarget) {
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        Direction direction = origin.direction(target);
        int verticalDistance = origin.verticalDistance(target);
        int horizontalDistance = origin.horizontalDistance(target);
        return direction == Direction.VERTICAL && verticalDistance == 1 
            || direction == Direction.HORIZONTAL && horizontalDistance == 1 
            || direction == Direction.DIAGONAL && verticalDistance == 1;
    }

    @Override
    public boolean isKing() {
        return true;
    }

}
