package io.github.ioni5;

public class Bishop extends Piece {

    private static final char[] SYMBOLS = {'\u2657', '\u265D'};

    public Bishop(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidToMoveBetween(AbstractPath path) {
        return path.isClearpath() && (
            path.isDirection(Direction.DIAGONAL) || path.isDirection(Direction.INVERSE)
            );
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
