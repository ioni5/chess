package io.github.ioni5;

public abstract class Piece {

    protected Color color;

    private char symbol;

    public Piece(Color color, char[] symbols) {
        this.color = color;
        symbol = color == Color.BLACK ? symbols[0] : symbols[1];
    }

    public boolean isColor(Color color) {
        return this.color == color;
    }

    public abstract boolean isValidMove(Movement movement, boolean isClearpath);

    public void show() {
        Console console = new Console();
        console.write(symbol);
    }

    public abstract boolean isKing();

}
