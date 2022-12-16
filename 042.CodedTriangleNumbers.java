import java.io.*;
import java.util.*;

class CodedTriangleNumbers {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(Arrays.stream((new Scanner(new File("p042_words.txt"))).nextLine().replace("\"", "").split(",")).map(w -> w.chars().map(c -> c - '@').sum()).map(n -> 8*n+1).map(n -> new long[]{(long)Math.sqrt(n), n}).filter(a -> a[0]*a[0] == a[1]).count());
  }
}
