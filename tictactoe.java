import java.util.*;

public class tictactoe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        boolean gameover = false;
        char player = 'X';
        int c=0;

        while (!gameover) {
            displayBoard(board);
            System.out.println();
            System.out.println("Player " + player + ", it's your turn");
            System.out.println("ENTER ROW");
            int row = sc.nextInt();
            System.out.println("ENTER COLUMN");
            int col = sc.nextInt();
            System.out.println(c);
            if(c>=8){
                //displayBoard(board);
                System.out.println("GAME DRAW");
                break;
            }

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' '&&c<=8) {
                board[row][col] = player;
                c++;
                gameover = checkWin(board, player);

                if (gameover) {
                    System.out.println("Player " + player + " WON");
                    displayBoard(board);
                   break;
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        sc.close();
    }

    // Function to print the current state
    static void displayBoard(char[][] board) {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    static boolean checkWin(char[][] board, char player) {
        // Checking rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Checking columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Checking diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        } else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
