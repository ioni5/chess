package io.github.ioni5;

public class Pawn extends Piece {

    private static final char[] SYMBOLS = {'\u2659', '\u265F'};

    private static final int INIT_WHITE_ROW = 6;

    private static final int INIT_BLACK_ROW = 1;

    public Pawn(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidMove(Movement movement, boolean isClearpath, boolean isClearTarget) {
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        Direction direction = origin.direction(target);
        int distance = origin.verticalDistance(target);
        int initRow = color == Color.BLACK ? INIT_BLACK_ROW : INIT_WHITE_ROW;
        return (origin.orientation(target) == Orientation.POSITIVE && color == Color.BLACK
            || origin.orientation(target) == Orientation.NEGATIVE && color == Color.WHITE) 
            && direction == Direction.VERTICAL && isClearTarget && (distance == 1 
            || distance == 2 && origin.getRow() == initRow)
            || direction == Direction.DIAGONAL && distance == 1 && !isClearTarget;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
