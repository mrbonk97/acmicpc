package gabia;

public class Gabia2 {
    public static void main (String [] args) {
        int x = 4;
        int ans = 0;
    

        for(int i = 1; i < x; i++)
        {
            ans += (x - i) * (x - i) * i;

        }

        System.out.println(ans);


    }
    
}
