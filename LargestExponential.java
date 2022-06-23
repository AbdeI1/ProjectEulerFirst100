import java.io.*;
import java.util.*;

public class LargestExponential {
  public static void main(String[] args) throws FileNotFoundException {
    int[][] exps = Arrays.stream(new Scanner(new File("p099_base_exp.txt")).useDelimiter("\\Z").next().split("\n")).map(s -> Arrays.stream(s.split(","))).map(s -> s.mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    int maxI = 0;
    for(int i = 1; i < exps.length; i++) {
      double p = Math.log(exps[maxI][0])*exps[maxI][1];
      double c = Math.log(exps[i][0])*exps[i][1];
      if(c > p) {
        maxI = i;
      }
    }
    System.out.println(maxI+1);
  }
}
