package CapgeminiTraining.day5;

import java.util.PriorityQueue;
import java.util.Random;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class BST {

    Node root;

    Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
}

public class BST_MinHeap_Lab {

    public static void main(String[] args) {

        BST tree = new BST();

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int v : values) {
            tree.root = tree.insert(tree.root, v);
        }

        System.out.println("BST Created!");


        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);
        System.out.println();


        int search1 = 40;
        int search2 = 100;

        System.out.println("\nSearch " + search1 + ": " +
                (tree.search(tree.root, search1) ? "Found" : "Not Found"));

        System.out.println("Search " + search2 + ": " +
                (tree.search(tree.root, search2) ? "Found" : "Not Found"));


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        System.out.println("\nMin Heap Created!");


        Random rand = new Random();

        System.out.println("\nInserting Random Numbers:");

        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            minHeap.add(num);
            System.out.print(num + " ");
        }

        System.out.println("\n\nSorted Order (Min Heap):");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
