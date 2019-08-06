package com.tools.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//桌上有一只盘子，每次只能放一个水果，爸爸专向盘中放苹果，妈妈专向盘中放桔子，
//儿子专等吃盘里的桔子，女儿专等吃盘里的苹果。只要盘子空，则爸爸或妈妈可向盘中放水果，
// 仅当盘中有自己需要的水果时，儿子或女儿可从中取出，请给出四人之间的同步关系，并用PV操作实现四人正确活动的程序。
public class GetApple {
    public static void main(String[] args) {
        Resource r = new Resource();

        FatherPut fa = new FatherPut(r);
        MotherPut mo = new MotherPut(r);
        SonEat son = new SonEat(r);
        DaughterEat dau = new DaughterEat(r);

        Thread t0 = new Thread(fa);
        Thread t1 = new Thread(mo);
        Thread t2 = new Thread(son);
        Thread t3 = new Thread(dau);
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }


}

class Resource{
    private String name;
    private static int ap=0;//苹果
    private static int or=0;//橘子
    private static int pz=0;//盘子

    Lock lock =new ReentrantLock();//锁

    Condition parent_lock=lock.newCondition();//父母监视器
    Condition son_lock=lock.newCondition();
    Condition daughter_lock=lock.newCondition();

    // 放水果,i=1表示是爸爸，i=2表示是妈妈
    void put(String name, int i) {
        lock.lock();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (pz == 1) // 盘子有水果
            {
                try {
                    parent_lock.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i == 1) // 爸爸
            {
                ap = 1;
                pz = 1;
                this.name = name; // 此处赋值防止线程中断名字不符（错乱）
                System.out.println(this.name + "放苹果");
                son_lock.signal();
            } else if (i == 2) // 妈妈
            {
                or = 1;
                pz = 1;
                this.name = name; // 此处赋值防止线程中断名字不符（错乱）
                System.out.println(this.name + "放橘子");
                daughter_lock.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    // 吃水果,i=1表示是儿子，i=2表示是女儿
    void eat(String name ,int i){
        lock.lock();//获取锁资源，如果没有争抢到，进入阻塞状态。
        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            while (i==1){//儿子
                while (ap==0){
                    try {
                        son_lock.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                ap=0;
                pz=0;
                this.name=name;
                System.out.println(this.name + "吃苹果");
                parent_lock.signal();
            }
            while (i==2){//女儿
                while (or == 0) {
                    try {
                        daughter_lock.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                or = 0;
                pz = 0;
                this.name = name; // 此处赋值防止线程中断名字不符（错乱）
                System.out.println(this.name + "吃橘子");
                parent_lock.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class FatherPut implements Runnable{
    private Resource r;
    FatherPut(Resource r){
        this.r=r;
    }

    @Override
    public void run() {
        while (true){
            r.put("爸爸",1);
        }
    }
}

class MotherPut implements Runnable{
    private Resource r;
    MotherPut(Resource r){
        this.r=r;
    }

    @Override
    public void run() {
        while (true){
            r.put("妈妈",2);
        }
    }
}

class SonEat implements Runnable{
    private Resource r;
    SonEat(Resource r){
        this.r=r;
    }

    @Override
    public void run() {
        while (true){
            r.eat("儿子",1);
        }
    }
}

class DaughterEat implements Runnable{
    private Resource r;
    DaughterEat(Resource r){
        this.r=r;
    }

    @Override
    public void run() {
        while (true){
            r.eat("女儿",2);
        }
    }
}


