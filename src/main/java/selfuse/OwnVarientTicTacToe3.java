
package selfuse;

import java.util.*;

public class OwnVarientTicTacToe3 {
    
    public static void main(String[] args) {
        UltimateTicTacToe game = new UltimateTicTacToe();
        game.play();
    }
}

class UltimateTicTacToe {
    private boolean gameOver;
    private static final int BOARD_SIZE = 9;
    private static final int SMALL_BOARD_SIZE = 3;

    private char[][] board;
    private int activeSmallBoardRow;
    private int activeSmallBoardCol;
    private char currentPlayer;

    public UltimateTicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        activeSmallBoardRow = -1;
        activeSmallBoardCol = -1;
        currentPlayer = 'X'; // 'X' plays first
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!hasPlayerWonLargeBoard(currentPlayer)) {
            displayBoard();

            if (activeSmallBoardRow == -1 && activeSmallBoardCol == -1) {
                System.out.print("Enter the row and column of the small board you want to play in (e.g., 0 0): ");
                int smallBoardRow = scanner.nextInt();
                int smallBoardCol = scanner.nextInt();
                setActiveSmallBoard(smallBoardRow, smallBoardCol);
            }

            System.out.print("Enter the row and column to make a move in the active small board (e.g., 0 0): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            makeMove(row, col);

            togglePlayer();
        }

        displayBoard();
        declareWinner();

        scanner.close();
    }
private void setActiveSmallBoard(int smallBoardRow, int smallBoardCol) {
            Scanner scanner = new Scanner(System.in);

    if (isValidSmallBoard(smallBoardRow, smallBoardCol) && !isSmallBoardFull(smallBoardRow, smallBoardCol)
            && (activeSmallBoardRow == -1 || isSmallBoardFull(activeSmallBoardRow, activeSmallBoardCol))) {
        activeSmallBoardRow = smallBoardRow;
        activeSmallBoardCol = smallBoardCol;
    } else {
        System.out.println("Invalid small board selection. Please choose again.");
        System.out.print("Enter the row and column of the small board you want to play in (e.g., 0 0): ");
        setActiveSmallBoard(scanner.nextInt(), scanner.nextInt());
    }
}

//private void makeMove(int row, int col) {
//    if (isValidMove(row, col)) {
//        int largeRow = activeSmallBoardRow * SMALL_BOARD_SIZE + row;
//        int largeCol = activeSmallBoardCol * SMALL_BOARD_SIZE + col;
//        board[largeRow][largeCol] = currentPlayer;
//        checkAndUpdateLargeBoard(activeSmallBoardRow, activeSmallBoardCol);
//        if (board[row][col] == '\0') {
//            activeSmallBoardRow = row;
//            activeSmallBoardCol = col;
//        } else {
//            activeSmallBoardRow = -1;
//            activeSmallBoardCol = -1;
//        }
//    } else {
//        System.out.println("Invalid move. Please try again.");
//    }
//}
private void makeMove(int row, int col) {
    if (isValidMove(row, col)) {
        int largeRow = activeSmallBoardRow * SMALL_BOARD_SIZE + row;
        int largeCol = activeSmallBoardCol * SMALL_BOARD_SIZE + col;
        board[largeRow][largeCol] = currentPlayer;
        checkAndUpdateLargeBoard(activeSmallBoardRow, activeSmallBoardCol);

        activeSmallBoardRow = largeRow % SMALL_BOARD_SIZE;
        activeSmallBoardCol = largeCol % SMALL_BOARD_SIZE;

        if (board[activeSmallBoardRow * SMALL_BOARD_SIZE][activeSmallBoardCol * SMALL_BOARD_SIZE] != '\0') {
            activeSmallBoardRow = getNextSmallBoardRow(largeRow);
            activeSmallBoardCol = getNextSmallBoardCol(largeCol);
        }

    } else {
        System.out.println("Invalid move. Please try again.");
    }
}

private boolean isValidMove(int row, int col) {
    int largeRow = activeSmallBoardRow * SMALL_BOARD_SIZE + row;
    int largeCol = activeSmallBoardCol * SMALL_BOARD_SIZE + col;
    return largeRow >= 0 && largeRow < BOARD_SIZE && largeCol >= 0 && largeCol < BOARD_SIZE && board[largeRow][largeCol] == '\0';
}

    private boolean isActiveSmallBoard(int smallBoardRow, int smallBoardCol) {
        return smallBoardRow == activeSmallBoardRow && smallBoardCol == activeSmallBoardCol;
    }

    private void checkAndUpdateLargeBoard(int smallRow, int smallCol) {
        int smallBoardRow = smallRow / SMALL_BOARD_SIZE;
        int smallBoardCol = smallCol / SMALL_BOARD_SIZE;

        if (hasPlayerWonSmallBoard(currentPlayer, smallBoardRow, smallBoardCol)) {
            board[smallBoardRow][smallBoardCol] = currentPlayer;
            if (hasPlayerWonLargeBoard(currentPlayer)) {
                declareWinner();
                gameOver = true;
            }
        } else if (isSmallBoardFull(smallBoardRow, smallBoardCol)) {
            board[smallBoardRow][smallBoardCol] = 'T';
        }
    }

    private boolean hasPlayerWonSmallBoard(char player, int smallBoardRow, int smallBoardCol) {
        // Check rows
        for (int i = 0; i < SMALL_BOARD_SIZE; i++) {
            if (board[smallBoardRow * SMALL_BOARD_SIZE + i][smallBoardCol * SMALL_BOARD_SIZE] != player) {
                break;
            }
            if (i == SMALL_BOARD_SIZE - 1) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < SMALL_BOARD_SIZE; i++) {
            if (board[smallBoardRow * SMALL_BOARD_SIZE][smallBoardCol * SMALL_BOARD_SIZE + i] != player) {
                break;
            }
            if (i == SMALL_BOARD_SIZE - 1) {
                return true;
            }
        }

        // Check diagonals
        if (board[smallBoardRow * SMALL_BOARD_SIZE][smallBoardCol * SMALL_BOARD_SIZE] == player
                && board[smallBoardRow * SMALL_BOARD_SIZE + SMALL_BOARD_SIZE - 1][smallBoardCol * SMALL_BOARD_SIZE + SMALL_BOARD_SIZE - 1] == player) {
            return true;
        }

        if (board[smallBoardRow * SMALL_BOARD_SIZE + SMALL_BOARD_SIZE - 1][smallBoardCol * SMALL_BOARD_SIZE] == player
                && board[smallBoardRow * SMALL_BOARD_SIZE][smallBoardCol * SMALL_BOARD_SIZE + SMALL_BOARD_SIZE - 1] == player) {
            return true;
        }

        return false;
    }

    private boolean isGameOver() {
        return isBoardFull() || hasPlayerWonLargeBoard(currentPlayer);
    }

    private boolean isValidSmallBoard(int smallBoardRow, int smallBoardCol) {
        return smallBoardRow >= 0 && smallBoardRow < SMALL_BOARD_SIZE && smallBoardCol >= 0 && smallBoardCol < SMALL_BOARD_SIZE;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSmallBoardFull(int smallBoardRow, int smallBoardCol) {
        for (int row = smallBoardRow * SMALL_BOARD_SIZE; row < (smallBoardRow + 1) * SMALL_BOARD_SIZE; row++) {
            for (int col = smallBoardCol * SMALL_BOARD_SIZE; col < (smallBoardCol + 1) * SMALL_BOARD_SIZE; col++) {
                if (board[row][col] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasPlayerWonLargeBoard(char player) {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i += SMALL_BOARD_SIZE) {
            for (int j = 0; j < BOARD_SIZE; j += SMALL_BOARD_SIZE) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player) {
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < BOARD_SIZE; i += SMALL_BOARD_SIZE) {
            for (int j = 0; j < BOARD_SIZE; j += SMALL_BOARD_SIZE) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player) {
                    return true;
                }
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }

        return false;
    }

    private void togglePlayer() {
        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }

    private int getNextSmallBoardRow(int row) {
        return (row % SMALL_BOARD_SIZE) * SMALL_BOARD_SIZE;
    }

    private int getNextSmallBoardCol(int col) {
        return (col % SMALL_BOARD_SIZE) * SMALL_BOARD_SIZE;
    }
private void displayBoard() {
    System.out.println("\nBoard:");
    for (int i = 0; i < BOARD_SIZE; i++) {
        if (i % SMALL_BOARD_SIZE == 0) {
            System.out.println("-------------");
        }
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (j % SMALL_BOARD_SIZE == 0) {
                System.out.print("| ");
            }
            if (i / SMALL_BOARD_SIZE == activeSmallBoardRow && j / SMALL_BOARD_SIZE == activeSmallBoardCol) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            System.out.print(board[i][j] + " ");
        }
        System.out.println("|");
    }
    System.out.println("-------------");
}

    private void declareWinner() {
        System.out.println("Game Over");
        if (hasPlayerWonLargeBoard('X')) {
            System.out.println("Player X wins!");
        } else if (hasPlayerWonLargeBoard('O')) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
    private int[] findNextSmallBoard() {
    for (int row = 0; row < SMALL_BOARD_SIZE; row++) {
        for (int col = 0; col < SMALL_BOARD_SIZE; col++) {
            if (!isSmallBoardFull(row, col) && (row != activeSmallBoardRow || col != activeSmallBoardCol)) {
                return new int[]{row, col};
            }
        }
    }
    return null;  // No available small board
}

}
