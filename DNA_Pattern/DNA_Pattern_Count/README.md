# DNA Pattern Counter

## Introduction
The DNA Pattern Counter is a Java application designed to analyze DNA sequences, identify recurring patterns, and count their occurrences. This tool can be highly beneficial for educational purposes and for those interested in bioinformatics.

## Main Features
- **Node and LinkedList Classes**: These classes represent the DNA sequence as a linked list, allowing for efficient traversal and manipulation of nucleotides.
- **DNAPatternCounter Class**: This class contains methods to count patterns within the linked list and print those that meet a specified threshold.
- **Efficient Data Structures**: Uses HashMap for storing and counting DNA patterns due to its average O(1) time complexity for insertions and lookups.

## How It Works
1. **Save the DNA Sequence**: The DNA sequence is stored as a linked list.
2. **Pattern Counting**: The application iterates through the linked list to identify patterns of a specified length (k).
3. **Pattern Storage**: Patterns and their counts are stored in a HashMap.
4. **Threshold Filtering**: Patterns that meet or exceed a specified threshold are printed.

## Example Usage
1. **Input DNA Sequence**: `ACGTACGTACGTACGAA`
2. **Pattern Length (k)**: `3`
3. **Threshold**: `2`
4. **Output**: The application will display patterns that appear at least 2 times, such as `ACG`, `CGT`, etc.

## Screenshot
![DNA Pattern Diagram](https://github.com/jentimanatol/java/blob/42d01b83bd17b13dd8c92fdd7a25bb1dd3330649/DNA_Pattern/DNA_Pattern_Count/Screenshot/Untitled%20Diagram.drawio.png)

## Technologies Used
- **Java**: The primary programming language used for building the application.
- **HashMap**: For storing and counting DNA patterns.
- **LinkedList**: For managing the sequence of nucleotides efficiently.

## Variables and Data Structures
### Variables
- **dnaSequence**: Stores the input DNA sequence provided by the user.
- **k**: The length of the pattern to search for in the DNA sequence.
- **threshold**: The minimum number of occurrences for a pattern to be displayed.
- **dnaInput, kInput, thresholdInput**: GUI components for user input.
- **resultArea**: Displays the results of the pattern analysis.

### Data Structures
- **HashMap**: Used to store patterns and their counts. The key is the pattern (String) and the value is the count (Integer). HashMap is chosen because it provides efficient O(1) average time complexity for insertions and lookups, making it ideal for counting and storing patterns.
- **LinkedList**: Used to store the sequence of nucleotides. LinkedList allows for efficient traversal and manipulation of the sequence. Each nucleotide is represented as a node, and nodes are linked together to form the sequence. The choice of LinkedList over arrays or other data structures is due to its dynamic nature, allowing easy insertion and deletion of elements.

## Getting Started
1. Clone the repository: `git clone https://github.com/your-username/DNA-Pattern-Counter.git`
2. Navigate to the project directory: `cd DNA-Pattern-Counter`
3. Set up your Java development environment.
4. Run the project to start the DNA Pattern Counter application.

## Contributing
Feel free to fork this repository and contribute by submitting a pull request. Let's build something great together!

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
