import java.io.*;
import java.util.*;

class AnagramicSquares {
  public static void main(String[] args) throws FileNotFoundException {
    String[] words = new Scanner(new File("p042_words.txt")).nextLine().replace("\"", "").split(",");
    List<String[]> anagramPairs = new ArrayList<>();
    for(int i = 0; i < words.length; i++) {
      for(int j = i+1; j < words.length; j++) {
        String ss1 = words[i];
        String ss2 = words[j];
        char[] s1 = words[i].toCharArray();
        char[] s2 = words[j].toCharArray();
        Arrays.sort(s1); Arrays.sort(s2);
        if(new String(s1).equals(new String(s2))) {
          anagramPairs.add(new String[]{ss1, ss2});
        }
      }
    }
    List<Integer> f = new ArrayList<>();
    for(String[] ss : anagramPairs) {
      boolean[] used = new boolean[10];
      HashMap<Character, Integer> map = new HashMap<>();
      List<Integer> res = check(ss[0], ss[1], 0, used, map);
      f.addAll(res);
    }
    System.out.println(f.stream().reduce(-1, Math::max));
  }
  public static List<Integer> check(String s1, String s2, int index, boolean[] used, Map<Character, Integer> map) {
    List<Integer> res = new ArrayList<>();
    if(index >= s1.length()) {
      if(map.get(s1.charAt(0)) == 0 || map.get(s2.charAt(0)) == 0) {
        return res;
      }
      int a = Integer.parseInt(Arrays.toString(s1.chars().map(c -> map.get((char)c)).toArray()).replace("[", "").replace("]", "").replace(", ", ""));
      int b = Integer.parseInt(Arrays.toString(s2.chars().map(c -> map.get((char)c)).toArray()).replace("[", "").replace("]", "").replace(", ", ""));
      int asq = (int)Math.sqrt(a);
      int bsq = (int)Math.sqrt(b);
      if(asq*asq == a && bsq*bsq == b){
        res.add(a); res.add(b);
      }
      return res;
    }
    if(map.containsKey(s1.charAt(index))) {
      return check(s1, s2, index+1, used, map);
    }
    for(int i = 0; i < 10; i++) {
      if(used[i]){ continue; }
      used[i] = true;
      map.put(s1.charAt(index), i);
      res.addAll(check(s1, s2, index+1, used, map));
      map.remove(s1.charAt(index));
      used[i] = false;
    }
    return res;
  }
}
