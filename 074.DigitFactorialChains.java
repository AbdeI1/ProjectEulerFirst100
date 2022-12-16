class DigitFactorialChains {
  public static int[] finish;
  public static final int[] FAC = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
  public static void main(String[] args) {
    int n = 10_000_000;
    finish = new int[n];
    finish[169] = finish[1454] = finish[363601] = 3;
    finish[871] = finish[45361] = 2;
    finish[872] = finish[45362] = 2;
    finish[1] = finish[2] = finish[145] = finish[40585] = 1;
    int count = 0;
    for(int i = 0; i < 1_000_000; i++) {
      if(howMany(i) == 60) { count++; }
    }
    System.out.println(count);
  }
  public static int howMany(int x) {
    if(finish[x] != 0) { return finish[x]; }
    return finish[x] = 1 + howMany(sumOfDigitsFactorial(x));
  }
  public static int sumOfDigitsFactorial(int x) {
    return (x + "").chars().map(c -> c - '0').map(i -> FAC[i]).sum();
  }
}
