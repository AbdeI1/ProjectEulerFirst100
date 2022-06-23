import java.util.stream.IntStream;

public class ChampernownesConstant {
  public static void main(String[] args) {
    int N = 1_000_000;
    StringBuilder s = new StringBuilder();
    for(int i = 0; s.length() <= N; i++)
      s.append(i);
    System.out.println(IntStream.range(0, 7).map(i -> (int)Math.pow(10, i)).map(s::charAt).map(c -> c - '0').reduce(1, (a, b) -> a*b));
  }
}
