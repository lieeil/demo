package com.lien.leetcode;

/**
 * Description: 反转链表<br>
 *
 * @author li
 * @date 2019/12/29 上午11:06
 */
public class ReverseLinkedList {



    public static LinkedReverseNode reverseLinkedList(LinkedReverseNode startNode){
        if(startNode == null || startNode.getNext() == null){
            return startNode;
        }
        LinkedReverseNode loopNode = startNode;
        LinkedReverseNode preNode = null;
        while (loopNode != null){
            LinkedReverseNode nextNode = loopNode.getNext();
            loopNode.setNext(preNode);
            preNode = loopNode;
            loopNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        LinkedReverseNode startNode = new LinkedReverseNode();
        startNode.setData(1);
        LinkedReverseNode ele = startNode;
        for(int i = 2; i <= 5; i++){
            LinkedReverseNode node = new LinkedReverseNode();
            node.setData(i);
            ele.setNext(node);
            ele = node;
        }
        print(startNode);
        print(reverseLinkedList(startNode));
    }

    public static void print(LinkedReverseNode node){
        LinkedReverseNode ele = node;
        while (ele != null){
            System.out.print(ele.getData() + " ");
            ele = ele.getNext();
        }
        System.out.println();
    }
}

class LinkedReverseNode{

    private int data;

    private LinkedReverseNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedReverseNode getNext() {
        return next;
    }

    public void setNext(LinkedReverseNode next) {
        this.next = next;
    }
}
