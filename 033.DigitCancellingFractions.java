class DigitCancellingFractions {
  public static void main(String[] args) {
    int n = 1;
    int d = 1;
    for(int i = 10; i < 100; i++) {
      for(int j = i+1; j < 100; j++) {
        if(i%10 == 0 && j%10 == 0) {
          continue;
        }
        if(i%10 == j%10) {
          if((i/10)*j == (j/10)*i) {
            n *= (i/10);
            d *= (j/10);
            // System.out.println(i + " / " + j + " = " + i/10 + " / " + j/10);
          }
        }
        if (i%10 == j/10) {
          if((i/10)*j == (j%10)*i) {
            n *= (i/10);
            d *= (j%10);
            // System.out.println(i + " / " + j + " = " + i/10 + " / " + j%10);
          }
        }
        if (i/10 == j%10) {
          if((i%10)*j == (j/10)*i) {
            n *= (i%10);
            d *= (j/10);
            // System.out.println(i + " / " + j + " = " + i%10 + " / " + j/10);
          }
        }
        if (i/10 == j/10) {
          if((i%10)*j == (j%10)*i) {
            n *= (i%10);
            d *= (j%10);
            // System.out.println(i + " / " + j + " = " + i%10 + " / " + j%10);
          }
        }
      }
    }
    System.out.println(d/n);
  }
}
