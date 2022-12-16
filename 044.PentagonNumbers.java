class PentagonNumbers {
  public static void main(String[] args) {
    for(long j = 1; j < 10000; j++)
      for(long k = j; k >= 1; k--) {
        long dif = ((j * (3 * j - 1)) / 2) - ((k * (3 * k - 1)) / 2);
        if(isPentagonal(((j*(3*j-1))/2) + ((k*(3*k-1))/2)) && isPentagonal(dif))
          System.out.println(dif);
      }
  }
  public static boolean isPentagonal(long n) {
    if(!isPerfectSquare(1 + 24*n)) return false;
    return Math.sqrt(1 + 24*n)%6 == 5;
  }
  public static boolean isPerfectSquare(long sq) {
    long h = (long)Math.ceil(Math.sqrt(sq)) + 1;
    long l = (long)Math.floor(Math.sqrt(sq)) - 1;
    for(long n = l; n <= h; n++) if(n*n == sq) return true;
    return false;
  }
}
