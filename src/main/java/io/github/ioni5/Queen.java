package io.github.ioni5;

public class Queen extends Piece {

    private static final char[] SYMBOLS = {'\u2655', '\u265B'};

    public Queen(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidToMoveBetween(AbstractPath path) {
        return !path.isDirection(Direction.NONE) && path.isClearpath();
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
