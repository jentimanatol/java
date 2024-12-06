import java.util.HashMap;

public class DNAPatternCounter {
    private static LinkedList linkedList = new LinkedList();
    private static HashMap<String, Integer> patternMap = new HashMap<>();
    private static int k; // Pattern length
    private static int threshold; // Threshold count

    public static void countPatterns(Node head) {
        Node current = head;
        StringBuilder currentPattern = new StringBuilder();
        Node patternStartNode = current;

        while (current != null) {
            // Add current element to the pattern
            currentPattern.append(current.data);

            // If pattern length exceeds k, remove the first character
            if (currentPattern.length() > k) {
                currentPattern.deleteCharAt(0);
                patternStartNode = patternStartNode.next;
            }

            // If pattern length is k, process the pattern
            if (currentPattern.length() == k) {
                String pattern = currentPattern.toString();
                patternMap.put(pattern, patternMap.getOrDefault(pattern, 0) + 1);
            }

            current = current.next;
        }
    }

    public static HashMap<String, Integer> getPatternMap() {
        return patternMap;
    }
}
