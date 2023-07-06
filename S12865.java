import java.util.*;
import java.io.*;

public class S12865 {
    
    public static void main(String [] args) throws Exception {
        System.setIn(new FileInputStream("input/12865.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int item = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());

        int [] b = new int[bag + 1];

        for(int i = 0; i < item; i++)
        {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 6 13

            for(int j = bag; j >= 0; j--)
            {
                if(j + w > bag) continue;
                b[j + w] = Math.max(b[j+w], b[j] + v);
            }

            
        }

        int max = 0;
        for(var e: b) if(e > max) max = e;
        System.out.println(max);


    }
}
