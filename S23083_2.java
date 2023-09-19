import java.util.*;
import java.io.*;

class S23083_2 {

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
        board[0][0] = 1;
        for(int i = 0; i < y_lim; i++)
        {
            for(int j = 0; j < x_lim; j++)
            {
                if(board[i][j] == -1) continue;
                if(i -1 >= 0 && j + 1 < y_lim && board[i-1][j+1] != -1) board[i-1][j+1] += board[i][j];
                if(j + 1 < y_lim && board[i][j+1] != -1) board[i][j+1] += board[i][j];
                if(i + 1 < y_lim && board[i+1][j] != -1) board[i+1][j] += board[i][j];

                // 1  0  0  0
                // 1  0 -1  0
                // 1  0  0  0

                // 1  2  2  2
                // 1  2 -1  0
                // 1  2  0  0

                // 1  2  2  2
                // 1  2 -1  0
                // 1  2  0  0


                //==================


                // 1  0  0  0
                // 1  0 -1  0
                // 1  0  0  0

                // 1  2  0  0
                // 1  0 -1  0
                // 1  0  0  0

                // 1  2  0  0
                // 1  0 -1  0
                // 1  0  0  0

                // 1  2  2  0
                // 1  0 -1  0
                // 1  0  0  0

                // 1  2  2  2
                // 1  0 -1  0
                // 1  0  0  0

                // 1  2  2  2
                // 1  4 -1  0
                // 1  0  0  0

                // 1  2  6  2
                // 1  4 -1  0
                // 1  0  0  0

                // 1  2  6  8
                // 1  4 -1  0
                // 1  0  0  0

                // 1  2  6  8
                // 1  4 -1  8
                // 1  0  0  0

                // 1  2  6  8
                // 1  4 -1  8
                // 1  0  0  8

                // 1  2  6  8
                // 1  4 -1  8
                // 1  5  0  

                // 1  2  6  8
                // 1  4 -1  8
                // 1  5  5  0

                // 1  2  6  8
                // 1  4 -1  13
                // 1  5  5  0

                // 1  2  6  8
                // 1  4 -1  13
                // 1  5  5  18


                
                
                

            }
        }

        for(var e: board) { for(var e2: e) System.out.printf("%2d ", e2); System.out.println();}

        

        System.out.println(ans);
    }

   
   
}