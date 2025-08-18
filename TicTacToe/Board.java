public class Board {
    private final int size;
    private final char[][] board;

    public Board(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Board size must be >= 2");
        }
        this.size = size;
        this.board = new char[size][size];
    }

    public boolean addSymbol(int x, int y, char symbol) {
        if (symbol == '\0') {
            throw new IllegalArgumentException("Invalid symbol: cannot be null-character");
        }
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return false;
        }
        if (board[x][y] != '\0') {
            return false;
        }
        board[x][y] = symbol;
        return true;
    }

    public boolean checkWin() {
        return checkRowWin() || checkColWin() || checkDiagWin();
    }

    public int getSize() {
        return this.size;
    }

    public void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char c = board[i][j];
                System.out.print((c == '\0' ? '-' : c) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean checkRowWin() {
        for (int i = 0; i < size; i++) {
            char first = board[i][0];
            if (first == '\0') continue;
            boolean win = true;
            for (int j = 1; j < size; j++) {
                if (board[i][j] != first) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkColWin() {
        for (int j = 0; j < size; j++) {
            char first = board[0][j];
            if (first == '\0') continue;
            boolean win = true;
            for (int i = 1; i < size; i++) {
                if (board[i][j] != first) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkDiagWin() {
        char first = board[0][0];
        boolean win = first != '\0';
        for (int i = 1; i < size && win; i++) {
            if (board[i][i] != first) {
                win = false;
            }
        }
        if (win) return true;

        first = board[0][size - 1];
        win = first != '\0';
        for (int i = 1; i < size && win; i++) {
            if (board[i][size - 1 - i] != first) {
                win = false;
            }
        }
        return win;
    }
}
