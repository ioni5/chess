package io.github.ioni5;

public class Pawn extends Piece {

    private static final char[] SYMBOLS = {'\u2659', '\u265F'};

    private static final int INIT_WHITE_ROW = 6;

    private static final int INIT_BLACK_ROW = 1;

    public Pawn(Color color) {
        super(color, SYMBOLS);
    }

    @Override
    public boolean isValidToMoveBetween(AbstractPath path) {
        return this.isValidOrientation(path) && (
            this.isValidVerticalMove(path) || this.isValidDiagonalMove(path)
        );
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
        return path.isDirection(Direction.VERTICAL) && path.isClearTarget() && (
            path.isVerticalDistance(2) && this.isFirstMovement(path)
            || path.isVerticalDistance(1)
        );
    }

    private boolean isFirstMovement(AbstractPath path) {
        int initRow = color == Color.BLACK ? INIT_BLACK_ROW : INIT_WHITE_ROW;
        return path.get(0).getRow() == initRow;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
