import java.math.BigInteger;

class LychrelNumbers {
  public static void main(String[] args) {
    int count = 0;
    for(long i = 0; i < 10_000; i++)
      if(isLychrel(i))
        count++;
    System.out.println(count);
  }
  public static boolean isLychrel(long x) {
    BigInteger X = new BigInteger(x+"");
    for(int i = 0; i < 50; i++) {
      X = X.add(new BigInteger(new StringBuilder(X.toString()).reverse().toString()));
      if(X.toString().equals(new StringBuilder(X.toString()).reverse().toString())) return false;
    }
    return true;
  }
}
