package Code_20_PreInPosTraversal;

import java.util.Stack;

public class PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //先序遍历
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //先序遍历非递归
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(head);
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
        System.out.println();
    }

    //中序遍历
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    //中序遍历非递归
    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        Stack<Node> nodeStack = new Stack<>();
        if (head != null) {
            while (!nodeStack.isEmpty() || head != null) {
                if (head != null) {
                    nodeStack.push(head);
                    head = head.left;
                } else {
                    head = nodeStack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //后序遍历
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                Node node = stack1.pop();
                stack2.push(node);
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                }
            }
            while (!stack2.isEmpty()) {
                Node node = stack2.pop();
                System.out.print(node.value + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
    }

}
