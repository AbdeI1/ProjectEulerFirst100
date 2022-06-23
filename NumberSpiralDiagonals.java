public class NumberSpiralDiagonals {
  public static void main(String[] args) {
    long c = 1; long sum = 1;
    for(int i = 2; i < 1001; i += 2) {
      for(int j = 0; j < 4; j++) {
        c += i;
        sum += c;
      }
    }
    System.out.println(sum);
  }
}
