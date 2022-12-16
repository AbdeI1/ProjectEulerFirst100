import java.math.BigInteger;
import java.util.*;

class DistinctPowers {
  public static void main(String[] args) {
    Set<String> s = new HashSet<>();
    int n = 100;
    for(int a = 2; a <= n; a++)
      for(int b = 2; b <= n; b++)
        s.add(new BigInteger(a+"").pow(b).toString());
    System.out.println(s.size());
  }
}
