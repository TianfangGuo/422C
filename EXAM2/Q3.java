import java.util.*;

public class Q3{
    
    //queue implementation
    private static class innerQueue{
        Queue<String> queue = new LinkedList<>();
        Object lock = new Object();

        public void add(String s){
            synchronized(lock){
                while(queue.size() == 10){
                    try{
                        lock.wait();
                    }
                    catch(InterruptedException e){}
                }
                queue.add(s);
                lock.notifyAll();
            }
        }

        public String remove(){
            synchronized(lock){
                while(queue.size() == 0){
                    try{
                        lock.wait();
                    }
                    catch(InterruptedException e){}
                }
                String s = queue.remove();
                lock.notifyAll();
                return s;
            }
        }
    }

    //producer thread
    private static class producer implements Runnable{
        private innerQueue queue;

        //constructor
        public producer(innerQueue queue){
            this.queue = queue;
        }

        @Override public void run(){
            for(int i = 0; i < 100; i++){
                String s = new Date().toString();
                this.queue.add(s);
            }
        }

    }

    //consumer thread
    private static class consumer implements Runnable{
        private innerQueue queue;

        //constructor
        public consumer(innerQueue queue){
            this.queue = queue;
        }

        @Override public void run(){
            for(int i = 0; i < 100; i++){
                String s = this.queue.remove();
                System.out.println(s);
            }
        }

    }


    //tester, this should print out 100 lines of time
    //works for me on my computer
    public static void main(String[] args) {
        innerQueue queue = new innerQueue();
        producer Producer = new producer(queue);
        consumer Consumer = new consumer(queue);

        Thread producerThread = new Thread(Producer);
        Thread consumerThread = new Thread(Consumer);

        producerThread.start();
        consumerThread.start();


        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

}