package com.company;

public class MyLinkedList <T> {
    private Node<T> head = null;
    private Node<T> last = null;

    public void add(T data) {
        Node<T> node = new Node(data);
        if (head == null || last == null) {
            head = node;
            last = node;
            return;
        }
        last.next = node;
        last = node;

    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private class Node<T> {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
