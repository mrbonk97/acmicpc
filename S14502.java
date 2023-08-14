import java.util.*;
import java.io.*;

class S14502 {
    static int [][] board;
    static int [] dy = new int [] {1,0,-1,0};
    static int [] dx = new int [] {0,1,0,-1};
    static int y, x;

    static class coor {
        int y, x;
        public coor(int y, int x) {this.y = y; this.x =x;}
    }
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/14502.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        board = new int [y][x];
        List<coor> virus = new ArrayList<>();

        for(int i = 0; i < y; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++) 
            {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) virus.add(new coor(i,j)); 
            }
        }

        pb();
        calc(virus);

        
    }

    public static void pb() {
        for(var e: board)
        {
            for(var e2: e) System.out.printf("%d ", e2);
            System.out.println();
        }
    }

    public static void calc(List<coor> al ) {
        int count = 0;
        Queue<coor> q = new LinkedList<>();
        for(coor e : al) q.add(e);

        while(!q.isEmpty())
        {
            coor cur = q.poll();

            for(int dir = 0; dir < 4; dir++)
            {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                if(ny < 0 || nx < 0 || ny >= y || nx >= x) continue;
                if(board[ny][nx] != 0) continue;

                q.add(new coor(ny,nx));
                board[ny][nx] = 2;
            }


        }

        System.out.println();
        for(int [] e: board)
        {
            for(int e2 : e)
            {
                if(e2 == 0) count++;
                System.out.print(e2 + " ");
            }
            System.out.println();
        }

        System.out.println(count);

        

    }
}