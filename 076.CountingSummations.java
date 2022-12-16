class CountingSummations {
  public static long[] ps;
  public static void main(String[] args) {
    int n = 100;
    ps = new long[n+1];
    System.out.println(p(n)-1);
  }
  public static long p(int n) {
    if(ps[n] != 0) { return ps[n]; }
    if(n == 0) { return 1; }
    long S = 0; int J = n-1; int k = 2;
    while(0 <= J) {
      long T = p(J);
      S = ((k/2)%2 == 1) ? S+T : S-T;
      J -= k%2 == 1 ? k : k/2;
      k++;
    }
    ps[n] = S;
    return S;
  }
}
