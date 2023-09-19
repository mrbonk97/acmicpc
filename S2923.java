import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class S2923 {
    static int [][] board;
    static int [] temp;
    static StringTokenizer st;
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/2923.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        board = new int[size][size];
        temp = new int[size];

        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                board[i][j] = i*size + j + 1;

        for(int i = 0; i < num; i++)
        {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int startY = 0, startX = 0;
            boolean found = false;
            for(; startY < size; startY++)
            {
                for(startX = 0; startX < size; startX++) if(board[startY][startX] == target) { found = true; break; }
                if(found) break;
2            }

            int dis = Math.abs(x - startX);
            if(x >= startX) ans += x - startX;
            else ans += size - startX + x;
            
            for(int xx = 0; xx < size; xx++) temp[xx] = board[startY][xx];
            for(int xx = 0; xx < size; xx++) board[startY][(dis + xx)%size] = temp[xx];


            // System.out.println();
            // for(int asd = 0; asd < size; asd++)
            // {
            //     for(int dd = 0; dd < size; dd++)  {System.out.printf("%2d ", board[asd][dd]); }
            //     System.out.println();
            // }


            dis = Math.abs(y - startY);
            if(y >= startY) ans += y - startY;
            else ans += size - startY + y;

            for(int yy = 0; yy < size; yy++) temp[yy] = board[yy][x];

            // System.out.println();
            // for(var e: temp) System.out.print(e + " ");
            // System.out.println();


            dis = startY >= y ? size - startY + y : y - startY;
            for(int yy = 0; yy < size; yy++) { 
                board[(yy + dis)%size][x] = temp[yy];
            }
            


            // System.out.println();
            // for(int asd = 0; asd < size; asd++)
            // {
            //     for(int dd = 0; dd < size; dd++)  {System.out.printf("%2d ", board[asd][dd]); }
            //     System.out.println();
            // }


            System.out.println(ans);
        }
        


    }
}