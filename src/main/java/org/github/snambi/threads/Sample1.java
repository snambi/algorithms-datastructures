package org.github.snambi.threads;

public class Sample1 {

    static Integer counter = 0;

    public static void main(String[] args){

        Thread1 t1 = new Thread1(counter);
        Thread t2 = new Thread(new Runnable2(counter));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static class Thread1 extends Thread{

        Integer counter;

        public Thread1(Integer c){
            this.counter = c;
        }
        public void run(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Running 1");
        }
    }

    public static class Runnable2 implements Runnable{

        Integer counter;

        public Runnable2(Integer c){
            this.counter = c;
        }
        @Override
        public void run() {
            System.out.println("Running 2");
        }
    }
}
