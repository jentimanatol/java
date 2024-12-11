import java.util.LinkedList;

class PriorityQueue {
    private LinkedList<Node> queue;

    private class Node {
        int priority;
        String value;

        Node(int priority, String value) {
            this.priority = priority;
            this.value = value;
        }
    }

    public PriorityQueue() {
        queue = new LinkedList<>();
    }

    public void insert(String value, int priority) {
        Node newNode = new Node(priority, value);
        if (queue.isEmpty()) {
            queue.add(newNode);
        } else {
            int i = 0;
            for (; i < queue.size(); i++) {
                if (queue.get(i).priority > priority) {
                    break;
                }
            }
            queue.add(i, newNode);
        }
    }

    public void display() {
        for (Node node : queue) {
            System.out.println("Value: " + node.value + ", Priority: " + node.priority);
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert("task310", 1);
        pq.insert("task1", 2);
        pq.insert("task2", 1);
        pq.insert("task3", 3);
     
        pq.display();
    }
}
