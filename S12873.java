import java.util.*;
import java.io.*;

class S12873 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 3;
        int left = N;
        boolean [] people = new boolean [N];
        int nextT = 0;

        int round = 1;
        while(left > 1)
        {
            int cur = round * round * round;
            int d = (nextT + cur) % left;
            while(people[d]) d = (d + 1) % N;
            

            System.out.println();
            for(var e: people) System.out.print(e + " ");
            System.out.println();
            
            round++; left--;
        }

    }
}