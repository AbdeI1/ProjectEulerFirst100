import java.io.*;
import java.util.*;

class MaximumPathSumII {
  public static void main(String[] args) throws FileNotFoundException {
    var tri = Arrays.stream(new Scanner(new File("p067_triangle.txt")).useDelimiter("\\Z").next().split("\n")).filter(s -> s.length() > 0).map(s -> Arrays.stream(s.split(" "))).map(s -> s.mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    for(int i = tri.length-2; i >= 0; i--)
      for(int j = 0; j < tri[i].length; j++)
        tri[i][j] += Math.max(tri[i+1][j], tri[i+1][j+1]);
    System.out.println(tri[0][0]);
  }
}
