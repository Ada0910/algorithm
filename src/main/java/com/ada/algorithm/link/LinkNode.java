package com.ada.algorithm.link;

/**
 * @author Ada
 * @ClassName :Node
 * @date 2019/10/7 14:49
 * @Description:
 */
public class LinkNode {
    private Node head;
    private Node last;
    private int size;

    /**
     * 插入
     */
    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入节点位置超出了节点范围");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        }  else if(index == 0) {
            //插入头部
            insertNode.next = head;
            head = insertNode;
        }else if (index == size) {
            last.next = insertNode;
            last = insertNode;
        }else {
            Node preNode = get(index - 1);
            Node nextNode = preNode.next;
            preNode.next = insertNode;
            insertNode.next = nextNode;
        }
        size++;
    }

    /**
     * 删除
     */
    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("删除节点位置超出了节点范围");
        }
        Node removeNode = null;
        if (index == 0) {
            removeNode = head;
            head.next = head;
        } else if (index == size - 1) {
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = null;
            last = preNode;
        } else {
            Node preNode = get(index - 1);
            Node nextNode = preNode.next.next;
            removeNode = preNode.next;
            preNode.next = nextNode;
        }
        return removeNode;
    }

    /**
     * 查找
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出
     */
    public void output() {
        Node temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println("第" + i + "个节点的值是:" + temp.data);
            temp = temp.next;
            i++;
        }
    }

    /**
     * 节点
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] arg) throws Exception {
        LinkNode link = new LinkNode();
        link.insert(3, 0);
        link.insert(7, 1);
        link.insert(9, 2);
        link.insert(5, 3);
        link.insert(1, 1);
        link.output();
    }

}

