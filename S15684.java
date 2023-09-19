import java.util.*;
import java.io.*;

class S15684 {
    static int [][] board;
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/15684.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        board = new int[y][x];

        for(int i = 0; i < size; i++)
        {
            st = new StringTokenizer(br.readLine());
            int by = Integer.parseInt(st.nextToken()) - 1;
            int bx = Integer.parseInt(st.nextToken()) - 1;
            board[by][bx] = -1;
            board[by][bx + 1] = 1;
        }

        for(var e: board) {for(var e2: e) System.out.printf("%2d ", e2); System.out.println();}

        int [] cur = new int [] {0,0};
        for(int i = 0; i < y; i++)
        {
            
            
        
        }



    }
}