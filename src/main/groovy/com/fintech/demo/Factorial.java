package com.fintech.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class Factorial implements Callable<Integer>
{

    private Integer number;

    public Factorial(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }
}
