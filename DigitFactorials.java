import java.util.*;
import java.util.stream.IntStream;

public class DigitFactorials {
  public static final int[] FAC = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
  public static void main(String[] args) {
    System.out.println(IntStream.range(3, 10_000_000).filter(i -> i == (i+"").chars().map(c -> FAC[c-'0']).sum()).sum());
  }
}
