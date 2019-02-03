import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Swappings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        if (size == 1) System.out.println(1);

        Node[] indices = new Node[size + 1]; //Puting an index on each Node

        Node head = new Node(1, null);
        Node current = head;
        indices[1] = head;

        for (int i = 2; i < size; i++) {
            current.next = new Node(i, current);
            current = current.next;
            indices[i] = current;
        }

        Node tail = new Node(size, current);
        indices[size] = tail;
        current.next = tail;

        String[] inputLimitNumbers = reader.readLine().split(" ");//Четене на разделителите

        for (int i = 0; i < inputLimitNumbers.length; i++) {

            int limitNodeValue = Integer.parseInt(inputLimitNumbers[i]);
            Node limitNode = indices[limitNodeValue];

            if (tail == limitNode) {
                tail = limitNode.prev;
                tail.next = null;

                limitNode.next = head;
                head.prev = limitNode;
                head = limitNode;
                continue;
            }

            if (head == limitNode) {
                head = limitNode.next;

                limitNode.prev = tail;
                tail.next = limitNode;
                tail = limitNode;
                tail.next = null;
                continue;
            }

            Node newHead = limitNode.next;
            head.prev = limitNode;
            limitNode.next = head;
            head = newHead;
            head.prev = null;

            Node newTail = limitNode.prev;
            tail.next = limitNode;
            limitNode.prev = tail;
            tail = newTail;
            tail.next = null;
        }

        StringBuilder sb = new StringBuilder();
        current = head;
        while (current != null) {
            sb.append(current.val).append(" ");
            current = current.next;
        }

        System.out.println(sb);
    }

    static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val, Node prev) {
            this.prev = prev;
            this.val = val;
        }
    }
}