package com.laxmi.samal.LinkListInternal;

public class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
    public void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    public int get(Node head ,int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.val;
    }
}
