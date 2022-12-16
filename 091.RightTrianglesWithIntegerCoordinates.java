class RightTrianglesWithIntegerCoordinates {
  public static void main(String[] args) {
    int m = 50;
    int count = 0;
    for(int x1 = 0; x1 <= m; x1++) {
      for(int y1 = 0; y1 <= m; y1++) {
        for(int x2 = 0; x2 <= m; x2++) {
          for(int y2 = 0; y2 <= m; y2++) {
            if(isRight(x1, y1, x2, y2)) {
              count++;
            }
          }
        }
      }
    }
    System.out.println(count/2);
  }
  public static boolean isRight(int x1, int y1, int x2, int y2) {
    if((x1 == x2 && y1 == y2) || (x1 == 0 && y1 == 0) || (0 == x2 && 0 == y2)) {
      return false;
    }
    int[] v1 = {x1, y1};
    int[] v2 = {x2, y2};
    int[] v3 = {x2 - x1, y2 - y1};
    double[] angs = new double[3];
    angs[0] = getAngle(v1, v2);
    angs[1] = getAngle(v1, v3);
    angs[2] = getAngle(v2, v3);
//    System.out.println("(0, 0) (" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")");
//    System.out.println(Arrays.toString(angs));
//    System.out.println();
    for(double ang : angs) {
      if(Math.abs(ang - Math.PI/2) < 1e-6) {
        return true;
      }
    }
    return false;
  }
  public static double getAngle(int[] v1, int[] v2) {
    double dotP = v1[0]*v2[0] + v1[1]*v2[1];
    dotP /= getMagnitude(v1);
    dotP /= getMagnitude(v2);
    return Math.acos(dotP);
  }
  public static double getMagnitude(int[] v1) {
    return Math.sqrt(v1[0]*v1[0] + v1[1]*v1[1]);
  }
}
