package com.ada.algorithm.queue;

/**
 * @author Ada
 * @ClassName :BaseQueue
 * @date 2019/10/7 19:58
 * @Description:
 */
public class BaseQueue {
    private int[] array;
    private int front;
    private int rear;

    public BaseQueue(int origin) {
        this.array = new int[origin];
    }

    /**
     * 入队
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已经满了 ");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已经空了");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BaseQueue baseQueue = new BaseQueue(6);
        baseQueue.enQueue(3);
        baseQueue.enQueue(5);
        baseQueue.enQueue(6);
        baseQueue.enQueue(8);
        baseQueue.enQueue(1);
        baseQueue.deQueue();
        baseQueue.deQueue();
        baseQueue.deQueue();
        baseQueue.enQueue(2);
        baseQueue.enQueue(4);
        baseQueue.enQueue(9);
        baseQueue.output();
    }
}
