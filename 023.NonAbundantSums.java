import java.util.*;
import java.util.stream.IntStream;

class NonAbundantSums {
  public static void main(String[] args) {
    Set<Integer> abundants = new HashSet<>();
    for(int i = 2; i <= 28123; i++)
      if(getDivisors(i).stream().mapToInt(Integer::intValue).sum() > i)
        abundants.add(i);
    boolean[] canBe = new boolean[28124];
    for(int a : abundants)
      for(int b : abundants)
        if(a+b < canBe.length)
          canBe[a+b] = true;
    System.out.println(IntStream.range(0, canBe.length).boxed().map(i -> new int[]{canBe[i] ? 1 : 0, i}).filter(b -> b[0]==0).mapToInt(o -> o[1]).sum());
  }
  public static Set<Integer> getDivisors(int n) {
    Set<Integer> divs = new HashSet<>();
    divs.add(1);
    for(int i = 2; i*i <= n; i++) {
      if(n%i == 0) {
        divs.add(i);
        divs.add(n/i);
      }
    }
    return divs;
  }
}
