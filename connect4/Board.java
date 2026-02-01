package connect4;

import com.sun.media.sound.InvalidDataException;

public class Board {
    private Color[][] board;
    private Integer row = 7;
    private Integer column = 6;
    private Integer range = 4;
    private int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}};

    Board(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        board = new Color[column][row];
    }

    boolean checkWinner(Player player) {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (checkLeft(player, i, j) ||
                        checkRight(player, i, j) ||
                        checkTop(player, i, j) ||
                        checkBottom(player, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkBottom(Player player, Integer i, Integer j) {
        if (j - range < 0) {
            return false;
        }
        return getSum(i, j, player, directions[0]);
    }

    private boolean getSum(Integer i, Integer j, Player player, int[] direction) {
        int sum = 0;
        for (int x = 0; x < range; x++) {
            sum += equalsColor(x * direction[0] + i, x * direction[1] + j, player.getColor()) ? 1 : 0;
        }
        return sum == range;
    }

    private boolean checkTop(Player player, Integer i, Integer j) {
        if (j + range >= column) {
            return false;
        }
        return getSum(i, j, player, directions[1]);
    }

    private boolean checkRight(Player player, Integer i, Integer j) {
        if (i + range >= row) {
            return false;
        }
        return getSum(i, j, player, directions[2]);
    }

    private boolean checkLeft(Player player, Integer i, Integer j) {
        if (i - range < 0) {
            return false;
        }
        return getSum(i, j, player, directions[3]);
    }

    void move(Player player, Integer col) throws InvalidDataException {
        validateMove(player, col);
        if (!setColor(col, player)) {
            throw new InvalidDataException("Invalid input");
        }

    }

    private boolean setColor(Integer col, Player player) {
        for (int i = 0; i < row; i++) {
            if (board[col][i] == null) {
                board[col][i] = player.getColor();
                return true;
            }
        }
        return false;
    }

    private void validateMove(Player player, Integer column) throws InvalidDataException {
        if (column >= this.column || column < 0)
            throw new InvalidDataException("Invalid Column");

        if (player == null || column == null || player.getColor() == null)
            throw new InvalidDataException("Invalid Input");

        if (isFull(column))
            throw new InvalidDataException("Invalid move");

    }

    private boolean isFull(Integer column) {
        return board[column][row - 1] != null;
    }

    private boolean equalsColor(Integer i, Integer j, Color color) {
        if (color == null) return false;
        return color.equals(this.board[i][j]);
    }

    public void printBoard() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
