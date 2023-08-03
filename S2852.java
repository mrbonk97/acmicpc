import java.util.*;
import java.io.*;

class S2852 {
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/2852.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int goal = Integer.parseInt(br.readLine());

        int [] team = new int [3];
        int [] score = new int [2];
        int ct = 0;
        int lead = 2;
        int goal_team = 2;

        for(int i = 0; i < goal; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            goal_team = Integer.parseInt(st.nextToken()) - 1;
            
            String time = st.nextToken();
            int h = Integer.parseInt(time.substring(0,2));
            int m = Integer.parseInt(time.substring(3, 5));
            int t = h*60 + m;


            if(score[0] > score[1] && ct != 0) team[0] += t - ct;
            if(score[1] > score[0] && ct != 0) team[1] += t - ct;
            
            score[goal_team]++;
            ct = t; 

        }

        if(score[0] > score[1]) team[0] += 48*60 - ct;
        if(score[1] > score[0]) team[1] += 48*60 - ct;


        if(team[0]/60 < 10) System.out.print("0" + team[0]/60);
        else System.out.print(team[0]/60);
        if(team[0]%60 < 10) System.out.print(":0" + team[0]%60);
        else System.out.print(":" + team[0]%60);

        System.out.println();

        if(team[1]/60 < 10) System.out.print("0" + team[1]/60);
        else System.out.print(team[1]/60);
        if(team[1]%60 < 10) System.out.print(":0" + team[1]%60);
        else System.out.print(":" + team[1]%60);


    }
}
