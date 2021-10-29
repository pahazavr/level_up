package homework.task_2;

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
        while(currNode != null) {
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
        CustomNode slow = list.getHead();
        CustomNode fast = list.getHead();

        fast = fast.getNext();
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        fast.setNext(list.getHead());
        list.setHead(slow.getNext());
        slow.setNext(null);

        return list;
    }

    @Test
    public void testCases() {
        CustomLinkedList list = new CustomLinkedList(new double[]{ 1, 2, 3, 4, 5, 6 });
        CustomLinkedList expected = new CustomLinkedList(new double[]{ 4, 5, 6, 1, 2, 3 });

        assertEquals(expected, swap(list));
        assertEquals(expected, swapEffective(list));

        list = new CustomLinkedList(new double[]{ 3, 3, 3, 3, 3, 3, 3, 3 });
        expected = new CustomLinkedList(new double[]{ 3, 3, 3, 3, 3, 3, 3, 3 });

        assertEquals(expected, swap(list));
        assertEquals(expected, swapEffective(list));
    }
}
