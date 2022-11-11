package io.github.ioni5;

public class King extends Piece {

    private static final char[] SYMBOLS = {'\u2654', '\u265A'};

    public King(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidToMoveBetween(AbstractPath path) {
        return path.isVerticalDistance(1) 
            && (path.isDirection(Direction.VERTICAL) 
                || path.isDirection(Direction.DIAGONAL) 
                || path.isDirection(Direction.INVERSE))
            || path.isDirection(Direction.HORIZONTAL) && path.isHorizontalDistance(1);
    }

    @Override
    public boolean isKing() {
        return true;
    }

}
