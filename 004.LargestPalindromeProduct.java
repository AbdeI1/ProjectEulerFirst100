import java.util.*;

class LargestPalindromeProduct {
  public static void main(String[] args) {
    List<Integer> palindromes = new ArrayList<>();
    for(int i = 100; i < 1000; i++) {
      for(int j = 100; j < 1000; j++) {
        int x = i*j;
        String s = x + "";
        if(s.equals(new StringBuilder(s).reverse().toString())) {
          palindromes.add(x);
        }
      }
    }
    palindromes.sort(Integer::compareTo);
    System.out.println(palindromes.get(palindromes.size()-1));
  }
}
