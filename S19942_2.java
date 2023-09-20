import java.util.*;
import java.io.*;

class S19942_2 {
    static class Nu{
        int p, f, s, v, price;
        public Nu(int p, int f, int s, int v, int price){
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.price = price;
        }
        
    }
    static Nu m;
    static Nu [] nus;
    static int N;
    static boolean [] vis;
    static int ans = Integer.MAX_VALUE;
    static Stack<Integer> stack = new Stack<>();
    static List<Integer> al = new ArrayList<>();
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/19942.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nus = new Nu[N];
        vis = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int mp = Integer.parseInt(st.nextToken());
        int mf = Integer.parseInt(st.nextToken());
        int ms = Integer.parseInt(st.nextToken());
        int mv = Integer.parseInt(st.nextToken());
        m = new Nu(mp, mf, ms, mv, 0);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            nus[i] = new Nu(p, f, s, v, price);
        }

        
        for(int i = 0; i < N; i++) back(i+1 ,0);
        
        Collections.sort(al);
        // System.out.println(al.toString());

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(ans);
            for(var e: al) System.out.print(e + " ");
        }

    }

    public static void back(int startIdx, int cur) {

        if(m.p <= 0 && m.f <= 0 && m.s <= 0 && m.v <= 0 ) {
            if(cur < ans){
                ans = cur;
                al = new ArrayList<>();
                for(var e: stack) al.add(e + 1);

            }
            

            return;
        }        

        for(int i = startIdx; i < N; i++) {
            if(vis[i]) continue;
            m.p -= nus[i].p;
            m.f -= nus[i].f;
            m.s -= nus[i].s;
            m.v -= nus[i].v;
            stack.add(i);
            vis[i] = true;

            back(i,cur + nus[i].price);

            m.p += nus[i].p;
            m.f += nus[i].f;
            m.s += nus[i].s;
            m.v += nus[i].v;
            stack.pop();
            vis[i] = false;




        }


    }
}