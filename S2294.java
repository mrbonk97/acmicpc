import java.io.*;
import java.util.*;

public class S2294 {
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/2294.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = 100_000_000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] coin = new int[n];
        for(int i = 0; i < n; i++) coin[i] = Integer.parseInt(br.readLine());

        int purse1 [] = new int [k+1];
        Arrays.fill(purse1, MAX);
        purse1[k] = 0;

        for(int e: coin)
        {
            for(int i = k; i >= 0; i--)
            {
                if(purse1[i] == MAX) continue;
                if(i - e < 0) break;
                purse1[i-e] = Math.min(purse1[i] + 1, purse1[i-e]);
            }
            
        }

        
        if(purse1[0] == MAX) System.out.println(-1);
        else System.out.println(purse1[0]);




    }
}
