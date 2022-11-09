package io.github.ioni5;

public class Queen extends Piece {

    private static final char[] SYMBOLS = {'\u2655', '\u265B'};

    public Queen(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Movement movement, boolean isClearpath) {
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        return origin.direction(target) != Direction.NONE && isClearpath;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
