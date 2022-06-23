public class MultiplesOf3Or5 {
  public static void main(String[] args) {
    int n = 1000;
    n--;
    int sum = 0;
    sum += 3*(((n/3)*((n/3) + 1))/2);
    sum += 5*(((n/5)*((n/5) + 1))/2);
    sum -= 15*(((n/15)*((n/15) + 1))/2);
    System.out.println(sum);
  }
}
