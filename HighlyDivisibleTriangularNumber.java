import java.util.*;

public class HighlyDivisibleTriangularNumber {
  public static void main(String[] args) {
    long tri = 0;
    for(long i = 1; i < 10000000; i++) {
      int count = 0;
      tri += i;
      for(long j = 1; j * j < tri; j++) {
        if(tri%j == 0) {
          count++;
        }
      }
      if(count*2 >= 500) {
        System.out.println(tri);
        break;
      }
    }
  }
}
