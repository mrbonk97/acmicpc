import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class S1450{
    public static void main(String [] args) throws Exception{
        System.setIn(new FileInputStream("input/1450.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int item_count = Integer.parseInt(st.nextToken());
        int bag_size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] a = new int [item_count];

        for(int i = 0; i < item_count; i++) a[i] = Integer.parseInt(st.nextToken());

        
        


        
    }
}