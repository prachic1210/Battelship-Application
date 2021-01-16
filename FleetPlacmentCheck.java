/**
 * Created by Teenwolf on 29/06/2017.
 */
public class FleetPlacmentCheck
{


    /**
     * This is the method checks whether the ship is already present at the specified position.
     *@param row    x co-ordinate to place the ship
     *@param col    y co-ordinate to place the ship
     *@param orient orientation to place the ship
     */
    protected boolean checkAlreadyPlaced(int row,int col,String orient,int length,int[][] board)
    {
        orient=orient.trim();

        if(orient.equalsIgnoreCase("V"))
        {
            for(int i=0;i<length;i++)
            {
                if(board[row+i][col]==1)
                {
                    return true;
                }
            }
        }
        else if(orient.equalsIgnoreCase("h"))
        {
            for(int i=0;i<length;i++)
            {
                if(board[row][col+i]==1)
                {
                    return true;
                }
            }
        }

        return false;

    }


    /**
     * This is the method checks whether the boundary condition are satisfied.
     *@param row    x co-ordinate to place the ship
     *@param col    y co-ordinate to place the ship
     *@param orient orientation to place the ship
     *@return true  specified position is not in the range of the grid
     */
    protected boolean checkBoundary(int row,int col,String orient,int length,int[][] board)
    {
        int position =0;
        orient=orient.trim();

        if(orient.equalsIgnoreCase("V"))
        {
            position=row +length-1;
            if(position>board.length || position<0)
            {
                return true;
            }
        }
        else
        {
            position=col +length-1;
            if(position>board.length || position<0)
            {
                return true;
            }
        }

        return false;
    }

}
