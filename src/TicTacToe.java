
import java.util.*;
class Board{
    private char[][] board;
public Board(){
    board = new char[3][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = ' ';
        }
    }
}

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public char[][] getBoard() {
        return board;
    }


    public boolean placeMark(int row, int col, char player) {
        if (board[row][col] == ' ') {
            board[row][col] = player;
            return true;
        }
        return false;
    }



}
 class Game{
     private Board board;
     private char currentPlayer;
     private Scanner scanner;


     public Game() {
         board = new Board();
         currentPlayer = 'X';
         scanner = new Scanner(System.in);
     }


     public void start(){
         boolean gameOver = false;

         while (!gameOver) {
             playerMove();

             if (checkWin()) {
                 board.printBoard();
                 System.out.println("Player " + currentPlayer + " wins!");
                 gameOver = true;
             } else if (checkDraw()) {
                 board.printBoard();
                 System.out.println("Game is a draw!");
                 gameOver = true;
             } else {
                 switchPlayer();
             }
         }
     }

     private void playerMove(){

         int row, col;
         while(true) {
             System.out.println("Player " + currentPlayer + ", enter row (0-2): ");
             row = scanner.nextInt();

             System.out.println("Player " + currentPlayer + ", enter column (0-2): ");
             col = scanner.nextInt();

             if (board.placeMark(row, col, currentPlayer)) {
                 break;
             } else {
                 System.out.println("Invalid move. Try again.");
             }


         }
     }
     private boolean checkWin(){
         char[][] b = board.getBoard();

         for (int i = 0; i < 3; i++) {
             if (b[i][0] == currentPlayer &&
                     b[i][1] == currentPlayer &&
                     b[i][2] == currentPlayer) {
                 return true;
             }
         }

         // columns
         for (int j = 0; j < 3; j++) {
             if (b[0][j] == currentPlayer &&
                     b[1][j] == currentPlayer &&
                     b[2][j] == currentPlayer) {
                 return true;
             }
         }


         if (b[0][0] == currentPlayer &&
                 b[1][1] == currentPlayer &&
                 b[2][2] == currentPlayer) {
             return true;
         }

         if (b[0][2] == currentPlayer &&
                 b[1][1] == currentPlayer &&
                 b[2][0] == currentPlayer) {
             return true;
         }

         return false;
     }
     private  boolean checkDraw(){
         char[][] b = board.getBoard();

         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 if (b[i][j] == ' ') {
                     return false;
                 }
             }
         }
         return true;
     }
     private void switchPlayer() {
         if (currentPlayer == 'X') {
             currentPlayer = 'O';
         } else {
             currentPlayer = 'X';
         }
     }

 }
public class TicTacToe {
public static  void main(String args[]){
Game game=new Game();
game.start();
}
}
