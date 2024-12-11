import java.util.HashMap;

public class DNAPatternCounter {
    private static HashMap<String, Integer> patternMap = new HashMap<>();
    private static int k; // Pattern length

    public static void countPatterns(Node head, int k) {
        patternMap.clear(); // Reset pattern map
        Node current = head;
        StringBuilder currentPattern = new StringBuilder();

        while (current != null) {
            // Add current element to the pattern
            currentPattern.append(current.data);

            // If pattern length exceeds k, remove the first character
            if (currentPattern.length() > k) {
                currentPattern.deleteCharAt(0);
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
