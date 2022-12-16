import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PandigitalMultiples {
  public static void main(String[] args) {
    int max = -1;
    for(int i = 0; i < 10_000; i++) {
      for(int j = 2; j < 10; j++) {
        int finalI = i;
        if(IntStream.rangeClosed(1, j).map(n -> finalI*n).boxed().map(n -> n+"").collect(Collectors.joining("")).chars().sorted().map(c -> c-'0').boxed().map(n -> n+"").collect(Collectors.joining("")).equals("123456789"))
          max = Math.max(max, Integer.parseInt(IntStream.rangeClosed(1, j).map(n -> finalI*n).boxed().map(n -> n+"").collect(Collectors.joining(""))));
      }
    }
    System.out.println(max);
  }
}
