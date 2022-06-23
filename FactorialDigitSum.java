import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialDigitSum {
  public static void main(String[] args) {
    System.out.println(IntStream.rangeClosed(2, 100).boxed().map(i -> new BigInteger(i+"")).reduce(new BigInteger("1"), BigInteger::multiply).toString().chars().map(c ->  c-'0').sum());
  }
}
