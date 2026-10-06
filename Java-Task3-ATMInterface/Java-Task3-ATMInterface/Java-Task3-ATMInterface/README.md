# ATM Interface Simulation

This project is part of my Oasis Infobyte Java Development internship (Task 3). 

It simulates an ATM machine running inside the console, focusing on basic banking operations and clean Object-Oriented design using 5 separate classes.

### Project Structure:
- `Main.java` — Entry point that boots up the bank and ATM loop.
- `ATM.java` — Handles user menus, inputs, and display logic.
- `Bank.java` — Stores accounts and handles user login verification.
- `Account.java` — Manages balances, deposits, withdrawals, and account-to-account transfers.
- `Transaction.java` — Records individual actions with timestamps for the history log.

### Key Features:
- Login authentication with a 3-attempt limit before lockout.
- Live balance checks before any withdrawal or fund transfer.
- Working inter-account transfers between pre-loaded test users.
- Full transaction statement tracking each action during the session.

### How to run:
1. Compile all files together:
   javac *.java
2. Run the main file:
   java Main

### Test Accounts:
- ID: `user101` | PIN: `1234`
- ID: `user102` | PIN: `5678`
