package io.github.ioni5;

public class Board {

    public static final int DIMENSION = 8;

    private Square[][] squares;
    
    public Board() {
        squares = new Square[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                squares[i][j] = new Square();
            }
        }
        for (int i = 0; i < 2; i++) {
            Color color = i == 0 ? Color.BLACK : Color.WHITE;
            for (int j = 0; j < 2; j++) {
                squares[0 + i * 7][0 + j * 7].set(new Rook(color));
                squares[0 + i * 7][1 + j * 5].set(new Knight(color));
                squares[0 + i * 7][2 + j * 3].set(new Bishop(color));
            }
            squares[0 + i * 7][3].set(new Queen(color));
            squares[0 + i * 7][4].set(new King(color));
            for (int j = 0; j < DIMENSION; j++) {
                squares[1 + i * 5][j].set(new Pawn(color));
            }
        }
    }

    public void show() {
        Console console = new Console();
        console.write("\n");
        for (int i  = 0; i < DIMENSION; i++) {
            for (int j = 0; j <DIMENSION; j++) {
                squares[i][j].show();
            }
            new Console().write("\n");
        }
    }

    public boolean isValid(Movement movement) {
        assert movement != null;
        Console console = new Console();
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        Color color = movement.getColor();
        Square originSquare = this.getSquare(origin);
        Square targetSquare = this.getSquare(target);
        if (!originSquare.hasPiece()) {
            console.write("\nThere is no piece to move.");
            return false;
        }
        if (origin.equals(target)) {
            console.write("\nYou can't move to the same position.");
            return false;
        }
        if (!originSquare.hasColor(color)) {
            console.write("\nThis piece is not yours.");
            return false;
        }
        if (targetSquare.hasPiece() && !targetSquare.hasColor(color)) {
            console.write("\nPosition occupied by one of your pieces.");
            return false;
        }
        boolean isClearpath = false;
        if (origin.direction(target) != Direction.NONE) {
            isClearpath = this.isClearpath(origin.path(target));
        }
        if (!originSquare.isValidMove(movement, isClearpath)) {
            console.write("\nInvalid movement.");
            return false;
        }
        return true;
    }

    private Square getSquare(Coordinate coordinate) {
        assert coordinate != null;
        return squares[coordinate.getRow()][coordinate.getColumn()];
    }

    private boolean isClearpath(Coordinate[] path) {
        assert path != null && path.length > 1;
        if (path.length == 2) {
            return true;
        }
        for (int i = 1; i < path.length - 1; i++) {
            if (this.getSquare(path[i]).hasPiece()) {
                return false;
            }
        }
        return true;
    }

    public void execute(Movement movement) {
        assert movement != null;
        Coordinate origin = movement.getOrigin();
        Coordinate target = movement.getTarget();
        Square originSquare = this.getSquare(origin);
        Square targetSquare = this.getSquare(target);
        Piece piece = originSquare.get();
        originSquare.remove();
        targetSquare.set(piece);
    }

    public boolean isCheckmate() {
        int count = 0;
        Square square;
        for (int i  = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                square = this.getSquare(new Coordinate(i, j));
                if (square.hasPiece() && square.hasKing()) {
                    count++;
                }
            }
        }
        return count == 1;
    }

}
