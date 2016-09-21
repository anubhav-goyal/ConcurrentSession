package com.fintech.demo;

class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " End.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
