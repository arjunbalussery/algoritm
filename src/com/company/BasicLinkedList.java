package com.company;

public class BasicLinkedList {
    private Node root=null;
    public void inset(int data) {
        Node node = new Node(data);
        if (root == null){
            root=node;
            return;
        }
        Node prev=root;
        Node current=root;
        while(current != null) {
            prev=current;
            current=current.next;
        }
        prev.next=node;
    }
    public void createCycle(int n) {
        Node current=root;

        Node cycle=root;
        while(n>0&& cycle!=null) {
            cycle=cycle.next;
            n--;
        }
        Node prev=root;
        while(current!=null) {
            prev=current;
            current=current.next;
        }
        prev.next=cycle;
    }
    public void insertRec(int data) {
        Node node = new Node(data);
        if (root == null){
            root=node;
            return;
        }
        insertRec(node,root,root);
    }

    private void insertRec(Node node, Node current,Node prev) {
        if (current!=null) {
            insertRec(node,current.next,current);
            return;
        }
        prev.next=node;
    }

    public void print() {
        Node current=root;
        while(current != null) {
            System.out.print(current.data+"->");
            current=current.next;
        }
    }

    public void printrec() {
        printrec(root);
    }

    private void printrec(Node current) {
        if (current != null) {
            System.out.print(current.data+"->");
            printrec(current.next);
        }
    }

    public int middleElement() {
        Node fast=root;
        Node slow=root;
        while(fast!=null && fast.next!= null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }
    public int nElementFromlast(int n) {
        Node leader = root;
        Node follower = root;
        if (n< 0) {
            return Integer.MIN_VALUE;
        }
        while(n>0&& leader != null) {
            n--;
            leader=leader.next;
        }
        if(n>0){
            return Integer.MIN_VALUE;
        }
        while(leader!=null) {
            leader=leader.next;
            follower=follower.next;
        }
        return follower.data;
    }
    public int detectCycle() {
        Node fast=root;
        Node slow=root;
        Node start=root;
        while(fast!=null && fast.next!=null) {
            start=fast.next;
            fast=fast.next.next;
            if(fast!=null && fast==slow) {
                return start.data;
            }
            slow=slow.next;
        }
        return -1;
    }
    public void reverseLinkedList() {
        Node current=root;
        Node prev=null;
        while(current!=null) {
            Node temp = current;
            current=current.next;
            temp.next=prev;
            prev=temp;

        }
        root=prev;
    }
    public void reverseLinkedListRec() {
        reverseLinkedListRec(root,null);
    }

    private void reverseLinkedListRec(Node current, Node prev) {
        if(current!=null) {
            Node temp=current;
            current=current.next;
            temp.next=prev;
            prev=temp;
            reverseLinkedListRec(current,prev);
        } else {
            root=prev;
        }
    }
}
class Node {
    int data;
    Node next=null;

    public Node(int data) {
        this.data = data;
    }
}