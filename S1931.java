import java.util.*;
import java.io.*;

public class S1931 {
    public static void main(String [] args) throws Exception {
        System.setIn(new FileInputStream("input/1931.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        List<int []> meeting = new ArrayList<>(); // [0] = 시작시간, [1] = 끝나는 시간

        for(int i = 0; i < length; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] m = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            meeting.add(m);
        }

        Collections.sort(meeting, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int count = 0;
        int curEnd = 0;

        // for(var e: meeting)
        // {
        //     for(var e2: e) System.out.print(e2 + " ");
        //     System.out.println();
        // }
        

        for(var e: meeting)
        {   
            if(e[0] >= curEnd) { count++; curEnd = e[1]; }
        }

        System.out.println(count);

    }
}
