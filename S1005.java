import java.util.*;
import java.io.*;

public class S1005 {

    public static void main(String [] args) throws Exception {
        System.setIn(new FileInputStream("input/1005.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int building_count = Integer.parseInt(st.nextToken());
            int rule_count = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int [] duration = new int [building_count];
            int [] indegree = new int [building_count];
            int [] time_spent = new int[building_count];
            List<List<Integer>> order = new ArrayList<>();
            for(int i = 0; i < building_count; i++) order.add(new ArrayList<>());

            for(int i = 0; i < building_count; i++) {
                duration[i] = Integer.parseInt(st.nextToken());
                time_spent[i] = duration[i];
            }

            for(int i = 0; i < rule_count; i++)
            {
                st = new StringTokenizer(br.readLine());
                int before = Integer.parseInt(st.nextToken()) - 1;
                int after = Integer.parseInt(st.nextToken()) - 1;

                indegree[after]++;
                order.get(before).add(after);
            }
            int winIdx = Integer.parseInt(br.readLine()) - 1;

            Queue<Integer> q = new LinkedList<>();

            for(int i = 0; i < building_count; i++) if(indegree[i] == 0) q.add(i);

            // for(var e: indegree) System.out.print(e + " " );
            // System.out.println();

            while(!q.isEmpty())
            {
                int cur = q.poll();
                for(var e: order.get(cur))
                {
                    indegree[e]--;
                    time_spent[e] = Math.max(time_spent[e], time_spent[cur] + duration[e]);
                    if(indegree[e] == 0)
                    {
                        q.add(e);
                        // System.out.println(e + " " + time_spent[e] + "before");
                        // time_spent[e] = Math.max(time_spent[e], time_spent[cur] + duration[e]);
                        // System.out.println(time_spent[e] + "afeter");
                    }
                }

            }
            // for(var e: duration) System.out.printf("%2d ", e);
            // System.out.println();
            // for(var e: time_spent) System.out.printf("%2d ", e);
            System.out.println(time_spent[winIdx]);


        }
    }
}