import java.io.*;
import java.util.*;

public class PasscodeDerivation {
  public static void main(String[] args) throws FileNotFoundException {
    var a = Arrays.stream(new Scanner(new File("p079_keylog.txt")).useDelimiter("\\Z").next().split("\n")).map(s -> s.chars().map(c -> c - '0').toArray()).toArray(int[][]::new);
    int[][] after = new int[10][10];
    for(var b : a) {
      after[b[0]][b[1]]++;
      after[b[0]][b[2]]++;
      after[b[1]][b[2]]++;
    }
    int[][] an = new int[10][2];
    for(int i = 0; i < 10; i++) {
      an[i][0] = i;
      an[i][1] = (int)Arrays.stream(after[i]).filter(n -> n != 0).count();
    }
    Arrays.sort(an, Comparator.comparingInt(o -> o[1]));
    StringBuilder s = new StringBuilder();
    for(var x : an) {
      int count = 0;
      for(int i = 0; i < 10; i++) {
        count += after[i][x[0]];
      }
      if(count != 0 || x[1]  > 0) {
        s.insert(0, x[0]);
      }
    }
    System.out.println(s);
  }
}
