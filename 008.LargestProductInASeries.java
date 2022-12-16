import java.io.*;
import java.util.*;

class LargestProductInASeries {
  public static void main(String[] args) throws FileNotFoundException {
    int[] a = new Scanner(new File("p008_number.txt")).nextLine().chars().map(c -> c - '0').toArray();
    long prod = 1;
    for(int i = 0; i < 13; i++) {
      prod *= a[i];
    }
    long max = prod;
    for(int i = 13; i < a.length; i++) {
      if(a[i-13] == 0) {
        prod = 1;
        for(int j = i-12; j < i; j++) {
          prod *= a[j];
        }
      } else { prod /= a[i-13]; }
      prod *= a[i];
      max = Math.max(max, prod);
    }
    System.out.println(max);
  }
}