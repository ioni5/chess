package io.github.ioni5;

public class King extends Piece {

    private static final char[] SYMBOLS = {'\u2654', '\u265A'};

    public King(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, boolean isClearpath) {
        Direction direction = from.direction(to);
        int verticalDistance = from.verticalDistance(to);
        int horizontalDistance = from.horizontalDistance(to);
        return direction == Direction.VERTICAL && verticalDistance == 1 
            || direction == Direction.HORIZONTAL && horizontalDistance == 1 
            || direction == Direction.DIAGONAL && verticalDistance == 1;
    }

    @Override
    public boolean isKing() {
        return true;
    }

}
