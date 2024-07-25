class Bank
{
    public Bank(){
        this.accounts = new int[10];
        for(int i = 0; i < 10; i++){
            accounts[i] = 10000;
            System.out.println("initialized account " + i + " to " + accounts[i]);
        }   
        this.total = 100000;
        System.out.println("initial audit is $100,000");
        this.audit_signal = 0;
    }
    public void print_balances(){
        for(int i = 0; i < 10; i++){
            System.out.println(accounts[i]);
        }   
    }
    public void Transfer(int from, int to, int amount){
        System.out.println("transfering " + amount + " from account " + from + " to account " + to);
        this.accounts[from] -= amount;

        try {
            Thread.sleep (100);
        } catch (InterruptedException e) {
            //...
        }
        
        this.accounts[to] += amount;
            if(this.audit_signal%78 == 0){
                audit();
                this.audit_signal += 7;
            }
    }
    public int audit(){
        int sum = 0;
        for(int i : accounts){
            sum += i;
        }
        this.total = sum;
        System.out.println("========================audit total is " + total + "========================");

        return sum;
    }
    
    public int[] accounts;
    public int total;
    public int audit_signal;
            
}
