import java.util.HashSet;

class CountingFractionInRange {
  public static void main(String[] args) {
    int d = 12_000;
    HashSet<Double> fracs = new HashSet<>();
    for(int i = 5; i <= d; i++) {
      for(int j = i/3 + 1; j < (i%2 == 0 ? i/2 : i/2 + 1); j++) {
        fracs.add((double)i/j);
      }
    }
    System.out.println(fracs.size());
  }
}
