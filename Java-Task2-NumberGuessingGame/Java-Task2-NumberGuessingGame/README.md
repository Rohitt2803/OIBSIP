# Number Guessing Game (Java)

This is my submission for Task 2 under the Oasis Infobyte Java Development internship.

It's a simple, interactive CLI game built in Java where the computer picks a random number and the player has to guess it within a set number of attempts.

### What it does:
- Lets the user pick between Easy (1-50), Medium (1-100), and Hard (1-200) modes.
- Gives instant hints ("Too High!" / "Too Low!") after each guess.
- Tracks attempts left in real time and cuts off if you run out.
- Summarizes the round score and asks if you want to play again without restarting the program.
- Handles non-integer input gracefully so the game doesn't crash on typos.

### How to run it:
1. Make sure you have JDK installed.
2. Open terminal in this folder and compile:
   javac NumberGuessingGame.java
3. Run the game:
   java NumberGuessingGame
