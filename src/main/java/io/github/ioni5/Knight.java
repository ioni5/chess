package io.github.ioni5;

public class Knight extends Piece {

    private static final char[] SYMBOLS = {'\u2658', '\u265E'};

    public Knight(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, boolean isClearpath) {
        int horizontalDistance = from.horizontalDistance(to);
        int verticalDistance = from.verticalDistance(to);
        return horizontalDistance == 2 && verticalDistance == 1
            || horizontalDistance == 1 && verticalDistance == 2;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
