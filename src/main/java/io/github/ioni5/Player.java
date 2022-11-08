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
        Movement movement;
        boolean error = false;
        do {
            movement = new Movement(color, board);
            error = !movement.isValid();
        } while (error);
        movement.execute();
    }

    public String getName() {
        return color.name();
    }

}
