public class Portfolio{
    
    //attributes
    BankAccount checking;

    BankAccount savings;

    //constructor
    public Portfolio(){
        checking = new BankAccount();
        savings = new BankAccount();
    }

    //methods
    public void deposit(double amount, String account){
        if(account == "C"){
            this.checking.deposit(amount);        
        }  
        else if(account == "S"){
            this.savings.deposit(amount);
        }
        else{
            System.out.println("invalid account detected, must pass in 'S' or 'C'");
        }
    }

    public void withdraw(double amount, String account){
        if(account == "C"){
            this.checking.withdraw(amount);
        }  
        else if(account == "S"){
            this.savings.withdraw(amount);
        }
        else{
            System.out.println("invalid account detected, must pass in 'S' or 'C'");
        }    
    }

    public void transfer(double amount, String account){
        if(account == "C"){
            this.checking.withdraw(amount);
            this.savings.deposit(amount);
        }  
        else if(account == "S"){
            this.savings.withdraw(amount);
            this.checking.deposit(amount);
        }
        else{
            System.out.println("invalid account detected, must pass in 'S' or 'C'");
        }        
    }

    public double getBalance(String account){
        if(account == "C"){
            return this.checking.getBalance();
        }
        else if(account == "S"){
            return this.savings.getBalance();
        }   
        else{
            System.out.println("invalid account detected, must pass in 'S' or 'C'");
        }
    }
}
