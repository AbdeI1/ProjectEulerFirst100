public class EvenFibonaccieNumbers {
  public static void main(String[] args) {
    int sum = 0;
    int f0 = 0;
    int f1 = 2;
    while(f1 < 4000000) {
      sum += f1;
      f1 = 4*f1 + f0;
      f0 = (f1-f0)/4;
    }
    System.out.println(sum);
  }
}
