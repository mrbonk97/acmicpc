import java.io.*;
import java.util.*;

public class S2056 {
    public static void main(String [] args) throws Exception{
        System.setIn(new FilecleInputStream("input/2056.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> job = new ArrayList<>();
        for(int i = 0; i < n; i++) job.add(new ArrayList<>());

        Queue<Integer> nextJob = new LinkedList<>();
        int [] duration = new int[n];
        int [] indegree = new int[n];
        int [] result   = new int[n];

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            duration[i] = Integer.parseInt(st.nextToken());
            indegree[i] = Integer.parseInt(st.nextToken());
            if(indegree[i] == 0) {result[i] = duration[i]; nextJob.add(i); }

            for(int j = 0; j < indegree[i]; j++) job.get(Integer.parseInt(st.nextToken()) - 1).add(i);
        }
        

        while(!nextJob.isEmpty())
        {
            int cur = nextJob.poll();
            for(int e: job.get(cur))
            {
                indegree[e]--;
                if(indegree[e] == 0) nextJob.add(e);

                result[e] = Math.max(result[e],result[cur] + duration[e]);
            }
        }

        // for(var e: duration) System.out.print(e + " ");
        // System.out.println();
        // for(var e: result) System.out.print(e + " ");
        int max = Integer.MIN_VALUE;
        for(int e: result) max = Math.max(max, e);
        System.out.println(max);

        
    }
}
