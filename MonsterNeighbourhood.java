/*
PROG: MonsterNeighbourhood
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class MonsterNeighbourhood {
   private final int[][] matrix = {
      {1},
      {0, 2, 3},
      {1, 3, 4},
      {1, 2, 4},
      {2, 3, 6},
      {6},
      {4, 5, 7},
      {6, 8, 9},
      {7, 10},
      {7, 10, 11},
      {8, 9, 11},
      {9, 10},
   };
   private final String colors = "RRRRRBBBBGGG";
   private boolean found; 

   private boolean can(int k, char[] cu, char c) {
      for(int i : matrix[k]) 
         if(cu[i] == c) return false; 
      return true;
   }

   private String get(char c) {
      return c == 'R' ? "RED" : c == 'B' ? "BLUE" : "GREEN"; 
   }

   private void print(char[] cu) {
      for(int i = 0; i < cu.length; ++i) {
         System.out.println(String.format("Hole %d: Color: %s", i, get(cu[i]))); 
      } 
   }

   private void doit(int k, int m, char[] cu) {
      if(m == (1 << matrix.length) - 1) {
         print(cu);
         found = true;
      }
      if(k == cu.length || found) return;
      for (int i = 0; i < matrix.length; ++i) {
         if(((m >> 1) & 1) == 0 && can(k, cu, colors.charAt(i))) {
            cu[k] = colors.charAt(i);
            doit(k + 1, m | (1 << i), cu);
            cu[k] = '*';
         } 
      }
   }

   private void solve() throws Exception {
      char[] cu = new char[matrix.length];
      doit(0, 0, cu);
   }

   public static void main(String[] args) throws Exception {
      new MonsterNeighbourhood().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
