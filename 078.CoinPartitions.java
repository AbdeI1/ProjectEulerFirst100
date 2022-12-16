class CoinPartitions {
  public static long[] ps;
  public static long[] psM;
  public static void main(String[] args) {
    int n = 100000;
    ps = new long[n];
    psM = new long[n];
    ps[0] = 1; psM[0] = 1;
    for(int i = 0; i < n; i++) {
      long p = pMod(i, 1_000_000);
      if(p == 0) {
        System.out.println(i);
        break;
      }
    }
  }
  public static long pMod(int n, int M) {
    if(psM[n] != 0) { return psM[n]; }
    if(n == 0) { return 1; }
    long S = 0; int J = n-1; int k = 2;
    while(0 <= J) {
      long T = pMod(J, M);
      S = ((k/2)%2 == 1) ? S+T : S-T;
      S = S < M ? S + M : S%M;
      J -= k%2 == 1 ? k : k/2;
      k++;
    }
    psM[n] = S;
    return S;
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
