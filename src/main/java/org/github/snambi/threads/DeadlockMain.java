package org.github.snambi.threads;

public class DeadlockMain {

    public static void main( String[] args ){

        try {
            System.out.printf("Starting the program");
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
