import java.io.*;
import java.util.*;

class LargestProductInGrid {
  public static void main(String[] args) throws FileNotFoundException {
    int[][] grid = Arrays.stream(new Scanner(new File("p011_grid.txt")).useDelimiter("\\Z").next().split("\r\n")).map(s -> Arrays.stream(s.split(" "))).map(a -> a.mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
    long max = 1;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid.length; j++) {
        for(int[] dir : DIRS) {
          long prod = get(grid, i, j, 0);
          for(int k = 1; k <= 3; k++) {
            prod *= get(grid, i + k*dir[0], j + k*dir[1], 0);
          }
          max = Math.max(max, prod);
        }
      }
    }
    System.out.println(max);
  }
  public static <T> int get(int[][] m, int i, int j, int d) {
    if(i < 0 || j < 0 || i >= m.length || j >= m[i].length){
      return d;
    }
    return m[i][j];
  }
}
