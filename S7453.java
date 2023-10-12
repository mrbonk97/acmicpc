import java.util.*;
import java.io.*;

class S7453 {
    
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/7453.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        HashSet<Integer> hs3 = new HashSet<>();
        HashSet<Integer> hs4 = new HashSet<>();

        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            hs1.add(Integer.parseInt(st.nextToken()));
            hs2.add(Integer.parseInt(st.nextToken()));
            hs3.add(Integer.parseInt(st.nextToken()));
            hs4.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;

        for(Integer e1: hs1)
            for(Integer e2: hs2)
                hm1.put(e1 + e2, hm1.getOrDefault(e1+e2, 0) + 1);
            
        for(Integer e1: hs3)
            for(Integer e2: hs4)
                hm2.put(e1 + e2, hm2.getOrDefault(e1+e2, 0) + 1);    
        
        for(var e: hm1.entrySet())
        {
            int x = 0 - e.getKey();
            int y = e.getValue();
            if(hm2.containsKey(x))
                ans += y * hm2.get(x);

        }


        System.out.println(ans);

    }
}