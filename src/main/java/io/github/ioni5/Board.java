package io.github.ioni5;

public class Board {

    public static final int DIMENSION = 8;

    private Square[][] squares;

    private boolean isCheckmate;
    
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
                squares[1 + i * 5][j].set(new Pawn(color, new Coordinate(1 + i * 5, j)));
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
        Square originSquare = this.getSquare(movement.getOrigin());
        Square targetSquare = this.getSquare(movement.getTarget());
        Color color = movement.getColor();
        if (!originSquare.isValidToTake(color) 
            || !targetSquare.isValidToPut(color)) {
            return false;
        }
        AbstractPath path = this.createPath(movement);
        return originSquare.isValidToMovePieceBetween(path);
    }

    private AbstractPath createPath(Movement movement) {
        assert movement != null;
        AbstractPath path;
        if (movement.isDirection(Direction.NONE)) {
            path = new IndeterminatePath(movement);
        } else {
            path = new Path(movement);
        }
        boolean[] values = new boolean[path.size()];
        for (int i = 0; i < path.size(); i++) {
            values[i] = this.getSquare(path.get(i)).hasPiece();
        }
        path.setValues(values);
        return path;
    }

    private Square getSquare(Coordinate coordinate) {
        assert coordinate != null;
        return squares[coordinate.getRow()][coordinate.getColumn()];
    }

    public void execute(Movement movement) {
        assert movement != null;
        Square originSquare = this.getSquare(movement.getOrigin());
        Square targetSquare = this.getSquare(movement.getTarget());
        if (targetSquare.hasPiece() && targetSquare.hasKing()) {
            isCheckmate = true;
        }
        targetSquare.set(originSquare.get());
        originSquare.remove();
    }

    public boolean isCheckmate() {
        return isCheckmate;
    }

}
