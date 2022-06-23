import java.util.*;
import java.util.stream.IntStream;

public class DigitFifthPowers {
  public static void main(String[] args) {
    System.out.println(IntStream.range(2, 1_000_000).filter(i -> i == (i+"").chars().map(c -> c - '0').map(c -> c*c*c*c*c).sum()).sum());
  }
}
