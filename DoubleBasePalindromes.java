import java.util.stream.IntStream;

public class DoubleBasePalindromes {
  public static void main(String[] args) {
    System.out.println(IntStream.range(0, 1_000_000).filter(i -> (i+"").equals(new StringBuilder(i+"").reverse().toString()) && Integer.toBinaryString(i).equals(new StringBuilder(Integer.toBinaryString(i)).reverse().toString())).sum());
  }
}
