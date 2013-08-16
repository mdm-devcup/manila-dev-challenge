/*
PROG: JackAndJill
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class JackAndJill {
   String[] ja = {"a", "a", "o", "a", "d", "d", "a"};
   String[] ji = {"a", "o", "o", "d", "a"};

   private void put(Map<String, Integer> map, String key) {
      if(map.containsKey(key)) 
         map.put(key, map.get(key) + 1);
      else
         map.put(key, 1);
   }

   private boolean isTwice(Map<String, Integer> jack, Map<String, Integer> jill) {
      for(String key : jack.keySet()) {
         int a = jack.get(key);
         int b = jill.get(key);
         if(a + b != Math.min(a, b) * 3) return false;
      } 
      return true;
   }

   private boolean sameType(Map<String, Integer> jack, Map<String, Integer> jill) {
      Set<String> all = new HashSet<>();
      all.addAll(jack.keySet());
      all.addAll(jill.keySet());
      return jack.size() == all.size() && jill.size() == jack.size();
   }

   private void solve() throws Exception {
      Map<String, Integer> jack = new HashMap<>();
      Map<String, Integer> jill = new HashMap<>();
      for(String e : ja) put(jack, e);
      for(String e : ji) put(jill, e);
      
      boolean is = sameType(jack, jill) && isTwice(jack, jill);
      if(is) {
         System.out.println("YES"); 
      } else {
         System.out.println("NO"); 
      }
   }

   public static void main(String[] args) throws Exception {
      new JackAndJill().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
