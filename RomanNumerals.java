import java.io.*;
import java.util.*;

public class RomanNumerals {
  private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>(); static {
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
  }
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(Arrays.stream(new Scanner(new File("p089_roman.txt")).useDelimiter("\\Z").next().split("\n")).mapToInt(RomanNumerals::howMuchSaved).sum());
  }
  public static int howMuchSaved(String numeral) {
    String nm = toRoman(romanToDecimal(numeral));
    int res = numeral.length() - nm.length();
    return res;
  }

  public static int value(char r) {
    for(int l : map.keySet()){
      if(map.get(l).charAt(0) == r) {
        return l;
      }
    }
    return -1;
  }
  public static int romanToDecimal(String str) {
    int res = 0;
    for (int i = 0; i < str.length(); i++) {
      int s1 = value(str.charAt(i));
      if (i + 1 < str.length()) {
        int s2 = value(str.charAt(i + 1));
        if (s1 >= s2) {
          res = res + s1;
        }
        else {
          res = res + s2 - s1;
          i++;
        }
      }
      else {
        res = res + s1;
      }
    }
    return res;
  }
  public static String toRoman(int number) {
    int l =  map.floorKey(number);
    if ( number == l ) {
      return map.get(number);
    }
    return map.get(l) + toRoman(number-l);
  }
}
