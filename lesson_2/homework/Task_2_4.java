package homework;

import lombok.Data;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/*
    Написать функцию next() для получения следующего элемента после текущего в бинарном дереве поиска.
 */
public class Task_2_4 {

    private int next(BinaryTree tree, int data) {
        int nextElement = findMax(tree);
        if (nextElement == data) throw new IllegalArgumentException();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree.getRoot());

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.data > data) {
                if (node.data <= nextElement) {
                    nextElement = node.data;
                }
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return nextElement;
    }

    private static int findMax(BinaryTree tree) {
        int max = tree.getRoot().getData();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree.getRoot());

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.data > max) {
                max = node.data;
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return max;
    }

    @Data
    static class BinaryTree {
        TreeNode root;

        BinaryTree(int[] data) {
            for (int d : data) {
                insert(d);
            }
        }

        void insert(int data) {
            if (root == null) {
                root = new TreeNode(data);
            } else {
                insert(root, data);
            }
        }

        void insert(TreeNode node, int data) {
            if (node.data <= data) {
                if (node.right != null) {
                    insert(node.right, data);
                } else {
                    node.right = new TreeNode(data);
                }
            } else {
                if (node.left != null) {
                    insert(node.left, data);
                } else {
                    node.left = new TreeNode(data);
                }
            }
        }
    }

    @Data
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    @Test
    public void testCases() {
        BinaryTree tree = new BinaryTree(new int[]{20, 7, 4, 6, 9, 35, 31, 40, 28, 38, 52});
        int expected = 28;
        assertEquals(expected, next(tree, 20));

        expected = 7;
        assertEquals(expected, next(tree, 6));

        expected = 9;
        assertEquals(expected, next(tree, 7));

        expected = 20;
        assertEquals(expected, next(tree, 9));

        expected = 28;
        assertEquals(expected, next(tree, 20));

        expected = 31;
        assertEquals(expected, next(tree, 28));

        expected = 35;
        assertEquals(expected, next(tree, 31));

        expected = 38;
        assertEquals(expected, next(tree, 35));

        expected = 40;
        assertEquals(expected, next(tree, 38));

        expected = 52;
        assertEquals(expected, next(tree, 40));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLastElementThenThrowException() {
        BinaryTree tree = new BinaryTree(new int[]{20, 7, 4, 6, 9, 35, 31, 40, 28, 38, 52});
        next(tree, 52);
    }
}
