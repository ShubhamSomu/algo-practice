package linkedlist.detect_cycle;

import java.util.HashSet;

public class LinkedList {
    static Node head;
    private static int size = 0;

    public static void main(String[] args) {
        LinkedList linkedList = insertData();

        //creating a fake loop
        // SNAAAKKE!!

        System.out.println("->Before<-");
        LinkedList.print();
        System.out.println("Size: " + LinkedList.getSize());

        System.out.println("->After<-");
        LinkedList.print();

        /*linkedList.head.next.next.next.next = linkedList.head;
        System.out.println("Loop exists :" + linkedList.detectLoopHashSet());*/

        linkedList.head.next.next.next.next = linkedList.head;
        System.out.println("Detect loop marvel style: ");
        System.out.println("Loop exists :" + linkedList.detectLoopMarvelStyle());
    }

    public boolean detectLoopHashSet() {
        HashSet<Integer> hashSet = new HashSet<>();
        Node currentNode = head;

        while (currentNode != null) {

            if (hashSet.contains(currentNode.data)) {
                return true;
            }
            hashSet.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return false;
    }

    // captain america runs twice (assume: he runs a way fastr) as fast as falcon
    public boolean detectLoopMarvelStyle() {
        Node capAmerica = head;
        Node falcon = head;
        boolean status = false;

        while (falcon != null && capAmerica != null && capAmerica.next != null) {
            falcon = falcon.next;
            capAmerica = capAmerica.next.next;

            if (falcon == capAmerica) {
                status = true;
                System.out.println("Length of Cycle : "+ countNode(falcon));
                break;
            }
        }
        return status;
    }

    public int countNode (Node falcon) {
        int count = 1;
        Node temp = falcon;

        while (temp.next != falcon) {
            count ++;
            temp = temp.next;
        }
        return count;
    }
    public static void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    public static void print() {
        Node currentNode = head;
        System.out.println("----------List------------");
        while (currentNode != null) {
            System.out.print("\t" + currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static int getSize() {
        return size;
    }

    public static LinkedList insertData() {
        LinkedList linkedList = new LinkedList();
        LinkedList.insert(0);
        LinkedList.insert(0);
        LinkedList.insert(0);
        LinkedList.insert(1);
        LinkedList.insert(2);
        LinkedList.insert(0);
        LinkedList.insert(4);
        LinkedList.insert(0);
        LinkedList.insert(6);
        LinkedList.insert(0);

        return linkedList;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" + data + '}';
        }
    }
}

