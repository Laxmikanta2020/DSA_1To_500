package com.laxmi.samal.LinkListInternal;

public class TestNode {
    public static void main(String[] args) {
        Node node = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(node);
        System.out.println(node.next);
        System.out.println(node1);
        System.out.println(node1.next);
        System.out.println(node2);
        System.out.println(node2.next);
        System.out.println(node3);
        System.out.println(node3.next);
        node.display(node);
        System.out.print(node.get(node, 2));

    }
}
