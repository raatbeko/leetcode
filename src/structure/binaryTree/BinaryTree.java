//package structure.binaryTree;
//
//public class BinaryTree {
//
//
//}
//
//class Node<T1, T2> {
//    T1 key;
//    T2 value;
//    Node<T1, T2> left, right;
//
//    Node(T1 key, T2 value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public T2 get(T1 k) {
//        Node<T1, T2> x = this;
//        while (x != null) {
//            int cmp = k.compareTo(x.key);
//            if (cmp == 0) {
//                return x.value;
//            }
//            if (cmp < 0) {
//                x = x.left;
//            } else {
//                x = x.right;
//            }
//        }
//        return null;
//    }
//
//    public void add(T1 k, T2 v) {
//        Node<T1, T2> x = root, y = null;
//        while (x != null) {
//            int cmp = k.compareTo(x.key);
//            if (cmp == 0) {
//                x.value = v;
//                return;
//            } else {
//                y = x;
//                if (cmp < 0) {
//                    x = x.left;
//                } else {
//                    x = x.right;
//                }
//            }
//        }
//        Node<T1, T2> newNode = new Node<T1, T2>(k, v);
//        if (y == null) {
//            root = newNode;
//        } else {
//            if (k.compareTo(y.key) < 0) {
//                y.left = newNode;
//            } else {
//                y.right = newNode;
//            }
//        }
//    }
//
//}
