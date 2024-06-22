public class Q2{
    public static void foo(int n) {
         int x = 100;                           //1
         int y = 0;                             //1
         int outer = 1;
         for(int r = 1; r <= n; r = 2 * r) {    //1, log(n), log(n) + 1
            x = x + r;                          //
            outer++;
            int inner = 1;
            for(int c = 2; c < n; c++) {
                if(x > y / c)
                    y = y + r / c;
                else y = y - 1;
                inner++;
            }
            System.out.println("inner loop executed " + inner + " times");
         }
         System.out.println("outer loop executed " + outer + " times\n");
    }

    public static void main(String args[]){
        for (int n = 0; n < 10; n++){
            foo(n);
        }
    }
}
