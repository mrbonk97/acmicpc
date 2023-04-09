import java.util.*;
import java.io.*;

public class S2580 {
    static int [][] board = new int[9][9];
    public static void main(String [] args) throws Exception {
        System.setIn(new FileInputStream("res/input2580.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 받기
        for(int i = 0; i < 9; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);
        
    }


    public static void backtrack(int i, int j) {
        if(j == 9) { backtrack(i+1, 0); return; }
        if(i == 9)
        {
            StringBuilder sb = new StringBuilder();

            for(int ii = 0; ii < 9; ii++)
            {
                for(int jj = 0; jj < 9; jj++)
                    sb.append(board[ii][jj] + " " );
                 sb.append("\n");        
            }

            System.out.println(sb);
            System.exit(0);
        }
        
        if(board[i][j] == 0)
        {
            System.out.println(i + " " + j);
            for(int num = 1; num <= 9; num++)
            {
                if(validate(i, j, num))
                {
                    board[i][j] = num;
                    backtrack(i, j+1);
                }
            }
            // board[i][j] = 0;
            return;
        }
        backtrack(i, j + 1);

    }

    public static boolean validate(int i, int j, int v){

        for(int idx = 0; idx < 9; idx++)
            if(board[i][idx] == v) return false;
        
        for(int idx = 0; idx < 9; idx++)
            if(board[idx][j] == v) return false;
        
        int set_i = (i/3) * 3;
        int set_j = (j/3) * 3;
        
        for(int ii = set_i; ii < set_i + 3; ii++)
            for(int jj = set_j; jj < set_j + 3; jj++)
                if(board[ii][jj] == v) return false;

        return true;
    }
}