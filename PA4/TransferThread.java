import java.util.Random;

class TransferThread extends Thread
{
    public TransferThread(Bank b, int from, int max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }
    public void run(){
        int audit_signal = 0;

        for(int i = 0; i < 25; i++){
            Random r = new Random();
            bank.audit_signal++;
            bank.Transfer(fromAccount, r.nextInt(10), maxAmount);
            // audit_signal++;
            // if(audit_signal == 5){
            //     audit_signal = 0;
            //     bank.audit();
            // }
        }
    }
    public static void main(String[] args){
        Bank b = new Bank();
        Thread bank1 = new TransferThread(b, 0, 422);
        Thread bank2 = new TransferThread(b, 1, 145);
        Thread bank3 = new TransferThread(b, 2, 562);
        Thread bank4 = new TransferThread(b, 3, 28);
        Thread bank5 = new TransferThread(b, 4, 146);
        Thread bank6 = new TransferThread(b, 5, 66);
        Thread bank7 = new TransferThread(b, 6, 7);
        Thread bank8 = new TransferThread(b, 7, 290);
        Thread bank9 = new TransferThread(b, 8, 567);
        Thread bank10 = new TransferThread(b, 9, 12);

        bank1.start();
        bank2.start();
        bank3.start();
        bank4.start();
        bank5.start();
        bank6.start();
        bank7.start();
        bank8.start();
        bank9.start();
        bank10.start();
        
    }

    private Bank bank;
    private int fromAccount;
    private int maxAmount;
}
