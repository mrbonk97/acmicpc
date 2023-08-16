import java.util.*;
import java.io.*;

class S15686 {
    static int [][] board;
    static List<int []> house = new ArrayList<>();
    static int [] survived;
    static int ans = Integer.MAX_VALUE;

    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/15686.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int cc = -sc;

        board = new int [y][y];
        List<int []> c = new ArrayList<>();
        

        for(int i = 0; i < y; i++)
        {   
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < y; j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) { c.add(new int [] {i,j}); cc++;}
                if(board[i][j] == 1) house.add(new int [] {i,j});
            }
        }
        survived = new int[sc];
        for(int i = 0; i < survived.length; i++) survived[i] = i;
    

        back(0, sc + cc, sc, c);

        System.out.println(ans);

        //하나씩 소거해야함
    }

    static void back(int idx, int length, int sc, List<int []> c) {
        //3 0
        if(sc == 0)
        {
            int curans = 0;
            for(int [] h: house)
            {
                int curLength = Integer.MAX_VALUE;
                for(int cidx: survived)
                {
                    int [] cur_chicken = c.get(cidx);
                    int l = Math.abs(cur_chicken[0] - h[0]) + Math.abs(cur_chicken[1] - h[1]);
                    // System.out.println(cur_chicken[0] + " " + cur_chicken[1] + " chicken_house");
                    // System.out.println(h[0] + " " + h[1] + " househouse " + l);
                    curLength = Math.min(curLength, l);
                }
                curans += curLength;

            }
            
            ans = Math.min(ans,curans);
            // for(var e: survived) System.out.print(e + " ");
            // System.out.println(curans);
            return;
        }

        for(int i = idx; i < length; i++)
        {
            survived[idx] = i;
            if(idx > 0 && survived[idx - 1] >= survived[idx]) continue;
            back(idx+1, length, sc-1, c);
            survived[idx] = -1;
        }





    }
}
