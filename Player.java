/**
 * Created by Pallavi on 28/06/2017.
 */
class Player
{
    String name;
    Board board;
    boolean hit;
    int hiddenGrid[][]=new int [10][10];
    int gird [][]=new int [10][10];
    int shipCount;


    public Player(String name,Board board)
    {
        this.name=name;
        this.board=board;
        this.hit=true;
        this.shipCount=17;
        this.hiddenGrid=this.board.grid;

    }


}
