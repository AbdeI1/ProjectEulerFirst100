import java.io.*;
import java.util.*;

class SuDoku {
  public static void main(String[] args) throws FileNotFoundException {
    var grids = Arrays.stream(new Scanner(new File("p096_sudoku.txt")).useDelimiter("\\Z").next().split("Grid ")).filter(s -> s.length() > 1).map(s -> s.substring(3).split("\n")).map(Arrays::stream).map(s -> s.map(String::chars).map(st -> st.filter(c -> c != '\n').map(c -> c - '0').toArray()).toArray(int[][]::new)).toArray(int[][][]::new);
    int ans = 0;
    for(int[][] b : grids) {
      solver(b);
      ans += b[0][0]*100 + b[0][1]*10 + b[0][2];
    }
    System.out.println(ans);
  }
  public static boolean solver(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == 0){
          HashSet<Integer> p = findPossible(board, i, j);
          for(int num : p){
            board[i][j] = num;
            if(solver(board)){
              return true;
            }
          }
          board[i][j] = 0;
          return false;
        }
      }
    }
    return true;
  }
  public static HashSet<Integer> findPossible(int[][] board, int r, int c){
    HashSet<Integer> possible = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(i == r || j == c || i/3 == r/3 && j/3 == c/3){possible.remove(board[i][j]);}
      }
    }
    return possible;
  }
}
