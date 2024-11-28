# Compound Words Finder

## Overview
This program identifies the longest and second-longest compound words from a list of alphabetically sorted words provided in input files. A compound word is defined as a word that can be constructed by concatenating shorter words from the same list. 

## Design Decisions
1. Data Structures:
   - A `HashSet` is used for efficient word lookups, reducing the time complexity of the search operations.
   - A `List` is used to store words read from the file for ordered processing.

2. Algorithm:
   - Recursion is used to check if a word can be formed from other words in the list.
   - A helper method ensures that compound words are detected without incorrectly considering the word itself as its own component.

3. Sorting:
   - Identified compound words are sorted by length in descending order to find the longest and second-longest efficiently.

4. Performance Measurement:
   - The time taken to process the file is measured using `System.currentTimeMillis()`.

## How to Execute
Follow these steps to run the program:

1. Prerequisites:
   - Install Java Development Kit (JDK) 8 or higher.
   - Ensure your system's environment variables are configured to run Java commands.

2. Setup:
   - Save the program file as `CompoundWords.java`.
   - Save the input files named  as `Input_01.txt` and `Input_02.txt`.

4. Execution:
   - Run the program.
   - The program will read the input files, process the data, and display the results in the output.

5. Output:
   - For each input file, the program will display:
     - The longest compound word.
     - The second longest compound word.
     - The time taken to process the file (in milliseconds).

## Example Input and Output
### Input File: `Input_01.txt`
### Output : 
            Longest Compound Word ratcatdogcat
            Second Longest Compound Word catsdogcats
            Time taken to process file Input_01.txt : 9 milliseconds

## Example Input and Output
### Input File: `Input_02.txt`
### Output : 
            Longest Compound Word ethylenediaminetetraacetates
            Second Longest Compound Word electroencephalographically
            Time taken to process file Input_02.txt : 359 milliseconds

## Notes
- Ensure input files are located in the same directory as the program.
