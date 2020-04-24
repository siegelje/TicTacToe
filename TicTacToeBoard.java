
/**
 * Write a description of class TicTacToeBoard here.
 *
 * @author j. Siegel
 * @version Mar 2020
 */
public class TicTacToeBoard implements Board
{
    private char[][] gamebd;
    private int sz;

    public TicTacToeBoard(int val)
    {
        gamebd = new char[val][val];
        sz = val;
    }

    /*
     * @pre rows == cols, the structure must be square
     * @return the dimension of the board, # rows or #cols
     */
    public int size ()
    {
        return (sz);
    }

    /*
     * set all elements of the board to a default value
     */
    public void clear ()
    {
        for (int r = 0; r < size(); r++)
        {
            for (int c = 0; c < size(); c++)
            {
                gamebd[r][c] = '-';
            }
        }
    }

    /*
     * @return true if the input symbol is valid on this board
     *  false otherwise
     */    
    public boolean isValidSymbol (char symbol)
    {
        if (symbol == 'x' || symbol == '-' || symbol == 'o')
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /*
     * @return true if position is within the grid, false otherwise
     */
    public boolean isValidPos (int position)
    {
        if (((size()*size()) - position) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     *  put replaces the character in position
     *  with the new symbol
     *  @param position 0 <= position < size()*size()
     *  @param symbol must be valid on this board
     *  @return -1 if position is invalid, 
     *      otherwise returns position
     *  @throws IllegalArgumentException is symbol is not valid
     */
    public int put (int position, char symbol)
    {
        if (isValidPos(position) == true)
        {
            gamebd[posToRow(position)][posToCol(position)] = symbol;
            return position;
        }
        else 
        {
            return -1;
        }
    }

    /*
     * @return Return a String format of the 2D board
     * with spaces between symbols and returns
     * at the end of rows.
     */
    public String toString ()
    {
        String add = "";
        for (int r = 0; r < size(); r++)
        {
            for (int c = 0; c < size(); c++)
            {
                add += gamebd[r][c] + " ";
            }
            System.out.println();
        }
        return add;
    }

    /*
     * @param 0 <= position < size()*size()
     * @return true if the symbol at position is EMPTY, false otherwise
     * @throw IllegalArgumentException if position is invalid
     */
    public boolean isEmpty (int position)
    {
        if ((isValidPos(position) == true) &&
        (gamebd[posToRow(position)][posToCol(position)] == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * @return a copy of this board
     */
    public TicTacToeBoard copy ()
    {
        TicTacToeBoard cpy1 = new TicTacToeBoard(3);
        for (int r = 0; r < size(); r++)
        {
            for (int c = 0; c < size(); c++)
            {
                cpy1.gamebd[r][c] = gamebd[r][c];
            }
        }
        return cpy1;
    }

    /**
     * override the Object equals method
     * to compare this board to
     * the other board symbol for symbol
     * 
     * It is necessary to cast other to Board using 
     * this line of code -- put this as the first line
     * in your program.
     * 
     * E otherboard = (E)other; 
     * 
     * Where E is the name of your board implementation
     * 
     */
    @Override
    public boolean equals (Object other)
    {
        TicTacToeBoard otherboard = (TicTacToeBoard)other;
        for (int r = 0; r < size(); r++)
        {
            for (int c = 0; c < size(); c++)
            {
                if (otherboard.gamebd[r][c] != gamebd[r][c])
                {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * posToRow
     * @param int 0 <= pos < BOARD_SIZE*BOARD_SIZE
     * @return the row the position is located on
     */
    private int posToRow (int pos)
    {
        int row = pos/size();
        return row;
    }

    /*
     * posToCol
     * @param int 0 <= pos < BOARD_SIZE*BOARD_SIZE
     * @return the column the position is located on
     */
    private int posToCol (int pos)
    {
        int col = pos%size();
        return col;
    }

    /*
     * @return the position 0..8 given a (row, col) pair
     */
    private int rowColToPos (int row, int col)
    {
        int pos = row*size() + col;
        return pos;
    }

    //add check for win
    public boolean check4Win()
    {
        for (int c = 0; c < 3; c++)
        {
            if (gamebd[0][c] == (gamebd[1][c]) && gamebd[1][c] == gamebd[2][c])
            {
                return true;
            }
        }
        for (int r = 0; r<3; r++)
        {
            if (gamebd[r][0] == gamebd[r][1] && gamebd[r][1] == gamebd[r][2])
            {
                return true;
            }
        }
        if (gamebd[0][0] == gamebd[1][1] && gamebd[1][1] == gamebd[2][2])
        {
            return true;
        }
        if (gamebd[0][2] == gamebd[1][1] && gamebd[1][1] == gamebd[2][0])
        {
            return true;
        }
        return false;
    }
}
