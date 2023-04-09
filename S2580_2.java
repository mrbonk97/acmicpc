import java.util.*;
import java.io.*;

public class S2580_2 {
    static int [][] board = new int[9][9];
    public static void main(String [] args) throws Exception {
        System.setIn(new FileInputStream("res/input2580.txt"));
        System.out.println("asd");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 받기
        for(int i = 0; i < 9; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
            
        }
    }


    public static void backtrack(int i, int j) {
        if(j == 9) { i++; j = 0;}
        if(i == 9) System.exit(0);
        
        if(board[i][j] != 0) backtrack(i, j+1);

        for(int num = 1; num <= 9; num++)
        {
            board[i][j] = num;
            if(validate(i, j)) backtrack(i, j+1);
        }
        
    }

    public static boolean validate(int i, int j){
        //가로로 검사
        for(int idx = 0; idx < 9; idx++)
        {
            if(idx == j) continue;
            if(board[i][idx] == board[i][j]) return false;
        }
        
        //세로로 검사
        for(int idx = 0; idx < 9; idx++)
        {
            if(idx == i) continue;
            if(board[idx][j] == board[i][j]) return false;
        }
        //블락 검사
        int starti = i / 3;
        int startj = j / 3;
        if(board[i][j] == board[starti][startj])        if(i != starti || j != startj) return false;
        if(board[i][j] == board[starti][startj + 1])    if(i != starti || j != startj) return false;
        if(board[i][j] == board[starti][startj + 2])    if(i != starti || j != startj) return false;
        if(board[i][j] == board[starti + 1][startj])    if(i != starti || j != startj) return false;
        
        if(board[i][j] == board[starti + 1][startj + 1])if(i != starti || j != startj) return false;
        if(board[i][j] == board[starti + 1][startj + 2])if(i != starti || j != startj) return false;
        if(board[i][j] == board[starti + 2][startj])    if(i != starti || j != startj) return false;
        if(board[i][j] == board[starti + 2][startj + 1])if(i != starti || j != startj) return false;
        if(board[i][j] == board[starti + 2][startj + 2])if(i != starti || j != startj) return false;

        return true;
    }
}