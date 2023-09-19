import java.util.*;
import java.io.*;

class S14890 {
    static class coor {
        int y, x;
        public coor(int y, int x) {this.y = y; this.x =x;}
    }
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/14890.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());

        int [][] board = new int[size][size];

        for(int i = 0; i< size; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        for(var e: board) { for(var e2: e) System.out.print(e2 + " "); System.out.println(); }

        for(int i = 0; i < size; i++)
        {
            int count = 0;
            for(int j = 0; j < size; j++)
            {
                if(board[i][j] + 1 < board[i][j]) break;
                if(board[i][j] == board[i][j + 1]) count++;
                if(board[i][j] + 1 == board[i][j + 1])
                    if(count <= block) break;
                    else count = 1;
                    
                

            }


        }

        

    }
}

