/*
PROG: UniqueSnoflake
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class UniqueSnoflake {

   private void solve() throws Exception {
      int[] a = {1, 1, 432, 55, 23, 23, 44, 55};
      int max = 0;
      for(int i : a) max = Math.max(max, i);
      boolean[] flag = new boolean[max + 1];
      for(int i : a) {
         if(flag[i]) continue;
         System.out.println(i);
         flag[i] = true;
      }
   }

   public static void main(String[] args) throws Exception {
      new UniqueSnoflake().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
