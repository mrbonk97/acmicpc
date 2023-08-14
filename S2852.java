import java.util.*;
import java.io.*;

class S2852 {
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/2852.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int goal = Integer.parseInt(br.readLine());

        int [] team = new int [3];
        int [] score = new int [3];
        int ct = 0;

        for(int i = 0; i < goal; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int goal_team = Integer.parseInt(st.nextToken());
            
            String time = st.nextToken();
            int h = Integer.parseInt(time.substring(0,2));
            int m = Integer.parseInt(time.substring(3, 5));
            int t = h*60 + m;


            if(score[1] > score[2] && ct != 0) team[1] += t - ct;
            if(score[2] > score[1] && ct != 0) team[2] += t - ct;
            
            score[goal_team]++;
            ct = t; 

        }

        if(score[1] > score[2]) team[1] += 48*60 - ct;
        if(score[2] > score[1]) team[2] += 48*60 - ct;


        if(team[1]/60 == 0) System.out.print("00");
        else if(team[1]/60 < 10) System.out.print("0" + team[1]/60);
        else System.out.print(team[1]/60);

        if(team[1]%60 == 0) System.out.print(":00");
        else if(team[1]%60 < 10) System.out.print(":0" + team[1]%60);
        else System.out.print(":" + team[1]%60);

        System.out.println();

        if(team[2]/60 == 0) System.out.print("00");
        else if(team[2]/60 < 10) System.out.print("0" + team[2]/60);
        else System.out.print(team[2]/60);

        if(team[2]%60 == 0) System.out.print(":00");
        else if(team[2]%60 < 10) System.out.print(":0" + team[2]%60);
        else System.out.print(":" + team[2]%60);


    }
}
