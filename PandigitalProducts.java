import java.util.*;
import java.util.stream.Collectors;

public class PandigitalProducts {
  public static void main(String[] args) {
    Set<Integer> P = new HashSet<>();
    for(int a = 1; a < 10_000; a++)
      for(int b = 1; b < 10_000; b++)
        if((a + "" + b + "" + (a*b)).chars().sorted().map(c -> c-'0').boxed().map(i -> i+"").collect(Collectors.joining("")).equals("123456789"))
          P.add(a*b);
    System.out.println(P.stream().mapToInt(Integer::intValue).sum());
  }
}
