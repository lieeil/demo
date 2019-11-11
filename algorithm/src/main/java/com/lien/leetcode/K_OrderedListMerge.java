package com.lien.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-11-11 17:02
 */
public class K_OrderedListMerge {


    /**
     * 合并k个有序列表
     * @return
     */
    public static Node mergeKOrderedList(Node[] nodes){
        if(nodes != null && nodes.length > 1){
            List<Node> headList = new ArrayList<>(Arrays.asList(nodes));
            Node head = new Node();
            Node temp = head;
            while (headList.size() > 0){
                int index = findSmallestNode(headList);
                temp.setNext(headList.get(index));
                if(headList.get(index).getNext() != null){
                    headList.set(index, headList.get(index).getNext());
                }else {
                    headList.remove(index);
                }
                temp = temp.getNext();
            }
            return head;
        }else if(nodes == null){
            return null;
        }else {
            return nodes[0];
        }
    }

    /**
     * 查找最大的数据
     * @return
     */
    private static int findSmallestNode(List<Node> nodeList){
        int index = 0;
        for(int i = 1; i < nodeList.size() ; i++){
            if(nodeList.get(i).getValue() < nodeList.get(index).getValue()){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Node node11 = new Node();
        node11.setValue(1);

        Node node12 = new Node();
        node12.setValue(4);

        Node node13 = new Node();
        node13.setValue(5);

        node11.setNext(node12);
        node12.setNext(node13);

        Node node21 = new Node();
        node21.setValue(1);

        Node node22 = new Node();
        node22.setValue(3);

        Node node23 = new Node();
        node23.setValue(4);

        node21.setNext(node22);
        node22.setNext(node23);

        Node node31 = new Node();
        node31.setValue(2);

        Node node32 = new Node();
        node32.setValue(6);

        node31.setNext(node32);

        print(node11);
        print(node21);
        print(node31);

        Node[] nodes = {node11, node21, node31};
        Node result = mergeKOrderedList(nodes);
        print(result);

    }

    public static void print(Node node){
        if(node != null){
            Node current = node;
            while (current != null){
                if(current.getValue() != null){
                    System.out.print(current.getValue() + " ");
                }
                current = current.getNext();
            }
            System.out.println();
        }
    }

}


class Node {

    private Integer value;

    private Node next;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
