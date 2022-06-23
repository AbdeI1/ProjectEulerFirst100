import java.util.*;

public class AmicableNumbers {
  public static void main(String[] args) {
    int sum = 0;
    for(int i = 2; i < 10_000; i++)
      if(getDivisors(getDivisors(i).stream().mapToInt(Integer::intValue).sum()).stream().mapToInt(Integer::intValue).sum() == i && getDivisors(i).stream().mapToInt(Integer::intValue).sum() != i) sum += i;
    System.out.println(sum);
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
