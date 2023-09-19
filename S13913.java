import java.util.*;
import java.io.*;

class S13919 {
    

    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/13919.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int MAX = Math.max(N, K);
        int [][] dp = new int[MAX + 1][2];

        for(int i = 0; i <= MAX; i++) { dp[i][0] = MAX; dp[i][1] = i; }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dp[N][0] = 0;

        while(!q.isEmpty())
        {
            int cur = q.poll();
            if(cur == K) break;

            if(cur + 1 <= MAX && dp[cur + 1][0] > dp[cur][0] + 1) {
                dp[cur + 1][0] = dp[cur][0] + 1; dp[cur + 1][1] = cur; q.add(cur + 1);}

            if(cur - 1 >= 0 && dp[cur - 1][0] > dp[cur][0] + 1) {
                dp[cur - 1][0] = dp[cur][0] + 1; dp[cur - 1][1] = cur; q.add(cur - 1);}

            if(cur*2 <= MAX && dp[cur*2][0] > dp[cur][0] + 1) {
                dp[cur * 2][0] = dp[cur][0] + 1; dp[cur * 2][1] = cur; q.add(cur * 2);}            
            
        }

        int parent = -1;

        System.out.println("\n==============");
        for(var e: dp) System.out.printf("%2d ", e[0]);
        System.out.println("\n==============");
        for(var e: dp) System.out.printf("%2d ", e[1]);
        System.out.println("\n==============");

        System.out.println(dp[K][1] + 1);

        while(parent != dp[K][1])
        {
            parent = dp[K][1];
            K = parent;
            System.out.print((K +1) + " ");
        }

        
        
    }
}
