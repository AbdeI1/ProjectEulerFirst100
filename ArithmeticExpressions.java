import java.io.*;
import java.util.*;

public class ArithmeticExpressions {
  public static char[] OPs = {'+', '-', '*', '/'};
  public static void main(String[] args) {
    int max = -1;
    for(int num1 = 1; num1 < 10; num1++) {
      for(int num2 = num1+1; num2 < 10; num2++) {
        for (int num3 = num2 + 1; num3 < 10; num3++) {
          for (int num4 = num3 + 1; num4 < 10; num4++) {
            int[] digits = {num1, num2, num3, num4};
            boolean[] used = new boolean[4];
            Stack<Double> cur = new Stack<>();
            Set<Double> res = count(digits, 0, cur, used, 4);
            int[] a = res.stream().filter(d -> d > 0 && Math.abs(d - d.intValue()) < 1e-5).mapToInt(Double::intValue).sorted().toArray();
            for (int i = 0; i < a.length; i++) {
              if (a[i] != i + 1) {
                if(i > max) {
                  max = i;
                  System.out.println(Arrays.toString(digits));
                  System.out.println(Arrays.toString(a));
                  System.out.println(i);
                }
                break;
              }
            }
          }
        }
      }
    }
  }
  public static Set<Double> count(int[] digits, int numOps, Stack<Double> cur, boolean[] used, int rem) {
    Set<Double> res = new HashSet<>();
    if(rem == 0) {
      if(numOps == 3) {
        res.add(cur.peek());
      } else {
        for(char op : OPs) {
          double a = cur.pop();
          double b = cur.pop();
          if(op == '/' && b == 0) { continue; }
          double c = 0;
          switch(op) {
            case '+' -> c = a + b;
            case '-' -> c = a - b;
            case '*' -> c = a*b;
            case '/' -> c = a/b;
          }
          cur.push(c);
          res.addAll(count(digits, numOps + 1, cur, used, rem));
          cur.pop();
          cur.push(b);
          cur.push(a);
        }
      }
      return res;
    }
    for(int i = 0; i < 4; i++) {
      if(used[i]) { continue; }
      used[i] = true;
      cur.push((double)digits[i]);
      res.addAll(count(digits, numOps, cur, used, rem-1));
      cur.pop();
      used[i] = false;
    }
    if(cur.size() > 2) {
      for(char op : OPs) {
        double a = cur.pop();
        double b = cur.pop();
        if(op == '/' && b == 0) { continue; }
        double c = 0;
        switch(op) {
          case '+' -> c = a + b;
          case '-' -> c = a - b;
          case '*' -> c = a*b;
          case '/' -> c = a/b;
        }
        cur.push(c);
        res.addAll(count(digits, numOps + 1, cur, used, rem));
        cur.pop();
        cur.push(b);
        cur.push(a);
      }
    }
    return res;
  }
}
