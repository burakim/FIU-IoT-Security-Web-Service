package iotsecurity.models;

import org.springframework.data.annotation.Id;

/**
 * Created by Burak on 9/24/17.
 */
public class Student {
    @Id
    private int pantherId;
    private Board board;

    public int getPantherId() {
        return pantherId;
    }

    public void setPantherId(int pantherId) {
        this.pantherId = pantherId;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
