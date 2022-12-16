import java.math.BigInteger;

class PowerfulDigitSum {
  public static void main(String[] args) {
    int max = -1;
    for(int a = 0; a < 100; a++)
      for(int b = 0; b < 100; b++)
        max = Math.max(new BigInteger(a+"").pow(b).toString().chars().map(c -> c -'0').sum(), max);
    System.out.println(max);
  }
}
