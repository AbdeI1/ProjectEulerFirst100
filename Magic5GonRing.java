import java.io.*;
import java.util.*;

public class Magic5GonRing {
  public static List<String> ans;
  public static void main(String[] args) {
    // only 9^7 options ~5,000,000 -- maybe 9^6
    int[] nums = new int[10];
    ans = new ArrayList<>();
    boolean[] used = new boolean[11];
    get5Gons(nums, used, 0);
    Collections.sort(ans);
    System.out.println(ans.get(ans.size()-1));
  }
  public static int[] get5Gon(int[] a) {
    int[] nums = new int[15];
    nums[0] = a[0];
    nums[1] = nums[14] = a[1];
    nums[2] = nums[4] = a[2];
    nums[3] = a[3];
    nums[5] = nums[7] = a[4];
    nums[6] = a[5];
    nums[8] = nums[10] = a[6];
    nums[9] = a[7];
    nums[11] = nums[13] = a[8];
    nums[12] = a[9];
    return nums;
  }
  public static boolean is5Gon(int[] a) {
    int[] nums = get5Gon(a);
    int sum = nums[0] + nums[1] + nums[2];
    for(int i = 3; i < a.length; i += 3) {
      if(nums[i] + nums[i+1] + nums[i+2] != sum) {
        return false;
      }
    }
    return (nums[0] < nums[3] && nums[0] < nums[6] && nums[0] < nums[9] && nums[0] < nums[12]);
  }
  public static void get5Gons(int[] a, boolean[] used, int ind) {
    if(ind == 10) {
      if(is5Gon(a)) {
        String s = "";
        for(int x : get5Gon(a)) {
          s += x;
        }
        ans.add(s);
      }
      return;
    }
    for(int i = 1; i <= 10; i++) {
      if(used[i]) { continue; }
      used[i] = true;
      a[ind] = i;
      get5Gons(a, used, ind+1);
      used[i] = false;
    }
  }
}
