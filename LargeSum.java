import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class LargeSum {
  public static void main(String[] args) throws FileNotFoundException {
    var nums = Arrays.stream(new Scanner(new File("p013_numbers.txt")).useDelimiter("\\Z").next().split("\r\n")).map(BigInteger::new).toArray(BigInteger[]::new);
    BigInteger sum = new BigInteger("0");
    for(var n : nums) sum = sum.add(n);
    System.out.println(sum.toString().substring(0,10));
  }
}
