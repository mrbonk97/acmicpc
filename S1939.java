import java.util.*;
import java.io.*;

class S1939 {
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/1939.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // int [][] board = new int [N+1][N+1];

        List<List<int[]>> board = new ArrayList<>();
        for(int i = 0; i <= N; i++) board.add(new ArrayList<>());

        for(int i = 0; i <M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            board.get(a).add(new int[] {b,c});
            board.get(b).add(new int[] {a,c});
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int desti = Integer.parseInt(st.nextToken());

        int [] dist = new int [N+1];
        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(var e2 : board.get(cur));
            {
        //         // int e = e2[0];

        //         // System.out.println(cur + " " + e);
        //         if(board[cur][e] == 0) continue;

        //         if(board[cur][e] < dist[e])
        //         {
        //             // System.out.println(cur + " " + e + " " + board[cur][e] + " " + dist[e]);
        //             dist[e] = Math.min(board[cur][e], dist[e]);
        //             q.add(cur);
        //         }
        //     }

        // }

        // System.out.println(dist[desti]);

        // // for(var e: dist) System.out.print(e +" ang");
        // // System.out.println();
        // // for(var e: board) { for(var e2: e) System.out.print(e2 + " "); System.out.println();}
        



        }

    }
}