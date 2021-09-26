package linkedlist.remove_searchterm_alloccurences;

public class LinkedList {
    static Node head;
    private static int size = 0;
    private static final int SEARCH_TERM = 0;

    public static void main(String[] args) {
        LinkedList linkedList = insertData();

        System.out.println("->Before<-");
        LinkedList.print();
        System.out.println("Size: " + LinkedList.getSize());

        LinkedList.findAndDeleteTerm(LinkedList.SEARCH_TERM);

        System.out.println("->After<-");
        LinkedList.print();
    }

    public static void findAndDeleteTerm(int searchTerm) {
        Node currentNode = head, prev = null;

        while (currentNode != null && currentNode.data == searchTerm) {
            head = currentNode.next;
            currentNode = head;
        }

        while (currentNode != null) {
            //step1, keep looping until term found, if its found at start then step3, remove directly
            while (currentNode != null && currentNode.data != searchTerm) {
                prev = currentNode;
                currentNode = currentNode.next;
            }
            //step2 either searchTerm dont exist
            if (currentNode == null) {
                return;
            }

            //step3 or found now
            prev.next = currentNode.next;

            currentNode = prev.next;
        }
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
            System.out.print("\t"+ currentNode.data);
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

