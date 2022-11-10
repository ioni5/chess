package io.github.ioni5;

public class Square {

    private Piece piece;

    public void set(Piece piece) {
        this.piece = piece;
    }

    public void show() {
        if (this.hasPiece()) {
            piece.show();
        } else {
            new Console().write("_");
        }
    }

    public boolean hasPiece() {
        return piece != null;
    }

    public boolean hasColor(Color color) {
        assert color != null && this.hasPiece();
        return piece.isColor(color);
    }

    public boolean isValidMove(Movement movement, boolean isClearpath) {
        return piece.isValidMove(movement, isClearpath);
    }

    public Piece get() {
        return piece;
    }

    public void remove() {
        piece = null;
    }

    public boolean hasKing() {
        assert this.hasPiece();
        return piece.isKing();
    }

}
