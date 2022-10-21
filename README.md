## Folder Structure

The workspace contains two folders, where:

- `src`: the folder to maintain sources
- `Inputs`: the folder containing the input files

## Steps to execute your code

Step 1 : Open the src/App.java file.<br>
Step 2 : In line 84 of the code in the FileReader, add the path to the input file as the first argument.<br>
Step 3 : Run the code.<br>

## Overview and Approach 

Trie structure was used to solve the problem. We can execute insertion and search operations using the trie data structure in O(n) time, where N is the word length.

The search algorithm involves having 2 pointers to the trie structure- current word pointer and new word pointer. The algorithm compares the values of the two pointers to see if they make a compound word. Then the compound words are stored in the finalList array.
