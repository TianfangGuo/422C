public class PortfolioTester{

    public static void main(String[] args){
        Portfolio test = new Portfolio();
        System.out.printf("%f\n", test.getBalance("S"));
        System.out.printf("%f\n", test.getBalance("C"));
        System.out.printf("%f\n", test.getBalance("badinput"));

        test.deposit(69, "C");
        test.deposit(420, "S");
        test.deposit(1337, "badinput");
        System.out.printf("%f\n", test.getBalance("S"));
        System.out.printf("%f\n", test.getBalance("C"));
        System.out.printf("%f\n", test.getBalance("badinput"));

        test.withdraw(1, "C");
        test.withdraw(2, "S");
        test.withdraw(3, "badinput");
        System.out.printf("%f\n", test.getBalance("S"));
        System.out.printf("%f\n", test.getBalance("C"));
        System.out.printf("%f\n", test.getBalance("badinput"));

        test.transfer(30, "C");
        test.transfer(20, "S");
        test.transfer(10, "badinput");
        System.out.printf("%f\n", test.getBalance("S"));
        System.out.printf("%f\n", test.getBalance("C"));
        System.out.printf("%f\n", test.getBalance("badinput"));


    }
}
