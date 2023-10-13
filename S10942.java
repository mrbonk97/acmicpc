import java.util.*;
import java.io.*;

class S10942 {
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/10942.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int [] arr = new int [size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean [] pOdd = new boolean [size];

        for(int i = 1; i < size; i++)
        {
            // i = 중심의 위치
            for(int j = 0; j < size; j++)
            {
                if(pOdd[i - j] == pOdd[i+j]) continue;
                

            }
        }


        
    }
}