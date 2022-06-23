public class LongetsCollatzSequences {
  public static int[] Collatz;
  public static void main(String[] args) {
    Collatz = new int[1_050_000_000];
    Collatz[1] = 1;
    int maxI = 1;
    for(int i = 1; i < 1_000_000; i++)
      if(collatz(i) > collatz(maxI))
        maxI = i;
    System.out.println(maxI);
  }
  public static int collatz(long n) {
    if(n >= Collatz.length) {
      return (n%2 == 0 ? collatz(n/2) : collatz(3*n+1 )) + 1;
    }
    if(Collatz[(int)n] != 0) return Collatz[(int)n];
    return Collatz[(int)n] = (n%2 == 0 ? collatz(n/2) : collatz(3*n+1 )) + 1;
  }
}
