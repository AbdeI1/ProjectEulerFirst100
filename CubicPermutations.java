import java.util.*;
import java.util.stream.Collectors;

public class CubicPermutations {
  public static void main(String[] args) {
    Map<String, List<Long>> m = new HashMap<>();
    for(long i = 0;; i++) {
      long c = i*i*i;
      String k = (c+"").chars().map(d ->  d - '0').sorted().boxed().map(a -> (a+"")).collect(Collectors.joining(""));
      if(m.containsKey(k)) {
        m.get(k).add(c);
        if(m.get(k).size() >= 5) {
          System.out.println(m.get(k).get(0));
          break;
        }
      } else {
        List<Long> cs = new ArrayList<>();
        cs.add(c);
        m.put(k, cs);
      }
    }
  }
}
