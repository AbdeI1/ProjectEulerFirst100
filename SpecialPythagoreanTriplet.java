import java.io.*;
import java.util.*;

public class SpecialPythagoreanTriplet {
  public static void main(String[] args) {
    int p = 1000;
    for(int a = 0; a < p; a++) {
      for(int b = a+1; b < p && p-a > 2*b; b++) {
        int c = p - a - b;
        if(a*a + b*b == c*c) {
          System.out.println(a + " " + b + " " + c + ": " + a*b*c);
        }
      }
    }
  }
}
