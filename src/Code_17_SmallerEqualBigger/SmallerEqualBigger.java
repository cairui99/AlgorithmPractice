package Code_17_SmallerEqualBigger;

public class SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition(Node head, int pivot) {
        Node lessHead = null;
        Node lessEnd  = null;
        Node eqHead   = null;
        Node eqEnd    = null;
        Node moreHead = null;
        Node moreEnd  = null;
        Node node = head;

        while (node != null) {
            if (node.value < pivot) {
                if (lessHead == null) {
                    lessHead = node;
                    lessEnd = node;
                } else {
                    lessEnd.next = node;
                    lessEnd = lessEnd.next;
                }
            } else if (node.value == pivot) {
                if (eqHead == null) {
                    eqHead = node;
                    eqEnd  = node;
                } else {
                    eqEnd.next = node;
                    eqEnd = eqEnd.next;
                }
            } else {
                if (moreHead == null) {
                    moreHead = node;
                    moreEnd  = node;
                } else {
                    moreEnd.next = node;
                    moreEnd = moreEnd.next;
                }
            }
            node = node.next;
        }

        if (lessHead != null) {
            lessEnd.next = null;
        }
        if (eqHead != null) {
            eqEnd.next = null;
        }
        if (moreHead != null) {
            moreEnd.next = null;
        }


        if (lessEnd != null) {
            if (eqHead != null) {
                lessEnd.next = eqHead;
            } else if (moreHead != null) {
                lessEnd.next = moreHead;
            }
        }

        if (eqHead != null && moreHead != null) {
            eqEnd.next = moreHead;
        }

        Node resultNode;
        if (lessHead != null) {
            resultNode = lessHead;
        } else if (eqHead != null) {
            resultNode = eqHead;
        } else {
            resultNode = moreHead;
        }

        return resultNode;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition(head1, 5);
        printLinkedList(head1);

    }

}
