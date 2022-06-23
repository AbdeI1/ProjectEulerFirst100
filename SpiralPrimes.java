public class SpiralPrimes {
  public static void main(String[] args) {
    long c = 1;
    long t = 1; long p = 0;
    for(int i = 2;; i += 2) {
      for(int j = 0; j < 4; j++) {
        c += i;
        if(isPrime(c)) p++;
        t++;
      }
      if(t%10 == 0 ? p < t/10 : p <= t/10) {
        System.out.println(i+1);
        break;
      }
    }
  }
  public static boolean isPrime(long n) {
    long stop = (long)Math.ceil(Math.sqrt(n));
    for(long i = 2; i <= stop; i++)
      if(n%i == 0)
        return false;
    return true;
  }
}
