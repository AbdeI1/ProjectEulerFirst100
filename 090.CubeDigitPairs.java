import java.util.*;

class CubeDigitPairs {
  public final static int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81};
  public static void main(String[] args) {
    List<int[]> combinations = generate(10, 6);
    int count = 0;
    for(int i = 0; i < combinations.size(); i++) {
      for(int j = i; j < combinations.size(); j++) {
        int[] a = combinations.get(i);
        int[] b = combinations.get(j);
        if(isPossible(a, b)){
          count++;
        }
      }
    }
    System.out.println(count);
  }
  public static boolean isPossible(int[] a, int[] b) {
    Set<Integer> seta = new HashSet<>();
    Set<Integer> setb = new HashSet<>();
    for(int i = 0; i < a.length; i++) {
      seta.add(a[i]);
      if(a[i] == 6) { seta.add(9); }
      if(a[i] == 9) { seta.add(6); }
      setb.add(b[i]);
      if(b[i] == 6) { setb.add(9); }
      if(b[i] == 9) { setb.add(6); }
    }
    for(int s : squares) {
      if((seta.contains(s%10) && setb.contains(s/10)) || (seta.contains(s/10) && setb.contains(s%10))) {
        continue;
      }
      return false;
    }
    return true;
  }
  public static void helper(List<int[]> combinations, int[] data, int start, int end, int index) {
    if (index == data.length) {
      int[] combination = data.clone();
      combinations.add(combination);
    } else if (start <= end) {
      data[index] = start;
      helper(combinations, data, start + 1, end, index + 1);
      helper(combinations, data, start + 1, end, index);
    }
  }
  public static List<int[]> generate(int n, int r) {
    List<int[]> combinations = new ArrayList<>();
    helper(combinations, new int[r], 0, n-1, 0);
    return combinations;
  }
}
