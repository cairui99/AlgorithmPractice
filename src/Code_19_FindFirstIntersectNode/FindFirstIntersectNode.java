package Code_19_FindFirstIntersectNode;

import java.util.HashMap;

public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        //两个无环
        if (loop1 == null && loop2 == null) {
            int length1 = 0;
            int length2 = 0;
            Node end1 = head1;
            Node end2 = head2;
            while (end1.next != null) {
                length1++;
                end1 = end1.next;
            }
            while ((end2.next != null)) {
                length2++;
                end2 = end2.next;
            }
            if (end1 != end2) { //不相交
                return null;
            } else { //相交
                Node node1 = head1;
                Node node2 = head2;
                if (length1 > length2) {
                    int length = length1 - length2;
                    while (length > 0) {
                        node1 = node1.next;
                        length--;
                    }
                } else {
                    int length = length2 - length1;
                    while (length > 0) {
                        node2 = node2.next;
                        length--;
                    }
                }
                while (true) {
                    if (node1 == node2) {
                        return node1;
                    }
                    node1 = node1.next;
                    node2 = node2.next;
                }
            }
        }

        //两个有环
        if (loop1 != null && loop2 != null) {
            if (loop1 == loop2) {
                Node end = loop1;
                int lendth1 = 0;
                int length2 = 0;
                Node node1 = head1;
                Node node2 = head2;
                while (node1 != end) {
                    lendth1++;
                    node1 = node1.next;
                }
                while (node2 != end) {
                    length2++;
                    node2 = node2.next;
                }
                node1 = head1;
                node2 = head2;
                if (lendth1 > length2) {
                    int length = lendth1 - length2;
                    while (length > 0) {
                        length--;
                        node1 = node1.next;
                    }
                } else {
                    int length = length2 - lendth1;
                    while (length > 0) {
                        length--;
                        node2 = node2.next;
                    }
                }
                while (true) {
                    if (node1 == node2) {
                        return node1;
                    }
                    node1 = node1.next;
                    node2 = node2.next;
                }
            } else {
                Node node = loop1.next;
                while (node != loop1) {
                    if (node == loop2) {
                        return loop1;
                    }
                    node = node.next;
                }
            }
        }

        return null;
    }

    //判断链表是否有环   有环则返回入环节点
    public static Node getLoopNode(Node node) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        while (node != null) {
            if (hashMap.containsKey(node)) {
                return node;
            }
            hashMap.put(node, node);
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        Node node = getIntersectNode(head1, head2);
        System.out.println(node != null ? node.value : "null");

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
