/*
PROG: change
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class change {
   int[] coins = {1, 5, 10, 25};

   long doit(int n) {
      if(n == 0) return 1l; 
      if(n < 0) return 0l;
      long r = 0;
      for(int i = 0; i < coins.length; ++i) 
         r += doit(n - coins[i]);
      return r;
   }
   private void solve() throws Exception {
      
      debug(doit(25));
   }

   public static void main(String[] args) throws Exception {
      new change().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
