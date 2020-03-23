package com.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author fanchaochao
 * @className ArrayBlockingQueueTest
 * @description
 * @date 2020-03-12 13:47
 **/
public class ArrayBlockingQueueTest {
    private static final int maxSize = 5;

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(maxSize);
        new Thread(new Producter(queue)).start();
        new Thread(new Costomer(queue)).start();
    }
}


class Costomer implements Runnable{
    private BlockingQueue<Integer> queue;

    Costomer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       this.cusume();
    }

    private void cusume(){
        while (true){
            try {
                int count = queue.take();
                System.out.println("costomer正在消费第"+ count + "个商品");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Producter implements Runnable{
    private BlockingQueue<Integer> queue;
    private int count = 1;

    Producter(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.product();
    }

    private void product(){
        while (true){
            try {
                queue.put(count);
                System.out.println("producter正在生产第"+ count + "个商品");
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}