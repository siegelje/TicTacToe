
/**
 * class UserInterfaceGame is an example of a start that
 * uses the Parser, CommandWord, Commands structure
 * for a text based game.
 * 
 * Handout for APCS 2020
 * To be modified by students
 *
 * @author J. Smith
 * @version February 2020
 */
public class UserInterfaceGame
{
   private Parser parser;
   private HumanPlayer hp;
   private ComputerPlayer cp;
   private TicTacToeBoard bd;
    /**
     * Constructor for objects of class TicTacToeGame
     */
    public UserInterfaceGame()
    {
        parser = new Parser();
        bd = new TicTacToeBoard(3);
        bd.clear();
        hp = new HumanPlayer(bd);
        cp = new ComputerPlayer(bd);
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        bd.clear();
        bd.toString();
        while (true) {
            Command command = parser.getCommand();

            boolean turnStatus = processCommand(command);
            if (!turnStatus) // bad info entered
            {
                printError();
                
            }
            else if (command.getCommandWord().equals("quit") && turnStatus)
                {
                    break;
                }
        }
        gameOver();
           }

    /**
     * Start a new game
     */
    private void freshStart ()
    {
        //print blank
    }

    private void gameOver()
    {
        System.out.println("Thank you for playing TicTacToe");

    }
    
    private void printError ()
    {
        System.out.println("Hmm... try again.");
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You are playing TicTacToe");
        System.out.println("You should never win, but first");
        System.out.println("you must play LOTS of games against the computer");
        System.out.println("to train it to play well.");
        
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        boolean turnState = false;
        String commandWord = command.getCommandWord();
        if (commandWord.equals("quit")) {
            turnState = quit(command);
        }
        else if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("move")) {
            turnState = move (command);
            
        }
        return turnState;
    }

    private void printHelp() 
    {
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()||command.hasThirdWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /** 
     * "Move" was entered. 
     * make the move for the player
     * @return true if the player moved correctly, false if error
     *      */
    private boolean move(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Move command requires a position number 0..8");
            return false;
        }
        else {
            int position = Integer.parseInt(command.getSecondWord());
            System.out.println("Player is moving to position " + position);
            hp.takeTurn(position);
            bd.toString();
            cp.takeTurn();
            System.out.println("Computer is moving...");
            bd.toString();
            return true;
        }
    }
}
