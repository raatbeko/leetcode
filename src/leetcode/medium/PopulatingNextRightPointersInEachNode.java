package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
//    public static Node connect(Node root) {
//        if (null == root) return null;
//        Queue<Node> nodes = new ArrayDeque<>();
//        nodes.add(root);
//        ArrayDeque<Node> child = new ArrayDeque<>();
//        Node prev = null;
//
//        while (!nodes.isEmpty()) {
//            Node poll = nodes.poll();
//
//            if (poll.left != null) {
//                child.add(poll.left);
//                if (prev != null) {
//                    prev.next = poll.left;
//                }
//
//                prev = poll.left;
//            }
//            if (poll.right != null) {
//                child.add(poll.right);
//                if (prev != null) {
//                    prev.next = poll.right;
//                }
//
//                prev = poll.right;
//            }
//
//            if (nodes.isEmpty()) {
//                prev = null;
//                nodes = child;
//                child = new ArrayDeque<>();
//            }
//        }
//
//        return root;
//    }

    public static Node connect(Node root) {
        if (null == root) return null;
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int length = nodes.size();
            Node prev = null;
            for (int i = 0; i < length; i++) {
                Node next = nodes.poll();

                if (next.left != null) {
                    nodes.add(next.left);
                }
                if (next.right != null) {
                    nodes.add(next.right);
                }
                if (prev != null) {
                    prev.next = next;
                }
                prev = next;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);
        System.out.println(node);
        System.out.println();
        System.out.println(connect(node));
    }
}
