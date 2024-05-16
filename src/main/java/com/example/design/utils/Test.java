package com.example.design.utils;

/**
 * @author jiaxianyang
 * @date 2024/5/8 16:43
 */
public class Test {
    public static void main(String[] args) {
        DNode dNode = generateTree(4);
        System.out.println("--------");
    }

    private static DNode generateTree(int level) {
        if (level <= 0) {
            return new DNode();
        }
        DNode<Integer> root = new DNode<>(1, null, null, null);
        generateFullTree(level - 1, root, 0, null);
        return root;
    }

    private static void generateFullTree(int k, DNode<Integer> root,int level, DNode<Integer> parentNode) {
        if (level == k) {
            return;
        }
        root.left = new DNode();
        root.left.setValue(root.getValue() + 1);
        root.right = new DNode<>();
        root.right.setValue(root.getValue() + 2);
        root.parent = parentNode;
        generateFullTree(k, root.left, level + 1, root);
        generateFullTree(k, root.right, level + 1, root);
    }
}


