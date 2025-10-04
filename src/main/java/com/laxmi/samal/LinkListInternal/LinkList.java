package com.laxmi.samal.LinkListInternal;

public class LinkList {
    Node head;
    Node tail;
    int size;

    public void addHead(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void insert(int val, int index) {
        if (index < 0 || index > size) {
            System.out.print("Invalid request");
            return;
        }
        if (index == 0) {
            addHead(val);
            return;
        }
        if (index == size) {
            addTail(val);
        } else {
            Node temp = new Node(val);
            Node temp1 = head;
            // Move to the node just BEFORE the insertion point
            for (int i = 0; i < index - 1; i++) {
                temp1 = temp1.next;
            }
            // Insert the new node
            temp.next = temp1.next;  // New node points to next node
            temp1.next = temp;       // Previous node points to new node
            size++;
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.print("Invalid request");
            return;
        }
        Node temp = head;
        if (index == 0) {
            // Delete head
            head = head.next;
            if (head == null) { // If list becomes empty
                tail = null;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            if (index == size - 1) {
                tail = temp;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public void addTail(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void display() {
        if (head == null) return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Test {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addHead(10);
        linkList.display();
        linkList.addHead(20);
        linkList.display();
        linkList.addHead(40);
        linkList.display();
        linkList.addTail(50);
        linkList.display();
        linkList.addHead(30);
        linkList.addTail(80);
        linkList.display();
        System.out.println(linkList.size);
        linkList.insert(111, 2);
        linkList.display();
        linkList.delete( 2);
        linkList.display();


    }
}
//Laxmikanta/04/10/2025-bengalure/hoodi