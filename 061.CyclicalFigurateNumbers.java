import java.util.*;

class CyclicalFigurateNumbers {
  public static void main(String[] args) {
    Set<Integer>[] TriSquPenHexHepOct = new Set[6];
    for(int i = 0; i < 6; i++) TriSquPenHexHepOct[i] = new HashSet<>();
    for(int n = 1;; n++) {
      int tri = (n*(n+1))/2;
      int squ = n*n;
      int pen = (n*(3*n-1))/2;
      int hex = n*(2*n-1);
      int hep = (n*(5*n-3))/2;
      int oct = n*(3*n-2);
      if((tri+"").length() >= 5) {break;}
      if((tri+"").length() == 4) {TriSquPenHexHepOct[0].add(tri);}
      if((squ+"").length() == 4) {TriSquPenHexHepOct[1].add(squ);}
      if((pen+"").length() == 4) {TriSquPenHexHepOct[2].add(pen);}
      if((hex+"").length() == 4) {TriSquPenHexHepOct[3].add(hex);}
      if((hep+"").length() == 4) {TriSquPenHexHepOct[4].add(hep);}
      if((oct+"").length() == 4) {TriSquPenHexHepOct[5].add(oct);}
    }
    Set<Integer>[][] TSPHHO = new Set[6][100];
    for(int i = 0; i < 6; i++) for(int j = 0; j < 100; j++) TSPHHO[i][j] = new HashSet<>();
    for(int i = 0; i < 6; i++) for(int x : TriSquPenHexHepOct[i]) TSPHHO[i][x/100].add(x);
    boolean[] used = {false, false, false, false, false, true};
    for(int o : TriSquPenHexHepOct[5]) {
      recurse(1, o, o, used, TSPHHO, o);
    }
  }
  public static void recurse(int i, int cur, int start, boolean[] used, Set<Integer>[][] sets, int total) {
    if(i >= 6) {
      if(start/100 == cur%100) {
        System.out.println(total);
      }
      return;
    }
    for(int s = 0; s < 6; s++) {
      if(used[s]) { continue; }
      used[s] = true;
      for(int x : sets[s][cur%100]) {
        recurse(i+1, x, start, used, sets, total + x);
      }
      used[s] = false;
    }
  }
}
