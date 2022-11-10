package io.github.ioni5;

public class Bishop extends Piece {

    private static final char[] SYMBOLS = {'\u2657', '\u265D'};

    public Bishop(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Movement movement, boolean isClearpath, boolean isClearTarget) {
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        Direction direction = origin.direction(target);
        return direction == Direction.DIAGONAL && isClearpath;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
