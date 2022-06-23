import java.io.*;
import java.util.*;

public class PokerHands {
  public static final char[] CARDS = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
  public static Map<Character, Integer> cMap = new HashMap<>();
  public static final char[] SUITS = {'H', 'D', 'S', 'C'};
  public static void main(String[] args) throws FileNotFoundException {
    for(int i = 0; i < CARDS.length; i++) cMap.put(CARDS[i], i);
    var hands = Arrays.stream(new Scanner(new File("p054_poker.txt")).useDelimiter("\\Z").next().split("\n")).map(s -> Arrays.stream(new String[]{s.substring(0, 14), s.substring(15)})).map(s -> s.map(st -> st.split(" "))).map(s -> s.toArray(String[][]::new)).toArray(String[][][]::new);
    int count = 0;
    for(var h : hands) {
      Set<String> h1 = new HashSet<>(); Collections.addAll(h1, h[0]);
      Set<String> h2 = new HashSet<>(); Collections.addAll(h2, h[1]);
      if(oneWins(h1, h2)) { count++; }
    }
    System.out.println(count);
  }
  public static boolean oneWins(Set<String> h1, Set<String> h2) {
    int[] s1 = computeScore(h1);
    int[] s2 = computeScore(h2);
    if(s1[0] > s2[0]) {
      return true;
    } else if (s2[0] > s1[0]) {
      return false;
    } else {
      if(s1[1] > s2[1]) {
        return true;
      } else if (s2[1] > s1[1]) {
        return false;
      } else {
        int[] w = h1.stream().mapToInt(c -> cMap.get(c.charAt(0))).sorted().toArray();
        int[] l = h2.stream().mapToInt(c -> cMap.get(c.charAt(0))).sorted().toArray();
        for(int i = w.length-1; i >= 0; i--) {
          if(w[i] > l[i]) {
            return true;
          } else if (l[i] > w[i]) {
            return false;
          }
        }
      }
    }
    System.out.println("ruh roh");
    return false;
  }
  public static int[] computeScore(Set<String> h) {
    int[] count = new int[CARDS.length];
    for(String s : h) count[cMap.get(s.charAt(0))]++;
    // check for royal flush
    royal:
    for(char s : SUITS) {
      for(int i = 8; i < CARDS.length; i++)
        if(!h.contains(CARDS[i] + "" + s))
          continue royal;
      return new int[]{10, -1};
    }
    // check for straight flush
    for(char s : SUITS) {
      straightF:
      for(int i = 0; i < 8; i++) {
        for (int j = i; j < i + 5; j++)
          if (!h.contains(CARDS[j] + "" + s))
            continue straightF;
        return new int[]{9, i+4};
      }
    }
    // check for four of a kind
    for(int i = 0; i < CARDS.length; i++) {
      if(count[i] == 4) {
        return new int[]{8, i};
      }
    }
    // check for full house
    int three = -1; int two = -1;
    for(int i = 0; i < CARDS.length; i++) {
      if(count[i] == 3) three = i;
      if(count[i] == 2) two = i;
    }
    if(three > -1 && two > -1) {
      return new int[]{7, three};
    }
    // check for flush
    flush:
    for(char s : SUITS) {
      for(String c : h)
        if(c.charAt(1) != s)
          continue flush;
      return new int[]{6, -1};
    }
    // check for straight
    straight:
    for(int i = 0; i < 8; i++) {
      for (int j = i; j < i + 5; j++)
        if (count[j] != 1)
          continue straight;
      return new int[]{5, i+4};
    }
    // check for three of a kind
    for(int i = 0; i < CARDS.length; i++)
      if(count[i] == 3)
        return new int[]{4, i};
    // check for two pairs
    int t = 0;
    for(int i = 0; i < CARDS.length; i++)
      if(count[i] == 2)
        t = t*15 + i+1;
    if(t >= 15) return new int[]{3, t};
    // check for a pair
    if(t > 0) return new int[]{2, t-1};
    // high card
    return new int[]{1, -1};
  }
}
