import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Pallavi on 28/06/2017.
 */
 class Ship extends FleetPlacmentCheck
{

    int row=0,col=0,shipCount=5;
    int length=0;
    String orientation;
    boolean flagforInput=false;
    Board board ;
    Player player;


    public Ship(Board b,Player p)
    {
        this.player=p;
        this.board=b;
        shipPlacement();
    }


    /**
     * This is the method checks whether user has enter appropriate the length of the ship .
     * @return true   Entered len is proper.
     *
     */
    private boolean checkShiplen()
    {
        if(length==5 || length==4 || length==3 || length==2)
        {
            return true;
        }

        return false;
    }


    /**
     * This is the method arranges the ship across the gird for a player.
     *
     */
    private void shipPlacement()
    {
        Scanner sc=new Scanner(System.in);

        //Loop for placing each ship on the grid
        for (int i=0;i<shipCount;i++)
        {
            //Loop for checking whether the length entered is appropriate
            while (checkShiplen() != true) {
                try
                {
                    System.out.println("Please enter the appropriate length i.e");
                    System.out.println("Carrier-5,Battleship-4,Cruiser-3,Submarine-3,Destroyer-2");
                    length = sc.nextInt();
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Invalid Entry.Please enter the appropriate length");
                    sc.next();
                }


            }

            //Loop is for checking whether the co-ordinates entered are appropriate
            while (this.flagforInput==false)
            {
                System.out.println("Enter the position of the ship to be placed with size " + this.length);
                //System.out.println("Example: 2 3 v");
                try
                {
                    row = sc.nextInt();
                    col = sc.nextInt();
                    orientation = sc.nextLine();
                    if (this.checkBoundary(row, col, orientation,length,this.board.grid) != true &&
                            this.checkAlreadyPlaced(row, col, orientation,length,this.board.grid) != true)
                    {
                        this.arrangeShip(row, col, orientation);
                        flagforInput=true;
                    } else
                    {
                        System.out.println("Please re-enter the co-ordinates");
                        this.flagforInput=false;
                    }

                }
                catch (InputMismatchException e)
                {
                    System.out.println("Invalid Entry.Please enter the appropriate data");
                    this.flagforInput=false;
                    sc.next();
                }

            }

            this.flagforInput=false;
            length = 0;
        }

        System.out.println("Ship successfully placed for player  "+this.player.name);
        this.print();
        System.out.println("=====================================================");
    }



    /**
     * This is the method acts as a helper function for placement of the ship.
     *
     */
    private void arrangeShip(int row,int col,String orient)
    {

        orient=orient.trim();

        if(orient.equalsIgnoreCase("v"))
        {

            for(int i=row;i<row+length;i++)
            {
                this.board.grid[i][col]=1;
            }
        }
        else if (orient.equalsIgnoreCase("h"))
        {
            for(int i=col;i<col+length;i++)
            {
                this.board.grid[row][i]=1;
            }
        }
    }



    /**
     * This is the method prints the gird for player after placement of the ship.
     *
     */
    private void print()
    {
        for (int i=0;i<this.board.grid.length;i++)
        {
            for(int j=0;j<this.board.grid.length;j++)
            {
                System.out.print(this.board.grid[i][j]);
            }

            System.out.println(" ");
        }
    }
}

