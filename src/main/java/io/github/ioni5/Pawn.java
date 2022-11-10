package io.github.ioni5;

public class Pawn extends Piece {

    private static final char[] SYMBOLS = {'\u2659', '\u265F'};

    private static final int INIT_WHITE_ROW = 7;

    private static final int INIT_BLACK_ROW = 2;

    public Pawn(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to, boolean isClearpath, boolean isClearTarget) {
        Direction direction = from.direction(to);
        int distance = from.verticalDistance(to);
        int initRow = color == Color.BLACK ? INIT_BLACK_ROW : INIT_WHITE_ROW;
        return (from.orientation(to) == Orientation.POSITIVE && color == Color.BLACK
            || from.orientation(to) == Orientation.NEGATIVE && color == Color.WHITE)
            && direction == Direction.VERTICAL && isClearTarget && (distance == 1 
            || distance == 2 && from.getRow() == initRow)
            || direction == Direction.DIAGONAL && distance == 1 && !isClearTarget;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
