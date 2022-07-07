import java.io.*;
import java.util.*;

/**
 * Conway's Game of Life by Team AreWeSentientYet?
 * First Last
 * collaborators: First Last, First Last
 */

/**
   The Rules of Life:

   Survivals:
   * A living cell with 2 or 3 living neighbours will survive for the next generation.

   Deaths:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.

   Births:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.

   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation.
*/

public class Cgol
{

  //create, initialize, and return  empty board (all cells dead)
  public static char[][] createNewBoard( int rows, int cols )
  {
    char[][] newBoard = new char[rows][cols];
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        newBoard[i][j] = 'O';
      }
    }
    return newBoard;
  }


  //print the board to the terminal
  public static void printBoard( char[][] board )
  {
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }


  //set cell (r,c) to val
  public static void setCell( char[][] board, int r, int c, char val )
  {
    if(r>=0 && r<board.length && c >=0 && c < board[0].length)    {
      board[r][c] = val;
    }
  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours( char[][] board, int r, int c )
  {
        int result = 0;
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j< board[0].length; j++){
            if(i == r && j == c){
              continue;
            }
              //Checks if the cell is a neighbor
            else if((i>=r-1 && i<=r+1) && (j>=c-1 && j<=c+1)){
              //checks if the cell is alive
              if(board[i][j] == 'X'){
                
               result++;
                
            }
            }
        }
        }
    return result;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell( char[][] board,int r, int c )
  {
        int numNeighbor = countNeighbours(board, r, c);
        char result = 'Z';
        if(board[r][c] == 'X'){
          if(numNeighbor == 2 || numNeighbor == 3){
            result = 'X';
          }
          else if(numNeighbor > 3 || numNeighbor < 2){
            result = 'O';
          }
        }
        else if(board[r][c] == 'O'){
          if(numNeighbor == 3){
            result = 'X';
          }
          else{
            result = 'O';
          }
        }
        
      return result;
        
  }


  //generate and return a new board representing next generation
  public static char[][] generateNextBoard( char[][] board )
  {
      char[][] getNewBoard = new char[board.length][board[0].length];
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++){
          getNewBoard[i][j] = getNextGenCell(board, i, j);
        }
      }
    return getNewBoard;
  }


  public static void main( String[] args )
  {
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    char[][] board;
    board = createNewBoard(5,5);
    printBoard(board);
    System.out.println();
    
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');
    // setCell(board, 3, 3, 'X');
    // setCell(board, 3, 4, 'X');
    // setCell(board, 4, 3, 'X');
    // setCell(board, 4, 4, 'X');
    // setCell(board, 2, 2, 'X');
    
    printBoard(board);
    System.out.println();

    int numNeighbor = countNeighbours(board, 1, 1);
    System.out.println(numNeighbor + "\n");

    // char nextGent = getNextGenCell(board, 3, 4);
    // System.out.println(nextGent);
    
    char[][] nextGen = generateNextBoard(board);
    printBoard(nextGen);
  }//end main()

}//end class