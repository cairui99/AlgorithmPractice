package Code_16_IsPalindromeList;

public class IsPalindromeList {

    public static boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next != null ? fast.next.next : fast.next;
        }

        Node before = slow;
        Node index = before.next;
        before.next = null;
        while (index != null) {
            Node after = index.next;
            index.next = before;
            before = index;
            index = after;
        }

        Node n1 = head;
        Node n2 = fast;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        index = fast;
        Node after = index.next;
        index.next = null;
        while (after != null) {
            Node afterNext = after.next;
            after.next = index;
            index = after;
            after = afterNext;
        }

        return true;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head));
        printLinkedList(head);
    }

}
