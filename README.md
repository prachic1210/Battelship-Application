# Battleship
Battleship game using java
    Batlleship is a two player guessing game.it is played on the board on which the ships of each players are marked and 
    the location of the ships from the other player is concealed.The players shoot at each other ships where the objective of 
    the game is to destroy the opponents ships completely.
## Description :

### Classes :

- **Board.java**
   - _Board()_
        - Constructor for initializing the 2 dimensional array grid 
- **Player.java**
    - name:        Name of the player 
    - hit :        Boolean variable to keep a track whether the player has shoot the target
    - board :      Instance  of the Board.java class
    - hiddenGrid : Grid where the player's ships are placed 
    - shipCount  : Total number of ship's 
    - _Player()_
        - Constructor of initializing the value of the name,hit,board,hiddenGrid,shipCount
 - **Ship.java**
     - _shipPlacement()_
          - This function after verifying the input from the user calls the arrange method for placing the ship
     - _checkShiplen()_
          - This acts as a  helper function for verifying the whether the player has entered an appropriate 
                   length of the ships
     - _arrangeShip()_
          - This functions places the ship on the grid with the specified row,col and orientation by the player
     - _print()_
          - This acts as a helper function for displaying the grid after the placement of the ships
- **FleetPlacementCheck**
     - _checkAlreadyPlaced()_
         - This function checks whether the specified loction by the player has been already occupied or not 
     - _checkBoundary()_
         - This function checks whether the boundary conditions are satisfied
- **Game.java**
     - _start()_
          - This function initailizes the game by calling the shipPlacement method therefore arranging the ships of the player 
     - _play()_
          - This function starts the game between the two players
     - _win()_
          - This function checks the shipCount and displays the winner of the game.     
