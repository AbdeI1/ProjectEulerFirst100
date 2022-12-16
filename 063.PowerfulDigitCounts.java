import java.math.BigInteger;

class PowerfulDigitCounts {
  public static void main(String[] args) {
    int count = 0;
    int p = 1;
    while(true) {
      BigInteger B = new BigInteger("9");
      while(true) {
        BigInteger P = B.pow(p);
        var d = P.toString().length();
        if(d < p || B.toString().equals("0")) {
          break;
        }
        if(d == p) {
          count++;
        }
        B = B.subtract(new BigInteger("1"));
      }
      if(B.toString().equals("9")) {
        break;
      }
      p++;
    }
    System.out.println(count);
  }
}
