/*
PROG: HeyHorsey
LANG: JAVA
*/
import java.util.*;
import java.io.*;
import java.awt.Point;

public class HeyHorsey {
   final int N = 8;
   final int[] dx = {1, 2,  1,  2, -1, -2, -1, -2};
   final int[] dy = {2, 1, -2, -1,  2,  1, -2, -1};

   private Point toXy(char c, int n) {
      return new Point(Math.abs((n - N) % N), c - 'A');
   }

   private void solve() throws Exception {
      //BufferedReader br = new BufferedReader(new FileReader("HeyHorsey.in"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] pa = br.readLine().split(" ");
      Point kn = toXy(pa[0].charAt(0), Integer.parseInt(pa[1]));
      Point ki = toXy(pa[2].charAt(0), Integer.parseInt(pa[3]));

      Queue<Point> q = new LinkedList<>();
      char[][] board = new char[N][N];
      boolean[][] visited = new boolean[N][N];
      int[][] distance = new int[N][N];

      for (int i = 0; i < N; ++i)
         Arrays.fill(board[i], '.');
      board[kn.x][kn.y] = 'H';
      board[ki.x][ki.y] = 'K';

      q.add(kn);
      visited[kn.x][kn.y] = true;

      while (q.size() > 0) {
         Point top = q.remove();
         for (int i = 0; i < dx.length; ++i) {
            int nx = top.x + dx[i], ny = top.y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
            q.add(new Point(nx, ny));
            distance[nx][ny] += distance[top.x][top.y] + 1;
            visited[nx][ny] = true;
         }
      }

      int moves = distance[ki.x][ki.y] - 1;

      if (moves == 0) {
         System.out.println("Check!");
      } else if (moves <= 3) {
         System.out.println(moves);
      } else {
         System.out.println("Knight is too slow.");
      }
   }

   private void print(int[][] distance) {
      for (int i = 0; i < N; ++i) {
         for (int j = 0; j < N; ++j)
            System.out.print(distance[i][j] + " ");
         System.out.println();
      }
      System.out.println();
   }
   public static void main(String[] args) throws Exception {
      new HeyHorsey().solve();
   }

   static void debug(Object...o) {
      System.err.println(Arrays.deepToString(o));
   }

}
