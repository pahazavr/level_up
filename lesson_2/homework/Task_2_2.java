package homework;

import lombok.Data;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Дан односвязный список [first half] → [last half].
    Требуется выполнить перестроение [last half] → [first half];
 */
public class Task_2_2 {

    // O(n)
    private CustomLinkedList swap(CustomLinkedList list) {
        CustomLinkedList result = new CustomLinkedList();
        CustomLinkedList firstHalf = new CustomLinkedList();
        CustomNode currNode = list.getHead();
        CustomNode lastNode = null;

        int size = 0;
        while (currNode != null) {
            currNode = currNode.getNext();
            size++;
        }

        currNode = list.getHead();
        for (int i = 1; i <= size; i++) {
            if (i <= size / 2) {
                firstHalf.insert(currNode.getData());
            }

            if (i > size / 2) {
                result.insert(currNode.getData());
                if (i == size / 2 + 1) {
                    lastNode = result.getHead();
                } else {
                    lastNode = lastNode.getNext();
                }
            }

            if (i == size) {
                lastNode.setNext(firstHalf.getHead());
            }

            currNode = currNode.getNext();
        }

        return result;
    }

    // O(n) (O(n/2))
    private CustomLinkedList swapEffective(CustomLinkedList list) {
        if (list.getHead() != null) {
            CustomNode slow = list.getHead();
            CustomNode fast = list.getHead();
            fast = fast.getNext();
            while (fast.getNext() != null && fast.getNext().getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }

            fast.setNext(list.getHead());
            list.setHead(slow.getNext());
            slow.setNext(null);
        }

        return list;
    }

    @Data
    static class CustomNode {
        private double data;
        private CustomNode next;

        CustomNode(double data) {
            this.data = data;
            next = null;
        }
    }

    @Data
    static class CustomLinkedList {
        private CustomNode head;

        public CustomLinkedList() {
        }

        public CustomLinkedList(double[] arr) {
            for (double data : arr) insert(data);
        }

        void insert(double data) {
            CustomNode newNode = new CustomNode(data);
            newNode.setNext(null);

            if (head == null) {
                head = newNode;
            } else {
                CustomNode last = head;
                while (last.getNext() != null) {
                    last = last.getNext();
                }
                last.setNext(newNode);
            }
        }
    }

    @Test
    public void testCases() {
        CustomLinkedList list = new CustomLinkedList(new double[]{});
        CustomLinkedList expected = new CustomLinkedList(new double[]{});
        assertEquals(expected, swap(list));

        list = new CustomLinkedList(new double[]{1, 2, 3, 4, 5, 6});
        expected = new CustomLinkedList(new double[]{4, 5, 6, 1, 2, 3});
        assertEquals(expected, swap(list));

        list = new CustomLinkedList(new double[]{3, 3, 3, 3, 3, 3, 3, 3});
        expected = new CustomLinkedList(new double[]{3, 3, 3, 3, 3, 3, 3, 3});
        assertEquals(expected, swap(list));

        list = new CustomLinkedList(new double[]{});
        expected = new CustomLinkedList(new double[]{});
        assertEquals(expected, swapEffective(list));

        list = new CustomLinkedList(new double[]{1, 2, 3, 4, 5, 6});
        expected = new CustomLinkedList(new double[]{4, 5, 6, 1, 2, 3});
        assertEquals(expected, swapEffective(list));

        list = new CustomLinkedList(new double[]{3, 3, 3, 3, 3, 3, 3, 3});
        expected = new CustomLinkedList(new double[]{3, 3, 3, 3, 3, 3, 3, 3});
        assertEquals(expected, swapEffective(list));
    }
}