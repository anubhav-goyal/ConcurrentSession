package com.fintech.demo

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class ConcurrentController {

    def simple() {
        ExecutorService executorService = Executors.newFixedThreadPool(5)
        0.upto(9) {i->
            Runnable worker = new WorkerThread("${i+1}")
            executorService.execute(worker)
        }
        executorService.shutdown()
        while (!executorService.isTerminated()) {
        }
        println("Finished all threads")
        render "Success"
    }

    def schedule() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2)
        Task task1 = new Task("Demo Task 1")
        Task task2 = new Task("Demo Task 2")

        println("The time is : ${new Date()}")

        executorService.schedule(task1, 5, TimeUnit.SECONDS)
        executorService.schedule(task2, 10, TimeUnit.SECONDS)

        println("TimeUnit Seconds ${TimeUnit.SECONDS}")
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS)
            println("End")
        } catch (InterruptedException e) {
            e.printStackTrace()
        }

        executorService.shutdown()
        render "success"
    }

    def scheduleAtTime() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1)
        Task task1 = new Task("Demo Task Schedule")

        println("The time is : ${new Date()}")

        executorService.scheduleAtFixedRate(task1, 2, 4, TimeUnit.SECONDS)

        try {
            TimeUnit.MILLISECONDS.sleep(10000)
        }
        catch (InterruptedException e) {
            e.printStackTrace()
        }

        executorService.shutdown()
        render "success"
    }

    def runable() {
        ExecutorService executorService = Executors.newFixedThreadPool(2)
        List<Future> futureList = []
        0.upto(9) { i ->
            SubmitTask submitTask = new SubmitTask("Future Runnable ${i + 1}")
            Future future = executorService.submit(submitTask)
            println("Future :===== ${future.get()}")
//            futureList.add(future)
        }
        executorService.shutdown()
        render "Success"
    }

    def future() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();

        0.upto(3) {
            Integer number = random.nextInt(10);
            Factorial factorial = new Factorial(number);
            Future<Integer> result = executorService.submit(factorial);
            resultList.add(result);
        }

        for (Future<Integer> future : resultList) {
            try {
                println("Future result is -   ${future.get()}")
            }
            catch (Exception e) {
                e.printStackTrace()
            }
        }
        executorService.shutdown()
        render "Success"
    }

}
