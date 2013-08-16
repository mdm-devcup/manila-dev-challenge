/*
PROG: MiceEverywhere
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class MiceEverywhere {

   long doit(int k, int x, int y) {
      long r = 0l;
      for(int i = 0; i < y; i += x) {
         r += 2 * doit(k - 1, x, y);
      }
      return r;
   }
   private void solve() throws Exception {
      
   }

   public static void main(String[] args) throws Exception {
      new MiceEverywhere().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
