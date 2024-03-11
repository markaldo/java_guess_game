package z03_eng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGame extends JFrame implements ActionListener {
    private JLabel lblTitle, lblRange, lblGuess, lblResult;
    private JTextField txtMax, txtGuess;
    private JButton btnSubmitMax, btnSubmitGuess, btnNewGame;
    private int randomNumber;
    private int numGuesses;

    public GuessingGame() {
        super("Guessing Game");
        setSize(400, 200);
        setLayout(new GridLayout(6, 1));

        lblTitle = new JLabel("Guess the number between 0 and X.");
        add(lblTitle);

        JPanel rangePanel = new JPanel();
        rangePanel.setLayout(new FlowLayout());

        txtMax = new JTextField(5);
        rangePanel.add(txtMax);

        btnSubmitMax = new JButton("Submit Max Range");
        btnSubmitMax.addActionListener(this);
        rangePanel.add(btnSubmitMax);

        add(rangePanel);

        lblGuess = new JLabel("Enter your guess:");
        add(lblGuess);

        txtGuess = new JTextField();
        add(txtGuess);

        btnSubmitGuess = new JButton("Submit Guess");
        btnSubmitGuess.addActionListener(this);
        add(btnSubmitGuess);

        btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(this);
        add(btnNewGame);

        lblResult = new JLabel("");
        add(lblResult);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmitMax) {
            int max = Integer.parseInt(txtMax.getText());

            if (max < 1) {
                lblResult.setText("Invalid range.");
                return;
            }

            lblTitle.setText("Guess the number between 0 and " + max);
            txtMax.setEditable(false);
            txtGuess.setEditable(true);
            btnSubmitMax.setEnabled(false);
            btnSubmitGuess.setEnabled(true);

        } else if (e.getSource() == btnSubmitGuess) {
            int max = Integer.parseInt(txtMax.getText());

            if (randomNumber == 0) {
                randomNumber = (int)(Math.random() * (max + 1));
            }

            int guess = Integer.parseInt(txtGuess.getText());
            numGuesses++;

            if (guess < randomNumber) {
                lblResult.setText("Value too small.");
            } else if (guess > randomNumber) {
                lblResult.setText("Value too large.");
            } else {
                lblResult.setText("You guessed it! It took you " + numGuesses + " guesses.");
                txtGuess.setEditable(false);
                btnSubmitGuess.setEnabled(false);
                randomNumber = 0;
            }

        } else if (e.getSource() == btnNewGame) {
            randomNumber = 0;
            numGuesses = 0;

            lblTitle.setText("Guess the number between 0 and X");
            txtMax.setText("");
            txtMax.setEditable(true);
            txtGuess.setText("");
            txtGuess.setEditable(false);
            btnSubmitMax.setEnabled(true);
            btnSubmitGuess.setEnabled(false);
            lblResult.setText("");
        }
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
    }
}



