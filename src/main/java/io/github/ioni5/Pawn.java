package io.github.ioni5;

public class Pawn extends Piece {

    private static final char[] SYMBOLS = {'\u2659', '\u265F'};

    private Coordinate initialCoordinate;

    public Pawn(Color color, Coordinate initialCoordinate) {
        super(color, SYMBOLS);
        this.initialCoordinate = initialCoordinate;
    }

    @Override
    public boolean isValidToMoveBetween(AbstractPath path) {
        return this.isValidOrientation(path) 
            && (this.isValidVerticalMove(path) || this.isValidDiagonalMove(path));
    }

    private boolean isValidOrientation(AbstractPath path) {
        return this.isColor(Color.BLACK) && path.isOrientation(Orientation.POSITIVE)
            || this.isColor(Color.WHITE) && path.isOrientation(Orientation.NEGATIVE);
    }

    private boolean isValidDiagonalMove(AbstractPath path) {
        return (path.isDirection(Direction.DIAGONAL) || path.isDirection(Direction.INVERSE))
            && path.isVerticalDistance(1) 
            && !path.isClearTarget();
    }

    private boolean isValidVerticalMove(AbstractPath path) {
        return path.isDirection(Direction.VERTICAL) && path.isClearTarget() 
            && (path.isVerticalDistance(2) && this.isFirstMovement(path)
            || path.isVerticalDistance(1));
    }

    private boolean isFirstMovement(AbstractPath path) {
        return path.get(0).equals(initialCoordinate);
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
