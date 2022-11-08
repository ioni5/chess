package io.github.ioni5;

public class Board {

    public static final int DIMENSION = 8;

    private Piece[][] pieces;
    
    public Board() {
        pieces = new Piece[DIMENSION][DIMENSION];
        for (int i = 0; i < 2; i++) {
            Color color = i == 0 ? Color.BLACK : Color.WHITE;
            for (int j = 0; j < 2; j++) {
                pieces[0 + i * 7][0 + j * 7] = new Rook(color);
                pieces[0 + i * 7][1 + j * 5] = new Knight(color);
                pieces[0 + i * 7][2 + j * 3] = new Bishop(color);
            }
            pieces[0 + i * 7][3] = new Queen(color);
            pieces[0 + i * 7][4] = new King(color);
            for (int j = 0; j < DIMENSION; j++) {
                pieces[1 + i * 5][j] = new Pawn(color);
            }
        }
    }

    public void show() {
        Console console = new Console();
        console.write("\n");
        for (int i  = 0; i < DIMENSION; i++) {
            for (int j = 0; j <DIMENSION; j++) {
                if (pieces[i][j] != null) {
                    pieces[i][j].show();
                } else {
                    console.write("_");
                }
            }
            console.write("\n");
        }
    }

    public boolean isValidMove(Color color, Coordinate from, Coordinate to) {
        assert color != null && from != null && to != null;
        Console console = new Console();
        Piece piece = this.get(from);
        if (!piece.isColor(color)) {
            console.write("\nThis piece is not yours.");
            return false;
        }
        if (!this.isEmpty(to) && this.get(to).isColor(color)) {
            console.write("\nPosition occupied by one of your pieces.");
            return false;
        }
        boolean isClearpath = false;
        if (from.direction(to) != Direction.NONE) {
            isClearpath = this.isClearpath(from.path(to));
        }
        if (!piece.isValidMove(from, to, isClearpath)) {
            console.write("\nInvalid movement.");
            return false;
        }
        return true;
    }

    private boolean isClearpath(Coordinate[] path) {
        assert path != null && path.length > 1;
        if (path.length == 2) {
            return true;
        }
        for (int i = 1; i < path.length - 1; i++) {
            if (!this.isEmpty(path[i])) {
                return false;
            }
        }
        return true;
    }

    public void move(Coordinate from, Coordinate to) {
        assert from != null && to != null;
        assert !this.isEmpty(from);
        Piece piece = this.get(from);
        this.remove(from);
        this.set(to, piece);
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return pieces[coordinate.getRow() - 1][coordinate.getColumn() - 1] == null;
    }

    private Piece get(Coordinate coordinate) {
        assert coordinate != null && !this.isEmpty(coordinate);
        return pieces[coordinate.getRow() - 1][coordinate.getColumn() - 1];
    }

    private void set(Coordinate coordinate, Piece piece) {
        assert coordinate != null && piece != null;
        pieces[coordinate.getRow() - 1][coordinate.getColumn() - 1] = piece;
    }

    private void remove(Coordinate coordinate) {
        assert coordinate != null;
        pieces[coordinate.getRow() - 1][coordinate.getColumn() - 1] = null;
    }

    public boolean isCheckmate() {
        int count = 0;
        for (int i  = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (pieces[i][j] != null && pieces[i][j].isKing()) {
                    count++;
                }
            }
        }
        return count == 1;
    }

}
