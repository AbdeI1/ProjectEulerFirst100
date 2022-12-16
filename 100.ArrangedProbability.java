class ArrangedProbability {
  public static void main(String[] args) {
    long a0 = 1;
    long a1 = 3;
    while(a1 < 707_106_781_200L) {
      long t = a1;
      a1 = 6*a1 - a0 - 2;
      a0 = t;
    }
    System.out.println(a1);
  }
}
