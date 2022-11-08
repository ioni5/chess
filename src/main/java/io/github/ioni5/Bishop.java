package io.github.ioni5;

public class Bishop extends Piece {

    private static final char[] SYMBOLS = {'\u2657', '\u265D'};

    public Bishop(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, boolean isClearpath) {
        Direction direction = from.direction(to);
        return direction == Direction.DIAGONAL && isClearpath;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
