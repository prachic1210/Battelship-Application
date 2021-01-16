import java.util.Scanner;

/**
 * Created by Pallavi on 28/06/2017.
 */
public class Game
{
    Player player;
    boolean boundaryFlag=false;

    /**
     * This is the start  method which helps in initialzing the various variable to begin the game.
     * @param  p This is the player class object.
     */
    private  void start(Player p,Board b)
    {
        System.out.println("Placing ship for player "+p.name);
        Ship ship=new Ship(b,p);

    }

    /**
     * This is the play  method which begin the game .
     * @param  player1 This is the player class object.
     * @param  player2 This is the player class object
     */
    private  void play(Player player1,Player player2)
    {
        System.out.println("Lets begin the game :"+player1.name);

        //main loop for starting the play between the players
        while(true) {

            //player1 playing
            while (player1.hit == true) {
                if (player1.shipCount==0 || player2.shipCount==0)
                    break;
                System.out.println("Player1's Chance :");
                this.startGame(player1);
            }

            //player2 playing
            while (player2.hit == true) {
                if (player1.shipCount==0 || player2.shipCount==0)
                    break;
                System.out.println("Player2's Chance :");
                this.startGame(player2);
            }

            //Either win, the loop must break
            if (player1.shipCount==0 || player2.shipCount==0)
            {
                break;
            }

            //continuing the game till shipCount becomes 0 of either player
            player1.hit=true;
            player2.hit=true;

        }



    }


    /**
     * This is the win  method which states who won  the game .
     * @param  player1 This is the player class object.
     * @param  player2 This is the player class object
     */
    private void win(Player player1,Player player2)
    {
        if(player1.shipCount==0)
        {
            System.out.println(player1.name+" Congratulations you have won the game");
        } else if(player2.shipCount==0)
        {
            System.out.println(player2.name+" Congratulations you have won the game");
        }

    }


    /**
     * This is the startGame  method takes player input and checks whether the player has shoot the target or not .
     * @param  player This is the player class object.
     *
     */
    private void startGame(Player player)
    {

       while(this.boundaryFlag==false) {
            int row, col;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the co-ordinates for shooting the ships");
            row = sc.nextInt();
            col = sc.nextInt();
            if (checkBoundary(player, row, col) == true &&  checkAlreadyEntered(row,col,player)==true)
            {
                if(player.hiddenGrid[row][col]==1)
                {

                    player.hit = true;
                    --player.shipCount;
                    player.gird[row][col] = 2;
                    System.out.println(player.name + "You have shoot the ship successfully :");
                    System.out.println("=====================================================");
                    this.display(player);

                } else {
                    System.out.println(player.name+" You have failed to shoot the target :");
                    player.gird[row][col]=2;
                    player.hit=false;
                    System.out.println("Next player's chance");
                }

                this.boundaryFlag=true;
            } else
                {
                    System.out.println("Please enter the value in range of the grid or the value must have already been entered:");
                    this.boundaryFlag=false;
            }
        }

        this.boundaryFlag=false;        //reinitializing the boundary flag value
    }

    /**
     * This is the checkAlreadyEntered  method which  checks whether the entered value by the player is already entered or not.
     * @param  player This is the player class object.
     * @param  row    specified ocation of the grid
     * @param  col    specified location of the gird
     */
    private boolean checkAlreadyEntered(int row,int col,Player player)
    {
        if(player.gird[row][col]!=2)
        {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * This is the checkBoundary  method which  checks th eboundary conditions.
     * @param  p This is the player class object.
     * @param  row    specified ocation of the grid
     * @param  col    specified location of the gird
     */
    private  boolean checkBoundary(Player p,int row,int col)
    {
        if(row<p.hiddenGrid.length && col<p.hiddenGrid.length)
        {
            return true;
        }

        return false;
    }


    /**
     * This is the display  method prints the grid value.
     * @param  p This is the player class object.
     */
    public void display(Player p)
    {
        for (int i=0;i<p.gird.length;i++)
        {
            for(int j=0;j<p.gird.length;j++)
            {
                System.out.print(p.gird[i][j]);
            }
            System.out.println(" ");
        }
    }

    /**
     * This is the main method which creates the two player objects and starts the game.
     */
    public static void main(String[] args)
    {
        Game game=new Game();
        Board board1=new Board();
        Board board2=new Board();
        Player player1=new Player("Player1",board1);
        Player player2=new Player("Player2",board2);
        game.start(player1,board1);
        game.start(player2,board2);
        game.play(player1,player2);
        game.win(player1,player2);

    }
}
