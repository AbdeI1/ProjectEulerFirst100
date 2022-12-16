import java.io.*;
import java.util.*;

class PathSumTwoWays {
  public static void main(String[] args) throws FileNotFoundException {
    var m = Arrays.stream(new Scanner(new File("p081_matrix.txt")).useDelimiter("\\Z").next().split("\n")).map(s -> s.split(",")).map(s -> Arrays.stream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    var dp = new int[m.length][m[0].length];
    for(int i = m.length-1; i >= 0; i--) {
      for(int j = m[i].length-1; j >= 0; j--) {
        if(i == m.length-1 && j == m[i].length-1) {
          dp[i][j] = m[i][j];
          continue;
        }
        dp[i][j] = Math.min(get(dp, i+1, j), get(dp, i, j+1)) + m[i][j];
      }
    }
    System.out.println(dp[0][0]);
  }
  public static int get(int[][] m, int i, int j) {
    if(i < 0 || j < 0 || i >= m.length || j >= m[i].length) {
      return 63993601;
    }
    return m[i][j];
  }
}
