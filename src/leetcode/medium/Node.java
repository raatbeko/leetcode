package leetcode.medium;

public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + right +
                ", right=" + right +
                ", next=" + next +
                "}";
    }
}
