import java.awt.Point;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JButton;

public class test {
    public static void main(String[] args) {
        
        TicTacToeGame tester = new TicTacToeGame();
        //tester.testSys();
        System.out.println();
        TicTacToe.BoardChoice[][] testBoard = {
            {TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
            {TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
            {TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O}};

            tester.choose(TicTacToe.BoardChoice.X, 1, 2);
            tester.choose(TicTacToe.BoardChoice.O, 1, 1);
            tester.choose(TicTacToe.BoardChoice.X, 0, 2);
            tester.choose(TicTacToe.BoardChoice.O, 2, 1);
            tester.choose(TicTacToe.BoardChoice.X, 2, 2);

            for( int i = 0; i < tester.getGameGrid().length; i++){
                for( int j = 0; j < tester.getGameGrid()[i].length; j++){
                System.out.println(tester.getGameGrid()[i][j]);
                System.out.println(tester.getGameState());
                }
            }
    }


 public void actionPerformed(ActionEvent e) {
                        JButton gameButton = (JButton) e.getSource();
                        if(game.choose(humanPlayer, k, l) == true){
                          if (game.getGameState() != TicTacToe.GameState.IN_PROGRESS){
                            txtPanel.setText(game.getCurrentPlayer());
                          }

                          else if (humanPlayer == TicTacToeGame.BoardChoice.O){
                          gameButton.setText("O");
                          txtPanel.setText(game.getCurrentPlayer());
                          game.gameOver();
                          }
                          else if (humanPlayer == TicTacToeGame.BoardChoice.X){
                              gameButton.setText("X");
                              txtPanel.setText(game.getCurrentPlayer());
                              game.gameOver();
                              }
                        }

                    }


    }


    // Changes button to player's symbol when pressed
    gameButton.addActionListener((ActionListener) new ActionListener(){
        // Button press TODO set up to change symbol with move number
        public void actionPerformed(ActionEvent e) {
          processMove();
        }
    });
    gameButton.setForeground(Color.LIGHT_GRAY);
    gameGrid.add(gameButton, BorderLayout.CENTER);
}
JButton gameButton = new JButton();