package io.github.ioni5;

public class Rook extends Piece {

    private static final char[] SYMBOLS = {'\u2656', '\u265C'};

    public Rook(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidToMoveBetween(AbstractPath path) {
        return (path.isDirection(Direction.HORIZONTAL) || path.isDirection(Direction.VERTICAL)) 
            && path.isClearpath();
    }

    @Override
    public boolean isKing() {
        return false;
    }

}