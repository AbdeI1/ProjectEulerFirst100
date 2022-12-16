import java.util.*;
import java.util.stream.Collectors;

class PermutedMultiples {
  public static void main(String[] args) {
    int h = 6;
    first:
    for(int y =1;; y++) {
      long end = Long.parseLong("1" + "6".repeat(y));
      long start = Long.parseLong("1" + "0".repeat(y));
      second:
      for(long x = start; x <= end; x++) {
        long[] muls = new long[h];
        for (int i = 0; i < h; i++)
          muls[i] = x * (i + 1);
        String s = muls[0] + "";
        for (int i = 1; i < h; i++) {
          Set<Integer> nums = s.chars().map(c -> c - '0').boxed().collect(Collectors.toSet());
          for (char c : (muls[i] + "").toCharArray())
            if (!nums.contains(c - '0')) continue second;
            else nums.remove(c - '0');
        }
        System.out.println(x);
        break first;
      }
    }
  }
}
