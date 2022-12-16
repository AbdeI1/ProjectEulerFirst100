import java.math.*;

class SquareRootDigitalExpansion {
  public static void main(String[] args) {
    int sum = 0;
    for(int i = 2; i < 100; i++) {
      if(i == 4 || i == 9 || i == 16 || i == 25 || i == 36 || i == 49 || i == 64 || i == 81) { continue; }
      BigDecimal D = new BigDecimal(new BigInteger(i + ""));
      BigDecimal d = D.sqrt(new MathContext(200));
      sum += d.toString().substring(0, 101).chars().filter(c -> c != '.').map(c -> c - '0').sum();
    }
    System.out.println(sum);
  }
}
