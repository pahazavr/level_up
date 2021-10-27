package homework.task_2;

import lombok.Data;

@Data
public class CustomLinkedList {
    private CustomNode head;

    public CustomLinkedList() {
    }

    public CustomLinkedList(double[] arr) {
        for(double data: arr) insert(data);
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
