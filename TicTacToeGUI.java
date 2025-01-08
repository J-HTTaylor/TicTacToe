import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 * The following program will take the logic from the TicTacToeGame and present it in an interactive window to create a fully operational game of tic tac toe
 */
public class TicTacToeGUI extends JPanel implements ActionListener{
    private static int DEFAULT_WINDOW_HEIGHT = 600;
    private static int DEFAULT_WINDOW_WIDHT = 600;

    private TicTacToeGame game;
    private TicTacToe.BoardChoice humanPlayer;
    private TicTacToe.BoardChoice cpuChoice;
    private Button newGameButton;
    Random rand = new Random();
    
    // Creates the basic frame for the window
    public static void main(String[] args) {
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TicTacToeGUI());
        frame.setPreferredSize(new Dimension(DEFAULT_WINDOW_WIDHT, DEFAULT_WINDOW_HEIGHT));
		frame.pack();
		frame.setVisible(true);
	}

    public TicTacToeGUI(){
        this.game = new TicTacToeGame();
        this.newGame();
    }

    // Creates a new game of tic tac toe and its GUI
    private void newGame(){
        this.removeAll();
        game.newGame();

        //Setup GUI

        //Asks if the player wants to be X or O
        String[] options = {"One (X)", "Two(O)"};
          int playerNum = JOptionPane.showOptionDialog(null, "What player would you like to be", "Player Selection", 0, 2, null, options, options[0]);
          
          if (playerNum == 0){
            humanPlayer = TicTacToe.BoardChoice.X;
            JOptionPane.showMessageDialog(null, "You are playing as X");
          }

          else if (playerNum == 1){
            humanPlayer = TicTacToe.BoardChoice.O;
            JOptionPane.showMessageDialog(null, "You are playing as O");
          }

          else {
            JOptionPane.showMessageDialog(null,"Game setup has encountered an unexpected error");
            System.exit(1);
          }

          //Setup control panel
          JPanel gameControlPanel = new JPanel();
          newGameButton = new Button("New Game");
          Color unique = new Color(255,36,12);
          newGameButton.setBackground(unique);
          newGameButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newGame();
            }
          }); 
          gameControlPanel.add(newGameButton);

          //Adds a panel for the move list
          JPanel moveList = new JPanel();
          moveList.setPreferredSize(new Dimension(DEFAULT_WINDOW_WIDHT / 2, DEFAULT_WINDOW_HEIGHT / 2));
          JLabel movePanel = new JLabel();
          movePanel.setText("Moves This Game:");
          movePanel.setFont(new Font("Arial", Font.BOLD,20));
          moveList.setBackground(Color.LIGHT_GRAY);
          moveList.add(movePanel);
          

          //Adds a turn tracker and winner notification to top of jPanel
          JPanel turnPanel = new JPanel();
          JLabel txtPanel = new JLabel();
          txtPanel.setText(game.getCurrentPlayer() + "'s turn");
          txtPanel.setFont(new Font("Arial", Font.BOLD,20));
          turnPanel.add(txtPanel);


          //adds buttons to the display, changes the symbols of them when pressed and updates the turn track and move list when applicable
          JPanel gameGrid = new JPanel();
          gameGrid.setPreferredSize(new Dimension(DEFAULT_WINDOW_WIDHT / 2, DEFAULT_WINDOW_HEIGHT / 2));
          gameGrid.setLayout(new GridLayout(3, 3));
          TicTacToe[][] gameBoard = new TicTacToe[3][3];

          for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard.length; j++){
                JButton gameButton = new JButton();
                gameButton.setFont(new Font("Arial", Font.BOLD,25));
                final int k =i;
                final int l = j;
              // Changes button to player's symbol when pressed
                gameButton.addActionListener((ActionListener) new ActionListener(){
                    // Button press TODO set up to change symbol with move number
                    public void actionPerformed(ActionEvent e) {
                        JButton gameButton = (JButton) e.getSource();
                        if(game.choose(humanPlayer, k, l) == true){
                          if (humanPlayer == TicTacToeGame.BoardChoice.O){
                          gameButton.setText("O");
                          txtPanel.setText(game.getCurrentPlayer() + "'s turn");
                          game.getGameState();
                          cpuMove(gameGrid, txtPanel);
                          if (game.gameOver() == true){
                            txtPanel.setText(game.getGameState().name().replace("_", " "));
                            movesUpdate(movePanel);
                          }
                          }
                          else if (humanPlayer == TicTacToeGame.BoardChoice.X){
                            gameButton.setText("X");
                            txtPanel.setText(game.getCurrentPlayer() + "'s turn");
                            game.getGameState();
                            cpuMove(gameGrid, txtPanel);
                            if (game.gameOver() == true){
                              txtPanel.setText(game.getGameState().name().replace("_", " "));
                              movesUpdate(movePanel);
                            }
                            
                          }
                        }
                    }
                });
                gameButton.setBackground(Color.CYAN);
                gameGrid.add(gameButton);

            }
            
          }

          
          // Setup JPanel
          this.setLayout(new BorderLayout());
          this.add(gameControlPanel, BorderLayout.SOUTH);
          this.add(gameGrid, BorderLayout.WEST);
          this.add(turnPanel, BorderLayout.NORTH);
          this.add(moveList,BorderLayout.EAST);





        //View refresh
        this.requestFocus();
        this.validate();
        this.cpuChoice();
        this.processMove(gameGrid, txtPanel);

    }
    // Updates the move list when the game ends
    private void movesUpdate(JLabel move){
    if(game.gameOver() == true){
      Point[] movesMade = game.getMoves();
      String moveListConvert ="<html>Moves This Game:<br>";
      for( int i = 0; i < movesMade.length; i++){
        if ( i % 2 == 0){
          moveListConvert += "Player X: ";
        }
        else{
          moveListConvert += "Player O: ";
        }
       moveListConvert += "ROW " + movesMade[i].x + ", COL " + movesMade[i].y + "<br>";
      }
      move.setText(moveListConvert);
    }
    }

    //Determines the cpu's move and performs it to the grid
    private void cpuMove(JPanel panel, JLabel label){
      JButton cpuButton = new JButton();
      cpuButton.setFont(new Font("Arial", Font.BOLD,25));
      int randRow = rand.nextInt(3);
      int randCol = rand.nextInt(3);
      Boolean cpuTry = game.choose(cpuChoice, randRow, randCol);
      
      while (cpuTry != true && game.gameOver() != true) {
        randRow = rand.nextInt(3);
        randCol = rand.nextInt(3);
        cpuTry = game.choose(cpuChoice, randRow, randCol);
        
      }
      if (cpuChoice == TicTacToe.BoardChoice.O){
        cpuButton.setText("O");
      }
      else{
        cpuButton.setText("X");
      }

      int index = ((randRow + randCol) + (randRow * 2));
      panel.remove(index);
      panel.add(cpuButton, index);
      label.setText(game.getCurrentPlayer() + "'s turn");

    }

    //Determines the computer's symbol
    private void cpuChoice(){
      if( humanPlayer == TicTacToe.BoardChoice.O){
        cpuChoice = TicTacToe.BoardChoice.X;
      }
      else{
        cpuChoice = TicTacToe.BoardChoice.O;
      }
    }

    //Determines the cupu's first move if the cpu is going first
    private void processMove(JPanel panel, JLabel label){
        //TODO Check who's turn it is. if it is the ai they will go
        if((humanPlayer == TicTacToe.BoardChoice.X && game.isFirst() == false) ||(humanPlayer == TicTacToe.BoardChoice.O && game.isFirst() == true)){
          
          JButton cpuButton = new JButton();
          cpuButton.setFont(new Font("Arial", Font.BOLD,25));
          int randRow = rand.nextInt(3);
          int randCol = rand.nextInt(3);
          Boolean cpuTry = game.choose(cpuChoice, randRow, randCol);
          
          while (cpuTry != true) {
            randRow = rand.nextInt(3);
            randCol = rand.nextInt(3);
            cpuTry = game.choose(cpuChoice, randRow, randCol);
            
          }
          System.out.println(randRow + randCol);
          if (cpuChoice == TicTacToe.BoardChoice.O){
            cpuButton.setText("O");
          }
          else{
            cpuButton.setText("X");
          }

          int index = ((randRow + randCol) + (randRow * 2));
          panel.remove(index);
          panel.add(cpuButton, index);
          label.setText(game.getCurrentPlayer() + "'s turn");
          
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        game.choose(humanPlayer, ERROR, UNDEFINED_CONDITION);
        
    }
}
