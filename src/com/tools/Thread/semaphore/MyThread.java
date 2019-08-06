package com.tools.Thread.semaphore;

public class MyThread extends Thread{
    private SemaphoreService semaphoreService;

    public  MyThread(String name,SemaphoreService semaphoreService){
        super();
        this.setName(name);
        this.semaphoreService=semaphoreService;
    }

    @Override
    public void run(){
        this.semaphoreService.doSomething();
    }
}
