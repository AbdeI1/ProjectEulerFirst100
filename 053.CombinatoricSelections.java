import java.math.BigInteger;

class CombinatoricSelections {
  public static void main(String[] args) {
    int count = 0;
    for(int n = 1; n <= 100; n++)
      for(int k = 0; k <= n; k++)
        if(exceedsOneMil(n, k))
          count++;
    System.out.println(count);
  }
  public static boolean exceedsOneMil(int n, int r) {
    BigInteger num = new BigInteger("1");
    for(int i = r+1; i <= n; i++)
      num = num.multiply(new BigInteger(i+""));
    BigInteger den = new BigInteger("1");
    for(int i = 1; i <= n-r; i++)
      den = den.multiply(new BigInteger(i+""));
    BigInteger res = num.divide(den);
    return res.compareTo(new BigInteger("1000000")) > 0;
  }
}
