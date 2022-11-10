package io.github.ioni5;

public class Rook extends Piece {

    private static final char[] SYMBOLS = {'\u2656', '\u265C'};

    public Rook(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Movement movement, boolean isClearpath, boolean isClearTarget) {
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        Direction direction = origin.direction(target);
        return (direction == Direction.HORIZONTAL || direction == Direction.VERTICAL) 
            && isClearpath;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}