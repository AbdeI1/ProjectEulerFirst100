import java.io.*;
import java.util.*;

public class SumSquareDifference {
  public static void main(String[] args) {
    int n = 100;
    int sum = (n*(n+1))/2;
    int sum2 = (n*(n+1)*(2*n+1))/6;
    System.out.println(Math.abs(sum2 - sum*sum));
  }
}
