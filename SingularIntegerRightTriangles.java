import java.util.*;
import java.util.stream.Collectors;

public class SingularIntegerRightTriangles {
  public static void main(String[] args) {
    int L = 1_500_000;
    int[] c = new int[L+1];
    Set<List<Long>> trips = new HashSet<>();
    for(long n = 1; n < 100_000; n++) {
      for(long m = n+1; m < 100_000; m++) {
        long p = 2*m*m + 2*n*m;
        long q = 1;
        while(q*p <= L) {
          List<Long> trip = Arrays.stream(new long[]{q * (m * m - n * n), 2 * n * q * m, q * (n * n + m * m)}).boxed().sorted().collect(Collectors.toList());
          if(trips.contains(trip)) { q++; continue; }
          trips.add(trip);
          c[(int)(q*p)]++;
          q++;
        }
      }
    }
    System.out.println(Arrays.stream(c).filter(i -> i==1).count());
  }
}
