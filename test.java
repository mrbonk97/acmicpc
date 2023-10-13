import java.util.Date;

class test{
    public static void main(String[] args) {
        
        Date d1 = new Date();
        Date d2 = new Date();
        int x = 0;
        

        for(int i = 0; i < 100000000; i++)
        {
            x++;
            d2 = new Date();
        }
        

        System.out.println(d1);
        System.out.println(d2);

        System.out.println(d2.before(d1));
        System.out.println(d2.before(d2));
        System.out.println(d1.before(d2));

        System.out.println(d1.after(d2));


    }
}