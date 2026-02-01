package connect4;

import com.sun.media.sound.InvalidDataException;

import java.util.Scanner;

public class Game {

    private final Board board;
    private Player currentPlayer;
    private final Player playerA;
    private final Player playerB;

    public Game() {
        this.board = new Board(7, 6);
        this.playerA = Player.builder()
                .name("A")
                .color(Color.BLUE)
                .build();
        this.playerB = Player.builder()
                .name("B")
                .color(Color.YELLOW)
                .build();
        this.currentPlayer = playerA;

    }

    public void execute() throws InvalidDataException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(String.format("Player %s: Enter the move", currentPlayer.getName()));
            int col = scanner.nextInt();
            board.move(currentPlayer, col);
            board.printBoard();
            if (board.checkWinner(currentPlayer)) {
                System.out.println(String.format("Winner Player %s", currentPlayer.getName()));
                break;
            }

            if (currentPlayer.equals(playerA)) {
                currentPlayer = playerB;

            } else {
                currentPlayer = playerA;
                board.checkWinner(playerB);
            }
        }
    }
}
