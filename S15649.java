import java.util.*;
import java.io.*;

class S15649 {
    static boolean [] taken;
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/15649.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int [m];
        taken = new boolean [n + 1];

        BackTrack(0, n, arr);
        

    }

    static void BackTrack(int idx, int n, int [] arr) {
        if(idx == arr.length)
        {
            for(var e: arr) System.out.print(e +" ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++ )
        {
            if(taken[i]) continue;
            arr[idx] = i;
            taken[i] = true;
            BackTrack(idx + 1, n, arr);
            taken[i] = false;
        }

    }
}