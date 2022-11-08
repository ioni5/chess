package io.github.ioni5;

public class Chess {
    
    private Board board;

    private Player[] players;

    private Turn turn;

    public Chess() {
        board = new Board();
        players = new Player[]{
            new Player(Color.BLACK, board),
            new Player(Color.WHITE, board)
        };
        turn = new Turn(players);
    }

    public void start() {
        Console console = new Console();
        Player player;
        console.write("\n--CHESS--\n");
        do {
            board.show();
            player = turn.next();
            player.play();
        } while (!board.isCheckmate());
        console.write("\nCheckmate " + player.getName() + " wins!");
    }

}
