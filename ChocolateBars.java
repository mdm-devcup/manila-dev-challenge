/*
PROG: ChocolateBars
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class ChocolateBars {
   int[][] cache;  

   private int doit(int k, int c, int[] a, int s) {
      if(k == a.length) return 0;
      if(c * 2 == s) return 1;
      if(cache[k][c] != -1) return cache[k][c];
      return cache[k][c] = doit(k + 1, c + a[k], a, s) + doit(k + 1, c, a, s);
   }

   private void solve() throws Exception {
      //int[] a = {3, 2, 1, 9, 3};
      int[] a = {1, 5, 2, 10};
      int s = 0;
      for(int i : a) s += i;
      cache = new int[a.length + 1][s + 1];
      for(int i = 0; i < a.length; ++i) 
         Arrays.fill(cache[i], -1);
      int cn = doit(0, 0, a, s);
      if(cn > 0) {
         System.out.println("Can be divided."); 
      } else {
         System.out.println("Cannot be divided."); 
      }
   }

   public static void main(String[] args) throws Exception {
      new ChocolateBars().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
