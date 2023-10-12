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

        int [][] p = new int [size][size];
        int [][] p2 = new int [size][size];

        for(int i = 0; i < size; i++) {
            // 팰린드롬의 기준점, 중심이 1개인 홀수 팰린드롬으로 가정한다.
            int count = 0;
            for(int j = 0; j < size; j++)
            {
                if(i - j < 0 || i + j >= size) break;
                if(arr[i-j] != arr[i+j]) break;
                p[i-j][i+j] = 1 + count*2;
                count++;
            }
        }

        for(int i = 0; i < size; i++) {
            // 팰린드롬의 기준점, 중심이 2개인 짝수 팰린드롬으로 가정한다.
            int count = 0;
            for(int j = 0; j < size; j++)
            {
                if(i - j < 0 || i + j + 1 >= size) break;
                if(arr[i-j] != arr[i+j + 1]) break;
                p2[i-j][i+j + 1] = 1 + count*2;
                count++;
            }
        }

        for(var e : p) { for(var e2: e) System.out.print(e2 + " "); System.out.println();}

        int N = Integer.parseInt(br.readLine());
    }
}