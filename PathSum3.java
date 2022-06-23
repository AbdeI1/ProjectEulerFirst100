import java.io.*;
import java.util.*;

public class PathSum3 {
  public static void main(String[] args) throws FileNotFoundException {
    var m = Arrays.stream(new Scanner(new File("p081_matrix.txt")).useDelimiter("\\Z").next().split("\n")).map(s -> s.split(",")).map(s -> Arrays.stream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}};
    Set<Integer> v = new HashSet<>();
    PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    for(int i = 0; i < m.length; i++) {
      q.add(new int[]{m[i][0], i*m.length});
    }
    while(!q.isEmpty()) {
      int[] n = q.remove();
      if(v.contains(n[1])) { continue; }
      v.add(n[1]);
      if(n[1]%m.length == m.length-1) {
        System.out.println(n[0]);
        break;
      }
      int[] pos = new int[]{n[1]/m.length, n[1]%m.length};
      for(int[] d : DIRS) {
        int[] next = new int[]{pos[0] + d[0], pos[1] + d[1]};
        q.add(new int[]{n[0] + get(m, next[0], next[1]), next[0]*m.length + next[1]});
      }
    }
  }
  public static int get(int[][] m, int i, int j) {
    if(i < 0 || j < 0 || i >= m.length || j >= m[i].length) {
      return 63993601;
    }
    return m[i][j];
  }
}
