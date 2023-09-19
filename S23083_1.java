import java.util.*;
import java.io.*;

class S23083_1 {

    static int [] dy = new int [] {-1,0, 1};
    static int [] dx = new int [] {1, 1, 0};
    static int [][] board;
    static boolean [][] vis;
    static int y_lim = 0, x_lim = 0, ans = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input/23083.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        y_lim = Integer.parseInt(st.nextToken());
        x_lim = Integer.parseInt(st.nextToken());

        System.out.println(y_lim + " " + x_lim);

        board = new int [y_lim][x_lim];
        vis = new boolean [y_lim][x_lim];

        int hole = Integer.parseInt(br.readLine());
        for(int i = 0; i < hole; i++)
        {
            st = new StringTokenizer(br.readLine());
            int yy = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());
            board[yy - 1][xx- 1] = -1;
        }

        back(new int [] {0,0});

        System.out.println(ans);
    }

    public static void back(int [] cur) {
        System.out.println((cur[0]+1) + " " + (cur[1]+1));

        if(cur[0] == y_lim - 1 && cur[1] == x_lim -1) { 
            System.out.println("find");
            ans++; return; }
        
        for(int dir = 0; dir < 3; dir++)
        {
            int ny = cur[0] + dy[dir];
            int nx = cur[1] + dx[dir];

            if(ny < 0 || nx < 0 || ny >= y_lim || nx >= x_lim) continue;
            if(board[ny][nx] == -1) continue;
            if(vis[ny][nx]) continue;

            vis[ny][nx] = true;
            back(new int [] {ny, nx});
            vis[ny][nx] = false;

        }
    }
}