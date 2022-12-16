class CoinSums {
  public static final int[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};
  public static int[][] dp;
  public static void main(String[] args) {
    dp = new int[201][COINS.length];
    for(int i = 0; i < COINS.length; i++) dp[0][i] = 1;
    System.out.println(howMany(200, 0));
  }
  public static int howMany(int n, int coin) {
    if(n == 0) return 1;
    if(n < 0 || coin == COINS.length) return 0;
    if(dp[n][coin] != 0) return dp[n][coin];
    int c = COINS[coin];
    for(int i = 0; n-i*c >= 0; i++)
      dp[n][coin] += howMany(n-i*c, coin+1);
    return dp[n][coin];
  }
}
