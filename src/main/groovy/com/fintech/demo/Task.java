package com.fintech.demo;

import java.util.Date;

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Doing a task during : " + name + " - Date - " + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
