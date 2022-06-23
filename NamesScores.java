import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class NamesScores {
  public static void main(String[] args) throws FileNotFoundException {
    var names = Arrays.stream(new Scanner(new File("p022_names.txt")).nextLine().replace("\"", "").split(",")).sorted().mapToInt(s -> s.chars().map(c -> c - '@').sum()).toArray();
    System.out.println(IntStream.range(0, names.length).boxed().map(i -> new int[]{i, names[i]}).mapToInt(o -> o[1]*(o[0]+1)).sum());
  }
}
