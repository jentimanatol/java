# DNA Pattern Visualizer

## Introduction
The DNA Pattern Visualizer is a Java application that analyzes DNA sequences, identifies recurring patterns, and visualizes these patterns. This project provides an educational tool for understanding DNA sequences and their patterns using a simple graphical user interface.

## Main Features
### LinkedList and Node Classes
- **Node**: Represents a single nucleotide in the DNA sequence.
- **LinkedList**: Manages the sequence of nucleotides, providing methods to add nucleotides and retrieve the head of the list.

### DNAPatternCounter Class
- **countPatterns**: Analyzes the DNA sequence stored in a linked list to identify recurring patterns of length `k`.
- **getPatternMap**: Returns a map of identified patterns and their counts.

### DNAPatternVisualizer Class
- **Graphical Interface**: Provides an interface for inputting DNA sequences, pattern length (`k`), and a threshold value to filter patterns.
- **Visualization**: Displays a graphical representation of the DNA helix and highlights patterns that occur more frequently than the specified threshold.

### General Idea of the Code
- Save the DNA sequence as a linked list.
- Iterate through the linked list to identify patterns of length `k`.
- Count occurrences of each pattern and store them in a map.
- Visualize patterns that meet the threshold criteria.

## Screenshot
![DNA Pattern Visualization](DNA_Pattern_Count_visualisation/Screenshot/DNA_Patern_Visualisation.jpg)

## How to Use
1. **DNA Sequence Input**: Enter the DNA sequence you want to analyze.
2. **Pattern Length (k)**: Specify the length of the patterns you are interested in.
3. **Threshold**: Set the threshold value to filter patterns that occur frequently.
4. **Visualize**: Click the "Visualize Patterns" button to see the patterns and their occurrences in the DNA sequence.

## Example Usage
1. **Input DNA Sequence**: `ACGTACGTACGTACG`
2. **Pattern Length (k)**: `3`
3. **Threshold**: `2`
4. **Output**: The application will display patterns that appear at least 2 times, such as `ACG`, `CGT`, etc.

## Technologies Used
- **Java**: The primary programming language used for building the application.
- **Swing**: For creating the graphical user interface.
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
- **HashMap**: Used to store patterns and their counts. The key is the pattern (String) and the value is the count (Integer). HashMap provides efficient O(1) average time complexity for insertions and lookups, making it suitable for counting and storing patterns.
- **LinkedList**: Used to store the sequence of nucleotides. LinkedList allows for efficient traversal and manipulation of the sequence. Each nucleotide is represented as a node, and nodes are linked together to form the sequence.

## Getting Started
1. Clone the repository: `git clone https://github.com/your-username/DNA-Pattern-Visualizer.git`
2. Navigate to the project directory: `cd DNA-Pattern-Visualizer`
3. Set up your Java development environment.
4. Run the project to start the DNA Pattern Visualizer application.

## Contributing
Feel free to fork this repository and contribute by submitting a pull request. Let's build something great together!

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
