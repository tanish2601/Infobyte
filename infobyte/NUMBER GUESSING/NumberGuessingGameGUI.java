import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame {
    private int secretNumber;
    private int attempts;

    private JTextField guessField;
    private JLabel resultLabel;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 100);
        setLocationRelativeTo(null);

        secretNumber = new Random().nextInt(100) + 1;
        attempts = 0;

        JLabel promptLabel = new JLabel("Guess the number (1-100):");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        setLayout(new FlowLayout());
        add(promptLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);

        setVisible(true);
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            attempts++;

            if (userGuess == secretNumber) {
                resultLabel.setText("Congratulations! You guessed it in " + attempts + " attempts.");
            } else if (userGuess < secretNumber) {
                resultLabel.setText("Try a higher number.");
            } else {
                resultLabel.setText("Try a lower number.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGuessingGameGUI());
    }
}
