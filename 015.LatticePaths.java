import java.math.BigInteger;

class LatticePaths {
  public static void main(String[] args) {
    int n = 20;
    BigInteger res = new BigInteger("1");
    for(int i = 1; i <= 2*n; i++) res = res.multiply(new BigInteger(i+""));
    for(int j = 0; j < 2; j++) for(int i = 1; i <= n; i++) res = res.divide(new BigInteger(i+""));
    System.out.println(res);
  }
}
