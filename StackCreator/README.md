## Getting Started

Welcome to Stack Creator.

## Folder Structure

The workspace contains two main folders, where:

- `src`: the folder to maintain sources
- `bin`: the folder to maintain compiled output files
- `doc`: the folder to hold javadoc files

## How to Run
To run the program in the terminal navigate to the src folder and run two commands, `javac StackCreator/App.java` and then `java StackCreator/App`.

## Generating Documentation
To generate javadocs navigate to the doc folder (first create one if it has not been created yet) and run `javadoc ../src/StackCreator/App.java`

## Version Updates
1.2 - Change package name to StackCreator.  Add a method to push sorted Linked List elements to a stack, use that method in the main method, and pop the each element to be printed back to the user in the terminal.  Remove original printing of the Linked List.  Rearrange the main method to intialize first and then perform functionality.  Add constant list length to ensure consistency.

1.1 - Create a package for the App class and fix Exception warning and constructor warning that arose when generating documentation in version 1.0