package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 is x, 1: is o, 2 is empty
    int activePlayer = 0;

    //stops game after winner is found
    boolean gameActive = true;


    int [] gameState = {2, 2, 2,
                        2, 2, 2,
                        2, 2, 2};

    //winning positions array

    int [][] winingPositions = {
                                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                                 {0, 4, 8}, {2,4,6} };


    public void dropIn(View view){

        ImageView counter = (ImageView) view;
        //tag counter & game state array
        int tapCounter = Integer.parseInt(counter.getTag().toString());


        if (gameState[tapCounter] == 2 && gameActive) {


            gameState[tapCounter] = activePlayer;

            counter.setTranslationY(-1500);

            //checks which player is the active player

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.x);

                activePlayer = 1;


            } else {

                counter.setImageResource(R.drawable.o);
                activePlayer = 0;
            }


            counter.animate().translationYBy(1500).setDuration(300);

            //check for winning positions











            for (int[] winningPosition : winingPositions) {


                if (gameState[0] !=2 && gameState[1] !=2 && gameState[2] !=2 && gameState[3] !=2 && gameState[4] !=2 && gameState[5] !=2 && gameState[6] !=2 && gameState[7] !=2 && gameState[8] != 2 && gameActive == true) {

                    Button playAgainButton = findViewById(R.id.playAgainButton);

                    TextView winnerTextView = findViewById(R.id.winnerTextView);

                    winnerTextView.setText("It`s a tie!");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);

                }







                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2) {

                    //someone wins

                    gameActive = false;

                    String winner = "";
                    if (activePlayer == 1) {

                        winner = "X";

                    } else {
                        winner = "O";
                    }


                    //grants user the reset option

                    Button playAgainButton = findViewById(R.id.playAgainButton);
                    TextView winnerTextView = findViewById(R.id.winnerTextView);

                    winnerTextView.setText(winner + " has won");
                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);

                }
            }
        }
    }


    public void playAgain(View view){

        Button playAgainButton = findViewById(R.id.playAgainButton);
        TextView winnerTextView = findViewById(R.id.winnerTextView);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView)gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i = 0; i< gameState.length; i++){

            gameState[i] = 2;
        }

         activePlayer = 0;

         gameActive = true;



    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
