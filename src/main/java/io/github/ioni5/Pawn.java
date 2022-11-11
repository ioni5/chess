package io.github.ioni5;

public class Pawn extends Piece {

    private static final char[] SYMBOLS = {'\u2659', '\u265F'};

    private Coordinate initialCoordinate;

    public Pawn(Color color, Coordinate initialCoordinate) {
        super(color, SYMBOLS);
        this.initialCoordinate = initialCoordinate;
    }

    @Override
    public boolean isValidMove(Movement movement, boolean isClearpath, boolean isClearTarget) {
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        Direction direction = origin.direction(target);
        int distance = origin.verticalDistance(target);
        
        return (origin.orientation(target) == Orientation.POSITIVE && color == Color.BLACK
            || origin.orientation(target) == Orientation.NEGATIVE && color == Color.WHITE) 
            && direction == Direction.VERTICAL && isClearTarget && (distance == 1 
            || distance == 2 && origin.equals(initialCoordinate))
            || direction == Direction.DIAGONAL && distance == 1 && !isClearTarget;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
