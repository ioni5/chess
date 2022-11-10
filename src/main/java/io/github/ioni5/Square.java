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

    public boolean isValidMove(Movement movement, boolean isClearpath, boolean isClearTarget) {
        assert movement != null;
        Console console = new Console();
        if (!piece.isValidMove(movement, isClearpath, isClearTarget)) {
            console.write("\nInvalid movement.");
            return false;
        }
        return true;
    }

    public boolean isValidToTake(Color color) {
        assert color != null;
        Console console = new Console();
        if (!this.hasPiece()) {
            console.write("\nThere is no piece to move.");
            return false;
        }
        if (!this.hasColor(color)) {
            console.write("\nThis piece is not yours.");
            return false;
        }
        return true;
    }

    public boolean isValidToPut(Color color) {
        assert color != null;
        Console console = new Console();
        if (this.hasPiece() && this.hasColor(color)) {
            console.write("\nPosition occupied by one of your pieces.");
            return false;
        }
        return true;
    }

}
