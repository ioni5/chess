package io.github.ioni5;

public class Turn {

    private Player[] players;

    private int curr;

    public Turn(Player[] players) {
        this.players = players;
    }

    public Player next() {
        curr = (curr + 1) % players.length;
        return players[curr];
    }

}
