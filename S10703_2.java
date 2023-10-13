import java.util.*;
import java.io.*;

class S10703_2 {
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/10703.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char [][] board = new char [y][x];

        int [] stone = new int [x];
        int [] ground = new int [x];

        Arrays.fill(stone, -1);
        Arrays.fill(ground, -1);

        for(int i = 0; i < y; i++)
        {
            board[i] = br.readLine().toCharArray().clone();
            for(int j = 0; j < x; j++) 
            {
                if(board[i][j] == 'X') stone[j] = i;
                if(ground[j] != -1) continue; 
                if(board[i][j] == '#') ground[j] = i; 
                
            }   
            
        }

        
        int depth = Integer.MAX_VALUE;
        
        for(int i = 0; i < x; i++)
        {
            if(stone[i] == -1) continue;
            if(ground[i] - stone[i] - 1 < depth) depth = ground[i] - stone[i] - 1;
        }

        ///////


        //////

        for(int j = 0; j < x; j++)
        {
            if(stone[j] == -1) continue;
            for(int i = y-1; i >= 0; i--)
            {
                if(board[i][j] == 'X')
                {
                    if(board[i+depth][j] == '#') continue;
                    board[i+depth][j] = board[i][j];
                    board[i][j] = '.';
                }
                
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char [] e: board)
        {
            for(char e2: e) sb.append(e2);
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
        
        




    }
}
