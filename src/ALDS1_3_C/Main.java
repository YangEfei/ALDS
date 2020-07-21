package ALDS1_3_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 效率优于 Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList test = new LinkedList();

        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "insert":
                    test.insert(Integer.parseInt(cmd[1]));
                    break;
                case "delete":
                    test.delete(Integer.parseInt(cmd[1]));
                    break;
                case "deleteFirst":
                    test.deleteFirst();
                    break;
                case "deleteLast":
                    test.deleteLast();
                    break;
            }
        }

        test.printList();
    }
}

class Node {
    int key;
    Node prev, next;

    Node() {
        prev = this;
        next = this;
    }

    Node(int key) {
        this.key = key;
        prev = null;
        next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = new Node();
    }

    void insert(int key) {
        Node x = new Node(key);
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        x.prev = head;
    }

    void deleteFirst() {
        Node cur = head.next;
        cur.next.prev = head;
        head.next = cur.next;
    }

    void deleteLast() {
        Node cur = head.prev;
        cur.prev.next = head;
        head.prev = cur.prev;
    }

    void delete(int key) {
        Node cur = head.next;
        while(cur != head){
            if(cur.key == key){
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                break;
            }
            cur = cur.next;
        }
    }

    void printList() {
        Node cur = this.head.next;
        if(cur == this.head){
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean format = true;
        while(cur != this.head){
            if(format){
                sb.append(cur.key);
                format = false;
            }else {
                sb.append(" " + cur.key);
            }
            cur = cur.next;
        }
        System.out.println(sb);
    }
}