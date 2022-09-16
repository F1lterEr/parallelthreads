package com.company;

import java.util.Arrays;
import java.util.Random;

class Supthread extends Thread
{
    int num = 0;
    public Supthread(int num){
        this.num = num;
    }
    @Override
    public void run()
    {
        System.out.println("Поток " + num);
    }
}


public class Main
{
    static Supthread mAnotherOpinion;

    public static void main(String[] args)
    {
        int s = 10;
        Thread[] threads = new Thread[s];
        Runnable[] runnables = new Runnable[s];
        Random random = new Random();
        for(int i = 0; i < s; i++){
            runnables[i] = new Supthread(i+1);
            threads[i] = new Thread(runnables[i]);
            threads[i].setPriority(random.nextInt(Thread.MAX_PRIORITY-1)+1);
        }
        Arrays.stream(threads).parallel().forEach(Thread::start);

        System.out.println("Главный поток!");
    }
}
