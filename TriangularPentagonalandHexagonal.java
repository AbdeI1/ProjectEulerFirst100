public class TriangularPentagonalandHexagonal {
  public static void main(String[] args) {
    int trii = 1;
    int penti = 1;
    int hexi = 1;
    int tri = 1;
    int pent = 1;
    int hex = 1;
    for(int i = 0; i < 27693; i++) {
      if(tri == pent && pent == hex) {
        System.out.println(pent);
        System.out.println(trii + " " + penti + " " + hexi);
      }
      hexi++;
      hex += (4*hexi - 3);
      while(pent < hex) {
        penti++;
        pent += (3*penti-2);
      }
      while(tri < hex) {
        trii++;
        tri += (trii);
      }
    }
  }
}
