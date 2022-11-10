package io.github.ioni5;

public class Queen extends Piece {

    private static final char[] SYMBOLS = {'\u2655', '\u265B'};

    public Queen(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, boolean isClearpath, boolean isClearTarget) {
        return from.direction(to) != Direction.NONE && isClearpath;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
