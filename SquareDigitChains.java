public class SquareDigitChains {
  public static int[] finish;
  public static void main(String[] args) {
    int n = 10_000_000;
    finish = new int[n];
    finish[0] = -1;
    finish[1] = 1;
    finish[89] = 89;
    int count = 0;
    for(int i = 0; i < n; i++) {
      if(findFinish(i) == 89) { count++; }
    }
    System.out.println(count);
  }
  public static int findFinish(int x) {
    if(finish[x] != 0) { return finish[x]; }
    return finish[x] = findFinish(sumOfDigitsSquared(x));
  }
  public static int sumOfDigitsSquared(int x) {
    return (x + "").chars().map(c -> c - '0').map(i -> i*i).sum();
  }
}
