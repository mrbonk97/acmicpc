import java.io.*;
import java.util.*;

public class S2234 {
    static class block {
        boolean u, d, l, r;
        public block(boolean u, boolean d, boolean l, boolean r) {
            this.u = u;
            this.d = d;
            this.l = l;
            this.r = r;
        }
        public block() {
            this.u = false;
            this.d = false;
            this.l = false;
            this.r = false;
        }
    }

    static block [][] board;
    static boolean [][] vis;
    static int [][][] sum;
    static int y, x;
    static int [] dy = new int [] {-1, 1, 0, 0};
    static int [] dx = new int [] {0, 0, -1, 1};
    static List<List<Integer>> al = new ArrayList<>();
    static int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/2234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        board = new block [y][x];
        vis = new boolean[y][x];
        sum = new int[y][x][2];
        int idx = 0;
        for(int i = 0; i < y; i++) al.add(new ArrayList<>());
        for(int i = 0; i < y; i++) for(int j = 0; j < x; j++) board[i][j] = new block();

        for(int i = 0; i < y; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++)
            {
                int cur = Integer.parseInt(st.nextToken());
                boolean u = false, d = false, l = false  , r = false;
                if(cur >= 8) {d = true; cur -= 8; }
                if(cur >= 4) {r = true; cur -= 4; }
                if(cur >= 2) {u = true; cur -= 2; }
                if(cur >= 1) {l = true; cur -= 1; }
                board[i][j] = new block(u,d,l,r);
                if(u && i - 1 >= 0) board[i - 1][j].d = true;
                if(d && i + 1 < y) board[i + 1][j].u = true;
                if(l && j - 1 >= 0) board[i][j-1].r = true;
                if(r && j + 1 < x) board[i][j+1].l = true;
            }
        }

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(vis[i][j]) continue;
                int count = 0;
                vis[i][j] = true;
                Queue<int []> q = new LinkedList<>();
                List<int []> trace = new ArrayList<>();
                q.add(new int [] {i,j});

                while(!q.isEmpty())
                {
                    int [] cur = q.poll();
                    trace.add(new int [] {cur[0], cur[1]});
                    // System.out.print(cur[0] + " " + cur[1] + " ");
                    // System.out.print(board[cur[0]][cur[1]].u);
                    // System.out.print(board[cur[0]][cur[1]].d);
                    // System.out.print(board[cur[0]][cur[1]].l);
                    // System.out.print(board[cur[0]][cur[1]].r);
                    // System.out.println();
                    count++;
                    for(int dir = 0; dir < 4; dir++) {
                        int ny = dy[dir] + cur[0];
                        int nx = dx[dir] + cur[1];
                        if(ny < 0 || nx < 0 || ny >= y || nx >= x) continue;
                        if(vis[ny][nx]) continue;
                        if(dir == 0 && !board[cur[0]][cur[1]].u) { q.add(new int [] {ny, nx}); vis[ny][nx] = true; }
                        if(dir == 1 && !board[cur[0]][cur[1]].d) { q.add(new int [] {ny, nx}); vis[ny][nx] = true; }
                        if(dir == 2 && !board[cur[0]][cur[1]].l) { q.add(new int [] {ny, nx}); vis[ny][nx] = true; }
                        if(dir == 3 && !board[cur[0]][cur[1]].r) { q.add(new int [] {ny, nx}); vis[ny][nx] = true; }
                    }
                }
                
                for(int [] e : trace){ sum[e[0]][e[1]][0] = count; sum[e[0]][e[1]][1] = idx; }
                max1 = Math.max(max1, count);
                idx++;
            }
        }

        for(int i = 0; i < y - 1; i++) {
            for(int j = 0; j < x - 1; j++){
                int cur1 = 0;
                int cur2 = 0;
                if(sum[i][j][1] != sum[i + 1][j][1]) { cur1 = sum[i][j][0] + sum[i + 1][j][0]; }
                if(sum[i][j][1] != sum[i][j+1][1]) { cur2 = sum[i][j][0] + sum[i][j+1][0]; }
                max2 = Math.max(max2, cur1);
                max2 = Math.max(max2, cur2);
                
            }
        }
        System.out.println(idx);
        System.out.println(max1);
        System.out.println(max2);







    }
}