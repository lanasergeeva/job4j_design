package ru.job4j.ood.tictactoe;

public class PlayersQueue implements QueueInterface {
    private int player;

    public PlayersQueue() {
        this.player = 0;
    }

    public void nextPlayer() {
        player = (byte) (1 == player ? 2 : 1);
    }

    public int getPlayer() {
        return player;
    }

}
