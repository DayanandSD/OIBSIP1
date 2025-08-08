import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int totalScore = 0;
        int rounds = 3; // Number of rounds

        JOptionPane.showMessageDialog(null, "🎮 Welcome to Guess the Number!\nYou have 3 rounds. Good luck!");

        for (int round = 1; round <= rounds; round++) {
            Random rand = new Random();
            int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean hasGuessedCorrectly = false;

            while (attempts < maxAttempts) {
                String guessStr = JOptionPane.showInputDialog(null,
                        "🎯 Round " + round + ": Guess a number between 1 and 100\nAttempt " + (attempts + 1) + " of " + maxAttempts);
                
                if (guessStr == null) {
                    JOptionPane.showMessageDialog(null, "Game exited.");
                    return;
                }

                int guess = Integer.parseInt(guessStr);
                attempts++;

                if (guess == numberToGuess) {
                    JOptionPane.showMessageDialog(null, "✅ Correct! You guessed it in " + attempts + " attempt(s).");
                    hasGuessedCorrectly = true;
                    totalScore += (10 - attempts + 1); // More points for fewer attempts
                    break;
                } else if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "📉 Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "📈 Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                JOptionPane.showMessageDialog(null, "❌ Out of attempts! The correct number was: " + numberToGuess);
            }
        }

        JOptionPane.showMessageDialog(null, "🎉 Game Over!\nYour Total Score: " + totalScore);
    }
}