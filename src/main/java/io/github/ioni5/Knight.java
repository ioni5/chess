package io.github.ioni5;

public class Knight extends Piece {

    private static final char[] SYMBOLS = {'\u2658', '\u265E'};

    public Knight(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidToMoveBetween(AbstractPath path) {
        return path.isHorizontalDistance(2) && path.isVerticalDistance(1)
            || path.isVerticalDistance(2) && path.isHorizontalDistance(1);
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
