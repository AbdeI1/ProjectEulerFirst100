class OrderedFractions {
  public static void main(String[] args) {
    double r = 3./7.; double minDif = 1; int minNum = -1;
    int d = 1_000_000;
    for(int i = 2; i <= d; i++) {
      if(i%7 == 0) { continue; }
      int n = (i*3)/7;
      double x = (double)n/i;
      if(r - x < minDif) {
        minDif = r-x;
        minNum = n;
      }
    }
    System.out.println(minNum);
  }
}
