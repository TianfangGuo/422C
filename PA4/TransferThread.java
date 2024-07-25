class TransferThread extends Thread
{
    public TransferThread(Bank b, int from, int max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }
    public void run(){

    }

    private Bank bank;
    private int fromAccount;
    private int maxAmount;
}
