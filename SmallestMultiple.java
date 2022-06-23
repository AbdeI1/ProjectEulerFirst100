import java.io.*;
import java.util.*;

public class SmallestMultiple {
  public static void main(String[] args) {
    int n = 20;
    List<Integer> primes = sieve(20);
    int prod = 1;
    for(int p : primes) {
      int t = p;
      while(t < n) {
        prod *= p;
        t *= p;
      }
    }
    System.out.println(prod);
  }
  public static List<Integer> sieve(double x) {
    int n = (int)Math.ceil(x) + 1;
    boolean[] isNotPrime = new boolean[n];
    List<Integer> primes = new ArrayList<>();
    for(int i = 2; i < n; i++) {
      if(isNotPrime[i]){ continue; }
      primes.add(i);
      for(int j = 2*i; j < n; j += i) {
        isNotPrime[j] = true;
      }
    }
    return primes;
  }
}
