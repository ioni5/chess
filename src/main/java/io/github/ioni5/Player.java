package io.github.ioni5;

public class Player {

    private Board board;

    private Color color;

    public Player(Color color, Board board) {
        this.board = board;
        this.color = color;
    }

    public void play() {
        new Console().write("\nPlay " + color.name());
        Coordinate from;
        Coordinate to;
        boolean error;
        do {
            from = this.obtainCoordinate("\nFrom what position? ");
            to = this.obtainCoordinate("\nTo what position? ");
            error = !board.isValidMove(color, from, to);
        } while (error);
        board.move(from, to);
    }

    private Coordinate obtainCoordinate(String message) {
        Console console = new Console();
        console.write(message);
        Coordinate coordinate = new Coordinate();
        coordinate.obtain(new Intervale(1, Board.DIMENSION));
        return coordinate;
    }

    public String getName() {
        return color.name();
    }

}
