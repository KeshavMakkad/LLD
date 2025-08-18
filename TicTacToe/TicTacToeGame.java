import java.util.Scanner;

public class TicTacToeGame {
    private Player playerOne;
    private Player playerTwo;
    private Board game;
    private Player currentPlayer;
    Scanner scn = new Scanner(System.in);

    void startGame() {
        setUpPlayers();
        setupBoard();
        
        playGame();
    }

    public void setUpPlayers(){
        String playerOneName;
        while (true) {
            System.out.println("Please enter player one's name");
            playerOneName = scn.nextLine().trim();
            if (!playerOneName.isEmpty()) {
                break;
            }
            System.out.println("Name cannot be empty. Try again.");
        }
        
        char playerOneSymbol;
        while (true) {
            System.out.println("Please enter " + playerOneName + "'s symbol");
            String symbolInput1 = scn.nextLine();
            if (!symbolInput1.isEmpty()) {
                playerOneSymbol = symbolInput1.charAt(0);
                break;
            }
            System.out.println("Symbol cannot be empty. Try again.");
        }
        this.playerOne = new Player(playerOneName, playerOneSymbol);
        
        String playerTwoName;
        while (true) {
            System.out.println("Please enter player two's name");
            playerTwoName = scn.nextLine().trim();
            if (playerTwoName.isEmpty()) {
                System.out.println("Name cannot be empty. Try again.");
                continue;
            }
            if (playerTwoName.equals(playerOne.getName())) {
                System.out.println("Name already taken by player one. Try again.");
                continue;
            }
            break;
        }
        
        char playerTwoSymbol;
        while (true) {
            System.out.println("Please enter " + playerTwoName + "'s symbol");
            String symbolInput2 = scn.nextLine();
            if (symbolInput2.isEmpty()) {
                System.out.println("Symbol cannot be empty. Try again.");
                continue;
            }
            playerTwoSymbol = symbolInput2.charAt(0);
            if (playerTwoSymbol == playerOne.getSymbol()) {
                System.out.println("Symbol already taken by player one. Try again.");
                continue;
            }
            break;
        }
        this.playerTwo = new Player(playerTwoName, playerTwoSymbol);
    }

    public void setupBoard(){
        int size = 0;
        while (true) {
            System.out.println("Please enter the size of the board (> 1):");
            if (scn.hasNextInt()) {
                size = scn.nextInt();
                scn.nextLine();
                if (size > 1) {
                    break;
                } else {
                    System.out.println("Board size must be greater than 1. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scn.nextLine();
            }
        }
        this.game = new Board(size);
    }

    private void playGame(){
        int gameSize = this.game.getSize();
        int maxMoves = gameSize * gameSize;

        boolean gameEnded = false;
        
        currentPlayer = playerOne;
        int moves = 0;

        while (!gameEnded && moves < maxMoves) {
            game.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0-based):");
            int x = scn.nextInt();
            int y = scn.nextInt();

            if (!game.addSymbol(x, y, currentPlayer.getSymbol())) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            moves++;

            if (game.checkWin()) {
                game.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else if (moves == maxMoves) {
                game.printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
            }
        }
    } 
}