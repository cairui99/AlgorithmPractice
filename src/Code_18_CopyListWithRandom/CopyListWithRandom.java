package Code_18_CopyListWithRandom;

import java.util.HashMap;

public class CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    //额外空间O(N)
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node node = head;
        while (node != null) {
            Node copyNode = new Node(node.value);
            hashMap.put(node, copyNode);
            node = node.next;
        }

        node = head;
        while (node != null) {
            Node copyNode = hashMap.get(node);
            copyNode.next = node.next != null ? hashMap.get(node.next) : null;
            copyNode.rand = node.rand != null ? hashMap.get(node.rand) : null;
            node = node.next;
        }

        return hashMap.get(head);
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //空间复杂度O(1)
    public static Node copyListWithRand2(Node head) {
        Node node = head;
        while (node != null) {
            Node copyNode = new Node(node.value);
            Node next = node.next;
            node.next = copyNode;
            copyNode.next = next;
            node = next;
        }
        node = head;
        while (node != null) {
            Node copyNode = node.next;
            copyNode.rand = node.rand != null ? node.rand.next : null;
            node = copyNode.next;
        }
        node = head;
        Node copyHead = node.next;
        while (node != null) {
            Node copyNode = node.next;
            Node next = copyNode.next;
            node.next = next;
            copyNode.next = next != null ? next.next : null;
            node = next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        Node head;
        Node res1;
        Node res2;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
