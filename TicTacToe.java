import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char current = 'X';

        System.out.println("Tic Tac Toe Game");
        printBoard();

        while (true) {
            System.out.println("Player " + current + " turn (row and col 1-3): ");
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            if (r < 0 || r > 2 || c < 0 || c > 2 || board[r][c] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            board[r][c] = current;
            printBoard();

            if (checkWin(current)) {
                System.out.println("Player " + current + " wins!");
                break;
            }
            if (isFull()) {
                System.out.println("It's a draw!");
                break;
            }

            current = (current == 'X') ? 'O' : 'X';
        }
        sc.close();
    }
}
