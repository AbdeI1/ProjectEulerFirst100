class NumberLetterCounts {
  public static final int[] O = {0, "one".length(), "two".length(), "three".length(), "four".length(), "five".length(), "six".length(), "seven".length(), "eight".length(), "nine".length(), "ten".length(), "eleven".length(), "twelve".length(), "thirteen".length(), "fourteen".length(), "fifteen".length(), "sixteen".length(), "seventeen".length(), "eighteen".length(), "nineteen".length()};
  public static final int[] T = {0, 0, "twenty".length(), "thirty".length(), "forty".length(), "fifty".length(), "sixty".length(), "seventy".length(), "eighty".length(), "ninety".length()};
  public static void main(String[] args) {
    int sum = 0;
    for(int i = 1; i < 100; i++)
      if (i < O.length) sum += O[i];
      else sum += T[i / 10] + O[i % 10];
    sum *= 10;
    for(int i = 1; i < 10; i++)
      sum += (O[i] + "hundredand".length())*99 + (O[i] + "hundred".length());
    sum += "onethousand".length();
    System.out.println(sum);
  }
}
