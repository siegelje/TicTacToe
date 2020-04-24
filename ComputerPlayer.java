/**
 * Write a description of class ComputerPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComputerPlayer
{
    private TicTacToeBoard comp;
    
    public ComputerPlayer(TicTacToeBoard mutual) 
    {
        comp = mutual;
    }

    public void takeTurn()
    {
        int rand = (int)(Math.random()*10);
        //ask ms. smith questions
        for( int i=0;i<100;i++)
        {
            if (comp.isValidPos(rand)==true && comp.isEmpty(rand)==true)
         {
             comp.put(rand, 'o');
             break;
            }
         if (comp.isValidPos(rand)==false || comp.isEmpty(rand)== false)
         {
             rand = (int)(Math.random()*10);
            }
        }
    }
}