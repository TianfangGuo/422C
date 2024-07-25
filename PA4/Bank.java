class Bank
{
    public Bank(){
        accounts = new int[10];
        for(int i : accounts){
            i = 10000;
        }   
        total = 100000;
    }
    public void Transfer(int from, int to, int amount){
        accounts[from] -= amount;
        Thread.sleep(10);
        account[to] += amount;
        audit();
    }
    public void audit(){
        int sum = 0;
        for(int i : accounts){
            sum += i;
        }
        total = sum;
    }
    
    private int[] accounts;
    private int total;
            
}
