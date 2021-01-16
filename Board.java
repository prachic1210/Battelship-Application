/**
 * Created by Teenwolf on 28/06/2017.
 */
class Board
{
    int grid [][] =new int[10][10];

    public Board()
    {
        for(int i=0;i<this.grid.length;i++)
        {
            for (int j=0;j<this.grid.length;j++)
            {
                grid[i][j]=0;
            }
        }
    }
}
