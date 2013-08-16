/*
PROG: UniqueSnowflake
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class UniqueSnowflake {

   private void solve() throws Exception {
      BufferedReader br = new BufferedReader(new FileReader("UniqueSnowflake.in"));
      PrintWriter pw = new PrintWriter("UniqueSnowflake.out");
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      pw.close();
   }

   public static void main(String[] args) throws Exception {
      new UniqueSnowflake().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
