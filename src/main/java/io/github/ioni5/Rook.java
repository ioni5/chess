package io.github.ioni5;

public class Rook extends Piece {

    private static final char[] SYMBOLS = {'\u2656', '\u265C'};

    public Rook(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, boolean isClearpath, boolean isClearTarget) {
        Direction direction = from.direction(to);
        return (direction == Direction.HORIZONTAL || direction == Direction.VERTICAL) 
            && isClearpath;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}