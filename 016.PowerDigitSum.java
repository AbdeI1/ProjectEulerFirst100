import java.math.BigInteger;

class PowerDigitSum {
  public static void main(String[] args) {
    System.out.println(new BigInteger("2").pow(1000).toString().chars().map(c -> c-'0').sum());
  }
}
