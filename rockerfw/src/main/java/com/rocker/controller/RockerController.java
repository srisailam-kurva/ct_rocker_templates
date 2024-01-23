package com.rocker.controller;

import com.rocker.service.RockerService;
import com.rocker.service.RockerTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RockerController {

    @Autowired
    private RockerService rockerService;

    @Autowired
    private RockerTempService rockerTempService;
    @GetMapping("/get")
    public String getRockerTemplate() throws InterruptedException {
        int numberOfThreads = 50;
        int numberOfTasks = 10000;
        String s="done";

        Thread[] threads = new Thread[numberOfThreads];

        //start time
        long startTime = System.currentTimeMillis();

        // start the threads
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numberOfTasks / numberOfThreads; j++) {
                    rockerService.getTemplate();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        //end time
        long endTime = System.currentTimeMillis();

        //total time taken
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime + " milliseconds");
        return s;
    }

    @GetMapping("/getByPath")
    public String getRockerTemplateByPath() throws InterruptedException {
        int numberOfThreads = 50;
        int numberOfTasks = 10000;
        String s="completed";

        Thread[] threads = new Thread[numberOfThreads];

        //start time
        long startTime = System.currentTimeMillis();

        // start the threads
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numberOfTasks / numberOfThreads; j++) {
                    rockerTempService.loadTemplateByPath();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        //end time
        long endTime = System.currentTimeMillis();

        //total time taken
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime + " milliseconds");

        return s;
    }
}
