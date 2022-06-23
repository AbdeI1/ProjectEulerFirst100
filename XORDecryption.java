import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class XORDecryption {
  public static void main(String[] args) throws FileNotFoundException {
    var s = Arrays.stream(new Scanner(new File("p059_cipher.txt")).nextLine().split(",")).map(i -> ((char)Integer.parseInt(i)) + "").collect(Collectors.joining(""));
    for(char a = 'a'; a <= 'z'; a++) {
      for(char b = 'a'; b <= 'z'; b++) {
        for(char c = 'a'; c <= 'z'; c++) {
          String k = a + "" + b + "" + c;
          String d = decrypt(s, k);
          if(d.split("the").length > 20) {
            System.out.println(d.chars().sum());
          }
        }
      }
    }
  }
  public static String decrypt(String s, String key) {
    int l = key.length();
    StringBuilder d = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
      d.append((char)(s.charAt(i) ^ key.charAt(i%l)));
    }
    return d.toString();
  }

}
