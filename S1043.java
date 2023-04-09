import java.util.*;
import java.io.*;

public class S1043 {
    static BufferedReader br;
    static StringTokenizer st;

    static List<List<Integer>> party = new ArrayList<>();
    static HashMap<Integer, Integer> truth = new HashMap<>();
    static HashMap<Integer, Integer> lied = new HashMap<>();

    static int N, M, max = 0;

    
    public static void main(String [] args) throws Exception {
        System.setIn(new FileInputStream("res/input1043.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for(int i = 1; i <= N; i++)
        {
            truth.put(i, 0);
            lied.put(i, 0);
        }

        while(st.hasMoreTokens()) truth.put(Integer.parseInt(st.nextToken()), 1);

        for(int i = 0; i < M; i++)
        {
            party.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreTokens()) party.get(i).add(Integer.parseInt(st.nextToken()));
        }

        backtrack(0, 0);
        System.out.println(max);

    }

    public static void pp(){
        // System.out.println("truth :" + truth.toString());
        // System.out.println("lied :" + lied.toString());
        // System.out.println();
    }

    public static void backtrack(int level, int total) {


        if(level == M)
        {
            max = Math.max(max, total);
            return;
        }

        boolean manLie = false;
        boolean manTruth = false;

        for(var e: party.get(level))
        {
            if(truth.get(e) > 0) manTruth = true;
            if(lied.get(e) > 0) manLie = true;
        }

        if(manLie && manTruth)
        {
            // System.out.println("망함 ");
            pp();
            return;
        }

        if(manLie == true && manTruth == false)
        {
            
            for(var e: party.get(level)) lied.put(e, lied.get(e) + 1);
            // System.out.println("반드시 거짓 " + party.get(level).toString());
            pp();

            backtrack(level + 1, total + 1);
            for(var e: party.get(level)) lied.put(e, lied.get(e) - 1);
        }

        if(manTruth == true && manLie == false)
        {
            for(var e: party.get(level)) truth.put(e, truth.get(e) + 1);
            // System.out.println("반드시 진실 " + party.get(level).toString());
            pp();
            backtrack(level +1, total);
            for(var e: party.get(level)) truth.put(e, truth.get(e) - 1);
        }

        if(manLie == false && manTruth == false)
        {
            for(var e: party.get(level)) lied.put(e, lied.get(e) + 1);
            // System.out.println("선택 거짓 " + party.get(level).toString());
            pp();
            backtrack(level + 1, total + 1);
            for(var e: party.get(level)) lied.put(e, lied.get(e) - 1);

            for(var e: party.get(level)) truth.put(e, truth.get(e) + 1);
            // System.out.println("선택 진실 " + party.get(level).toString());
            pp();
            backtrack(level +1, total);
            for(var e: party.get(level)) truth.put(e, truth.get(e) - 1);
        }

        

    }
}