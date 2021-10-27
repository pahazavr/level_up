package homework.task_2;

import lombok.Data;

@Data
public class CustomNode {
    private double data;
    private CustomNode next;

    CustomNode(double data) {
        this.data = data;
        next = null;
    }
}
