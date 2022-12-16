import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LexicographicPermutations {
  public static void main(String[] args) {
    int n = 1_000_000;
    n--;
    int f = IntStream.range(1, 11).reduce(1, (i, j) -> i*j);
    List<Integer> l = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    StringBuilder s = new StringBuilder();
    for(int i = 10; i >= 1; i--) {
      f /= i;
      int j = l.get(n/f);
      l.remove(Integer.valueOf(j));
      s.append(j);
      n %= f;
    }
    System.out.println(s);
  }
}
