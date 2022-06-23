import java.math.BigInteger;
import java.util.*;

public class OneThousandDigitFibonacci {
  public static void main(String[] args) {
    List<BigInteger> fib = new ArrayList<>();
    fib.add(new BigInteger("0")); fib.add(new BigInteger("1"));
    for(int i = 2;; i++) {
      BigInteger n = fib.get(i-1).add(fib.get(i-2));
      if(n.toString().length() >= 1000) {
        System.out.println(i);
        break;
      }
      fib.add(n);
    }
  }
}
