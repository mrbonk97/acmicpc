import java.util.*;
import java.io.*;

public class S1987 {
    static int y = 0;
    static int x = 0;
    static int [] alpa = new int [26];
    static char [][] board;
    static int [] dy = new int [] {1,0,-1,0};
    static int [] dx = new int [] {0,1,0,-1};

    static int max = Integer.MIN_VALUE;
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/1987.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        board = new char [y][x];
        for(int i = 0; i < y; i++)
        {
            char [] c = br.readLine().toCharArray();
            for(int j = 0; j < x; j++) board[i][j] = c[j];
        }

        int [] start = new int [] {0,0};

        // for(var e: board) { for(var e2: e) System.out.print(e2 + " "); System.out.println();}

        alpa[board[0][0] - 65] = 1;
        back(start, 1);
        System.out.println(max);
    }

    public static void back(int [] cur, int depth) {

        max = Math.max(max, depth);
        
        for(int dir = 0; dir < 4; dir++)
        {
            int ny = dy[dir] + cur[0];
            int nx = dx[dir] + cur[1];
            if(ny < 0 || nx < 0 || ny >= y || nx >= x) continue;
            int letter = board[ny][nx] - 65;
            if(alpa[letter] == 1) continue;
            alpa[letter] = 1;
            back(new int [] {ny, nx}, depth + 1);
            alpa[letter] = 0;
        }
        

    }
}
