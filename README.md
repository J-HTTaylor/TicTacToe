![CS121 Banner](images/CS121-BANNER.svg)

**NOTE: Before beginning the project, please remember to [open the workspace](images/open-lab-workspace.png) after cloning this repository in VSCode.**
# Project 3: TicTacToe

## Purpose & Concepts: 
In this project you will practice concepts covered up to an including Module 8. In particular, you will demonstrate using 1D and 2D arrays, implementing a testable interface, and developing a GUI from scratch.

## Problem Description
For this project, you will create a class (`TicTacToeGame`) that implements logic for a game of [tic-tac-toe](https://en.wikipedia.org/wiki/Tic-tac-toe), and then you will create a GUI (`TicTacToeGUI`) that uses that class to allow a player to play an interactive game of tic-tac-toe against the computer. Your class `TicTacToeGame` will implement the `TicTacToe` interface that defines methods to manage game state information and logic for a game of tic-tac-toe. After successfully implementing TicTacToeGame, you will build a graphical user interface (GUI) to interactively play a game of tic-tac-toe against the computer.  


## Requirements

### TicTacToeGame
1. Create a class TicTacToeGame that implements TicTacToe.java: `public class TicTacToeGame implements TicTacToe { }`
2. TicTacToeGame must correctly implement the TicTacToe interface to enforce all rules of the game to pass all tests in TicTacToeTester and work with your TicTacToeGUI. 
3. You must use arrays (not ArrayLists) for storing and working with game data - a 2D BoardChoice array for the game grid, and a 1D Point (from java.awt) array for the history of moves. These are some of the fields, but likely not all. Please note, like all classes, you should specify a constructor.

### TicTacToeGUI Requirements
1. TicTacToeGUI must use an instance of TicTacToeGame to manage all game logic.
2. Allow the user to choose if they will go first or second (first player is always X's, second player is always O's).
3. Display whose turn it is to move.
4. Display the game board and allow user to choose a move by clicking on the square where they want to make their move.
5. On the computer's turn, have the computer choose a random open position for its move.
6. When game play is over (whether because of a win, loss, or draw) display the sequence of moves that were made during the game, which player made them, and the final outcome of the game. 
7. Allow the user to start a new game.

Below is a simple sample GUI. Your GUI *cannot* look like this. 
![Sample GUI New Game](images/tictactoe1.png)
![Sample GUI X Wins](images/tictactoe2.png)

Your GUI should **not** look like this one. This is just an example to show what some of the fields can look like (notice, it does not fulfill all the requirements). Showcase your creativity and design skills in your GUI implementation.


## Before You Begin: Computational Thinking & Planning
1. Before you begin, read **all** project requirements and **all** given source files carefully and completely. Pay special attention to the javadocs in the interface `TicTacToe` to understand what is expected from each method.
2. Make sure you understand the relationships between the classes involved in this project.
3. Fill in PLAN.md. Pay special attention to your testing plans.
4. While the requirements are listed succinctly, there are a lot of pieces required to make this project work. Be sure you have included a plan for all required pieces.

## To Do
1. Create `TicTacToeGame.java` and `TicTacToeGUI.java` in the `project3` folder.
2. As soon as you have created the class `TicTacToeGame`, run the test class `TicTacToeTester` to confirm that it compiles and runs. At first, most tests are expected to fail. When you have completed `TicTacToeGame` all tests should pass.
4. Execute the plan you created in PLAN.md.
5. Be sure to review the requirements given in this document as well as the rubric in GRADE.md.
    

## Review & Reflect
1. Write a two to three paragraph reflection describing your experience with this project. Talk about what worked well and what didn't work so well in planning, coding, and testing.  Did you run into an issue that took some time to figure out?  Tell us about it. Write the reflection in PLAN.md


## Finally
1. Commit the changes to your local repository with a message stating that Project 3 is complete.
2. Push the changes from your local repository to the github classroom repository.
