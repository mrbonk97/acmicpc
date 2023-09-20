import java.util.*;

class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int [][] board = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++) Arrays.fill(board[i], 10_000);
        for(int i = 0; i < n+1; i++) board[i][i] = 0;
        for(var e: roads)
        {
            board[e[0]][e[1]] = 1;
            board[e[1]][e[0]] = 1;
        }
        
        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                {
                    if(board[i][k] == 10_000) continue;
                    if(board[k][j] == 10_000) continue;
                    if(board[i][j] > board[i][k] + board[k][j])
                    {
                        board[i][j] = board[i][k] + board[k][j];
                        board[j][i] = board[i][k] + board[k][j];
                    }
                }
        
        // for(var e: board) { for(var e2: e) System.out.printf("%5d ", e2); System.out.println(); }
        
        
        int [] ans = new int [sources.length];
        for(int i = 0; i < ans.length; i++)
        {
            int e = sources[i];
            ans[i] = board[destination][e];
            if(ans[i] == 10_000) ans[i] = -1;
        }
        
        
        // for(var e: ans) System.out.print(e + " ");
        
        
        

        
        
        
        
        return ans;
    }
}