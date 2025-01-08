import java.awt.Point;
import java.util.Arrays;
/*
 * The following code is the backend of the tic tac toe game. The following code will be able to create an empty game board, track the moves, reset the game, see whose turn it currently is, check to see who has won
 * @author: James Taylor
 * 
 */
public class TicTacToeGame implements TicTacToe{
    
private BoardChoice[][] gameBoard;
private Point[] moveList;
//private int[] scoreBoard; //keeps track of win/lose in current session
private GameState currentState;
private int turnNum;
private BoardChoice lastPlayer;

// initialises the gameBoard, moveList,scoreBoard and playerChoice
public TicTacToeGame(){
     gameBoard = new BoardChoice[3][3];
     for (int i = 0; i <gameBoard.length;i++){
        for (int j = 0; j <gameBoard[i].length;j++){
            gameBoard[i][j] = BoardChoice.OPEN;
            
        }
    }

     moveList = new Point[9];
     //scoreBoard = new int[] {0,0};
     currentState = GameState.IN_PROGRESS;
}

    //Resets the board back to its base (clean) state, ready for the next game and asks for the player to choose their turn symbol again
    public void newGame() {
        currentState = GameState.IN_PROGRESS;

        for (int i = 0; i <gameBoard.length;i++){
            for (int j = 0; j <gameBoard[i].length;j++){
                gameBoard[i][j] = BoardChoice.OPEN;
                
            }
        }
        moveList = new Point[9];
        turnNum = 0;
        lastPlayer = BoardChoice.OPEN; // set as O due to X always going first

    }

    // Gets the positional choice for they player's symbol and checks to see if it a valid unoccupied square
    public boolean choose(TicTacToe.BoardChoice player, int row, int col) {
        Boolean validation;

        if(currentState != GameState.IN_PROGRESS){
            validation = false;
        }
        else if (player == lastPlayer){
            validation = false;
        }

        else if (gameBoard[row][col].equals(BoardChoice.OPEN)){
            gameBoard[row][col] =player;
            Point newValid = new Point(row, col);
            moveList[turnNum] = newValid;
            turnNum++;
            validation = true;
            lastPlayer = player;
            gameOver();
        }

        else{
            validation = false;
        }

        return validation;
    }

    // Checks if a 3-in-a-row has occured. If so the game ends
    public boolean gameOver() {
        Boolean gameOverState = false;

        //Horizontal check
        for( int i = 0; i < gameBoard.length; i++){
            if (gameBoard[i][1] == BoardChoice.OPEN){
                    gameOverState = false;
                    continue;
            }
            else if (gameBoard[i][1] == gameBoard[i][0] && gameBoard[i][1] == gameBoard[i][2]){
                    gameOverState = true;
                    if ( gameBoard[i][1] == BoardChoice.X) {
                        currentState = GameState.X_WON;
                        return gameOverState;
                    }
                    else{
                        currentState = GameState.O_WON;
                        return gameOverState;
                    }
            }
        }

            // Vertical check
        for( int i = 0; i < gameBoard.length; i++){
                for( int j = 0; j < gameBoard[i].length; j++){
                    if (gameBoard[1][j] == BoardChoice.OPEN){
                           gameOverState = false;
                           continue;
                   }
                   else if (gameBoard[1][j] == gameBoard[0][j] && gameBoard[1][j] == gameBoard[2][j]){
                       gameOverState = true;
                       if ( gameBoard[1][j] == BoardChoice.X) {
                        currentState = GameState.X_WON;
                        return gameOverState;
                        }
                        else{
                        currentState = GameState.O_WON;
                        return gameOverState;
                        }
                   }
               }
            }

        //Checks for diagonol 3-in-a-row

            if (gameBoard[1][1] == BoardChoice.OPEN){
                gameOverState = false;
                return gameOverState;
            }
            else if (gameBoard[1][1] == gameBoard[0][0] && gameBoard[1][1] == gameBoard[2][2]){
                gameOverState = true;
                if ( gameBoard[1][1] == BoardChoice.X) {
                    currentState = GameState.X_WON;
                    return gameOverState;
                    }
                    else{
                    currentState = GameState.O_WON;
                    return gameOverState;
                    }
                
            }
            else if (gameBoard[1][1] == gameBoard[0][2] && gameBoard[1][1] == gameBoard[2][0]){
                gameOverState = true;
                if ( gameBoard[1][1] == BoardChoice.X) {
                    currentState = GameState.X_WON;
                    return gameOverState;
                    }
                    else{
                    currentState = GameState.O_WON;
                    return gameOverState;
                    }
            }

        //Checks to see if all spaces are occupied (results in a tie at this point)
        if(gameOverState == false && turnNum == 9){
            gameOverState = true;
            currentState = GameState.TIE;
            return gameOverState;
        }
        return gameOverState;
    }

    // Checks to see if the game is over. if it is the winner is declared
    public TicTacToe.GameState getGameState() {
        TicTacToe.GameState state = currentState;
        return state;
    }
   
    // Returns a copy of the current game board
    public TicTacToe.BoardChoice[][] getGameGrid() {
        BoardChoice[][] gameBoardCopy = new BoardChoice[3][3];
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++){
                gameBoardCopy[i][j] = gameBoard[i][j];
            }
        }
        return gameBoardCopy;
    }

    //Returns a copy of the moves list
    public Point[] getMoves() {
        Point[] moveListCopy = new Point[turnNum];
        for (int i = 0 ; i < turnNum; i++){
           
            moveListCopy[i] = moveList[i];

        }
        return moveListCopy;
    }

    // Returns who the current plyer is
    public String getCurrentPlayer(){
        String currentPlayer;
        if (turnNum % 2 == 0){
            currentPlayer = "X";
        }
        else{
            currentPlayer = "O";
        }
        return currentPlayer;
    }

    public Boolean isFirst(){
        if(turnNum == 0){
            return true;
        }
        else{
            return false;
        }
    }


     //test outputs, SHOULD ONLY BE USED FOR TEST SCENARIOS
     public void testSys(){
        for (int i = 0; i <gameBoard.length;i++){
            for (int j = 0; j <gameBoard[i].length;j++){
                System.out.println(gameBoard[i][j]);
            }
        }
        System.out.println(Arrays.toString(moveList));
        //System.out.println(Arrays.toString(scoreBoard));
    }

}
