import java.util.*;
import java.io.*;

class S10703 {
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/10703.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char [][] board = new char [y][x];

        boolean [][] stone_board = new boolean[y][x];

        int [] stone = new int [x];
        int [] ground = new int [x];

        Arrays.fill(stone, -1);
        Arrays.fill(ground, -1);

        for(int i = 0; i < y; i++) Arrays.fill(board[i], '.');



        for(int i = 0; i < y; i++)
        {
            char [] line = br.readLine().toCharArray();
            for(int j = 0; j < x; j++) 
            {
                if(line[j] == 'X')
                {
                    stone[j] = i;
                    stone_board[i][j] = true;
                }
                if(line[j] == '#') 
                {
                    board[i][j] = line[j];
                    if(ground[j] != -1) continue; 
                    ground[j] = i; 
                }
            }   
            
        }

        
        int depth = Integer.MAX_VALUE;
        
        for(int i = 0; i < x; i++)
        {
            if(stone[i] == -1) continue;
            if(ground[i] - stone[i] - 1 < depth) depth = ground[i] - stone[i] - 1;
        }
        
        for(int i = 0; i < y; i++)
        {
            for(int j = 0; j < x; j++)
            {
                if(stone_board[i][j] == true) board[i+depth][j] = 'X';
            }
        }
        for(var e: board) {for(var e2: e) System.out.print(e2 + " "); System.out.println();}
        
        // System.out.println(depth);

        // System.out.println("==========");
        // for(var e: stone) System.out.printf("%2d ", e);
        // System.out.println();
        // for(var e: ground) System.out.printf("%2d ", e);




    }
}
