import java.util.*;
import java.io.*;

class S14620 {
    static int [] dy = {0, 1, 0, -1 ,0};
    static int [] dx = {0, 0, 1, 0, -1};

    static int [][] board;
    static boolean [][] vis;

    static int [] price = new int [3];

    static int length = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/14620.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        length = Integer.parseInt(br.readLine());
        board = new int [length][length];
        vis = new boolean[length][length];

        for(int i = 0; i < length; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < length; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        // for(int i = 0; i < length; i++)
        // {
        //     for(int j = 0; j < length; j++) System.out.printf("%2d ", board[i][j]);
        //     System.out.println();
        // }

        back(0,0,0);
        System.out.println(min);
    }

    public static void back(int depth,int i, int j) {
        if(depth == 3) {
            int cur = 0;
            for(var e: price) cur += e;
            min = Math.min(min, cur);
            return;
        }

        for(; i < length - 1; i++)
        {
            for(; j < length - 1; j++)
            {
                int count = 0;
                int curPrice = 0;
                for(int dir = 0; dir < 5; dir++)
                {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if(ny < 0 || nx < 0 || ny >= length || nx >= length) break;
                    if(vis[ny][nx]) break;
                    count++;
                }
                if(count < 5) continue;

                for(int dir = 0; dir < 5; dir++)
                {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    curPrice += board[ny][nx];
                    vis[ny][nx] = true;
                }
                price[depth] = curPrice;
                back(depth + 1,i,j);
                for(int dir = 0; dir < 5; dir++)
                {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    vis[ny][nx] = false;
                }

            }
        }



    }
    
}