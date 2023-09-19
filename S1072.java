import java.io.FileInputStream;
import java.util.Scanner;

public class S1072 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/1072.txt"));
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = getPercent(x, y);
        System.out.println(z);

        int ans = -1;
        int left = 0;
        int right = (int) 1e9;

        System.out.println(getPercent(x + 500000000, y + 500000000));
        long asd = (long)(y + 500000000) * 100;
        long aaa = x + 500000000;
        System.out.println(asd + " " + aaa + " " + asd/aaa);
        
        System.out.println((int) ((long) (y + 500000000) * 100 / (x + 500000000)));
        System.out.println();
        while (left <= right) {
            int mid = (left + right) / 2;

            System.out.println(mid + " : " + left + " / " + right + "  " + getPercent(x + mid, y + mid));

            if (getPercent(x + mid, y + mid) > z) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
