
// Anatolie Jentimir  BHCC Competition 

//General Idea of code in java 

//save the DNA as a linked_list (provided by user)                                        ->exemple :  ACGTACGTACGTACGAA

//make a loop until end of the linked_list     

// initiate a curent_patern_list with first K element(provided by user)  from linked_list   ->  ASG

//save curent_element_linked_list  we used.                                               -> we used first 3 element stoped at  linked_list[2]=G

// save first k  element in the patern_Map_list                                           ->  map(ASG:1)  we have firs patern found 1 time 

// delete the first elemet from  curent_patern_list                                       -> delete A left SG 

// add one element to curent_patern_list from linked_list                                 -> Add T to the end curent_patern_list = SGT

// update curent_element_linked to keet track of used element from initial  linked_list  -> curent_element_linked = linked_list[3]=T


//verificate if  curent_patern_list are not in the  patern_Map_list 

//if found ++count of  patern  exemple                            -> map(ASG:2) 

//if not found add one more element in the patern_Map_list    -> exemple: map(SGT:1)

//repit to the end of the linked_list

    
//Loop the  patern_Map_list count > Trashhold (provided bY user)  exemple Trashold =2 

// print patern_Map_list   : and time apeared in the  DNA linked_list (provided by user)   



import java.util.HashMap;

public class DNAPatternCounter {
    private static LinkedList linkedList = new LinkedList();
    private static HashMap<String, Integer> patternMap = new HashMap<>();
    private static int k; // Pattern length
    private static int threshold; // Threshold count

    public static void main(String[] args) {
        // Example DNA sequence and parameters
        String dnaSequence = "ACGTACGTACGTACGAA";
        k = 3;
        threshold = 2;

        // Add DNA sequence to linked list
        for (char c : dnaSequence.toCharArray()) {
            linkedList.add(c);
        }

        // Count patterns in the linked list
        countPatterns(linkedList.getHead());

        // Print patterns that meet the threshold
        printPatterns();
    }

    private static void countPatterns(Node head) {
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

    private static void printPatterns() {
        for (String pattern : patternMap.keySet()) {
            if (patternMap.get(pattern) > threshold) {
                System.out.println("Pattern DNA " + pattern + " : " + patternMap.get(pattern) + " times");
            }
        }
    }
}
