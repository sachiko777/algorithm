package com.tools.Thread;

public class RunableTest {

    public static void main(String[] args){
        RunableDemo r1=new RunableDemo("t1");
        r1.start();
        RunableDemo r2=new RunableDemo("t2");
        r2.start();
    }

}

class RunableDemo implements Runnable{
    private Thread t;//线程
    private String threadName;//线程名

    RunableDemo(String name){
        threadName=name;
        System.out.println("创建线程: " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try{
            for (int i=4;i>0;i--){
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("线程 " +  threadName + " 中断.");
        }
        System.out.println("线程 " +  threadName + " 结束.");
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}
