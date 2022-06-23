public class CountingSundays {
  public static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  public static void main(String[] args) {
    int count = 0; int day = 1;
    for (int d : DAYS) day = (day+d)%7;
    for(int i = 1901; i <= 2000; i++) {
      for(int d : DAYS) {
        if(day == 0) count++;
        day = (day+(d == 28 ? (i%4 == 0 ? d+1 : d) : d))%7;
      }
    }
    System.out.println(count);
  }
}
