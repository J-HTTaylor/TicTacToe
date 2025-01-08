# PLAN.md Project 3 - TicTacToe

## Overview
The following code will run a tic-tac-toe game in a created window. Thisgame will pit you against a computer. After each game the program will display the moves made and who it the winner. Furthermore the proram will tell you whose turn it is as well as asking you if you wish to go first or second

## What are the tasks?
A. Create backend code
B. create front end Jpanel

1. create a class for the backend code
2. in this class create a constructor that initalises with a 2D array for the game board and an empty Array for the moves (max of 9)
3. create the newgame method
4. create the player choice option ('x' or 'o')
5. create the get game grid option
6. create the get gamestate method
7. create the gameover method
8. Create the getmoves method
9. Create the computer's move set (could use rng gen to choise the number in the array)
10. Create a class for the buttons in the jpanel
11. Create the method for changing the text on the button to a 'x' or 'o' based on who presed it
12. Create the jpanel class for the window itself
13. set dimensions and layout of the main Jpanel
14. create the sub-panels for (the buttons, the turn order, previous turns and newgame button)
15. create listeners for the buttons
16.  add the sub-panels to the main panel
17. test the window and fix final issues.

## How can those tasks be broken into smaller steps?
Use of the litebrite activity can be used as a baseline for some of the code (more of a jumping off point)
1. Create an empty class for the main backend of the program
1.2 implement the 'TicTacToe.java' file into it
2.1 Create private instance variable for the arrays (can also create on for the win tally if time permits)
2.2 create the constructor that fills the 2D array with 'OPEN' in each option
2.3 add the empty array that takes the moves made
3.1 create the empty method for the newgame
3.2 set the method to empty the 1D array and set the 2D back to all 'OPEN'
4.1 create a variable that will hold the chosen choice for the player.
5.1 create blank method
5.2 in this method call a copy of the orginal game board that will be used during all play sessions
5.3 retun this to the program.
6.1 create a blank method
6.2 depending on if 'o','x' or no winner. return a statement depending on the result (can also update the score counter)
7.1 create empty method
7.2 use the method to create a chekc system that repeatedly checks for a 3 in a row.
7.3 set true if there is a winner
8.1 create empty method
8.2 in method call store all moves made 
8.3 return all moves in a for loop
9.1 create a random number generator between 1-9 (unsure if 0 is an option)
9.2 use the number to determine the cpu's placement
11.1 add a method that changes the dialog text depending on the turn
11.2 add this method to the listener for the button press
12.1 use the code from the litebrite to create the base panel
13.1 set dimentions of the panel to a square 
13.2 set layout the border 
14.1 create a sub panel for the buttons
14.2 create a sub panel for the new game button
14.3 create a sub panel for the player turn/ win counter
14.4 create a sub panel for the turn play back
14.5 add sub panels to the main panel
15.1 create a listenr for the main game button that changes the symbol on it
15.2 create a listen for the player  turn option (first or second)
15.3 create a listern for the new game button
16.1 add all panel to the main frame and ensure the visibilty is set correctly
## Testing Plan
apart from using the tictactoe tester throughout the course of creating the backend of the the following tests will also be performed.
3 - print the array after it has been called with a for loop
4- print the player's choice after it has been selected and cross check it
5 - print the game board after each turn to check it has been updated correctly
6 + 7 - run some games and check that the right palyer is marked the winner when applicable
8 - print each move after when they are made and check that they match
10 - call the window after each added panel and check all buttons and dialog is shown correctly

## Requirements Check
there must be all the methods that the implementation has
there must be a window when the program is played
it must ask if you want to go first or second
the cpu must choice spots that arent taken
the game must show whose turn it is
the game must output the results when the game is over
the game must be reset when the button is pressed
the game must auto end when someone gets three in a row
