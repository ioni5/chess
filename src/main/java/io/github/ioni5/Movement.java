package io.github.ioni5;

public class Movement {

    private Board board;

    private Color color;

    private Coordinate from;

    private Coordinate to;

    public Movement(Color color, Board board) {
        this.color = color;
        this.board = board;
        from = new Coordinate();
        to = new Coordinate();
        this.obtainCoordinates();
    }

    public void obtainCoordinates() {
        Intervale LIMIT = new Intervale(1, Board.DIMENSION);
        Console console = new Console();
        console.write("\nFrom what position? ");
        from.obtain(LIMIT);
        console.write("\nTo what position? ");
        to.obtain(LIMIT);
    }

    public boolean isValid() {
        Console console = new Console();
        if (board.isEmpty(from)) {
            console.write("\nThere is no piece to move.");
            return false;
        }
        if (from.equals(to)) {
            console.write("\nYou can't move to the same position.");
            return false;
        }
        return board.isValidMove(color, from, to);
    }

    public void execute() {
        board.move(from, to);
    }

}
