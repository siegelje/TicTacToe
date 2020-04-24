
/**
 * Write a description of class HumanPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HumanPlayer implements PlayerInterface
{
    private TicTacToeBoard game;
    
    public HumanPlayer(TicTacToeBoard mutual) 
    {
        game = mutual;
    }
    
    public void takeTurn(int position)
    {
        if(game.isValidPos(position)==true && game.isEmpty(position)==true)
        {
            game.put(position, 'x');
        }
        else
        {
            //print error???
        }
    }
    
}
