package com.fintech.demo;


class SubmitTask implements Runnable {

    private String name;
    public SubmitTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public void run() {
        try {
            System.out.println("Hello Its Runnable name "+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("End Task "+Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
