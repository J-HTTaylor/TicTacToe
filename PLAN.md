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

## Compiling

To correctly run and complie the following code do the following:

1. Ensure that the following files are present in the same directory:
TicTacToe.java
TicTacToeGame.java
TicTacToeGUI.java

(If you wish to run the test programs include the following files)
TicTacToeTester.java

1.1 This can be done via the use of the '$ ls' and '$ cd' commands to list and select the correct folder until '$ ls' shows that the files listed above' are all stored stored in that directory.

2. While in the correct fodler directory run '$ javac *.java' to compile all required files quickly and correctly.
3. To run the code for the  GUI enter '$ java TicTacToeGUI to run the code.
4. If successfull  the you will be asked which player you would like to be. This will then be followed up by a window will the full game.

If there are any issues feel free to contact me at 'james.ht.taylor@gmail.com'
## Sources Used

https://www.baeldung.com/java-breaking-out-nested-loop - used to check that my break would fully break out the loops

https://www.half-real.net/tictactoe/ - used the list of all possible cobinations to check who could win on the last move for gamestate method

https://www.w3schools.com/java/java_foreach_loop.asp - used to ensure correct use of for each loop method

https://stackoverflow.com/questions/33799800/java-local-variable-mi-defined-in-an-enclosing-scope-must-be-final-or-effective - used to help understand and fix a scoping error

https://stackoverflow.com/questions/8193801/how-to-set-specific-window-frame-size-in-java-swing - used to help window sizing issue

https://docs.oracle.com/javase/8/docs/api/java/awt/Container.html#getLayout-- - used to do cpu  moves

https://www.geeksforgeeks.org/java-program-to-convert-enum-to-string/ - used to convert enum to string

https://coderanch.com/t/340006/java/line-character-JLabel-work - used to help break the line on a label
## Reflection
Write a 2-3 paragraph reflection describing your experience with this project. Answer the following questions (but feel free to add other insights): 
- What worked well and what was a struggle? (Think about all phases of the project including planning, coding, and testing)
- What concepts still aren't quite clear?
- What techniques did you use to make your code easy to debug and modify?
- What would you change about your design process?
- If you could go back in time, what would you tell yourself about doing this project?

This project was a lot tough than any of the previous ones. The backend was more complicate than I expected it to be. I tihnk the reason behind this was that I neede to change the idea of the game in my head to fit around the implimentation requriments.  If it was a free write with no implimentations it may have been easier and quicker for me.

For the GUI side of the project the main parts of ir wasn't too bad. This included the buttons, panels and all seen aspects. I only struggled with the CPU moves. The action of getting the moves done wasn't a problem, what caused the issues was the fact that I could not get the buttons to correctly change to display the computer's move. This took ohours for me to figure out (Thank god for ORaacle documentation)

In terms of plannning, I could've broken down the implementations further to ensure that I didn't have to rework and re-write parts of my code. There are no concepts of this that I am unclear about really. I  just need more time and practise to be able to utilise them better.The constant code running and test file helped to narrow down issue most of the time.

If I was to go back and change my process I would get the base of the GUI built first (such as the bse panels/buttons and their functions). This would let me focus more on the backend where more of my time was spent. If I was able to talk to my past self I would tell him to come into the project with less 'solid ideas' and focus on the core basic principle of the program.

