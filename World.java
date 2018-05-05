import javax.swing.*;
import java.awt.*;
// File Name: World.java
// Developers: Wael Jamal Alhashemi
// Purpose: creates a singleton world(2D array) which we can display, add or move items in it.
// Inputs: World: rows and columns; both int. add: item(movable, immovable or autonomous), int row, int column
// step: None. display: none.
// Outputs: None
// Modifications
// ==========
// WA Apr 16th 2018
public class World {
    //the singleton pattern
    private static ItemObject[][] theWorld;
    JFrame mainFrame = new JFrame("World");


    // Name: World
    // Developers: Wael Jamal Alhashemi
    // Purpose: constructor that creates a 2D array
    // Inputs: rows and columns. Both are int
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    private World(int rows, int columns) {
        theWorld = new ItemObject[rows][columns];
    }

    private static World ourInstance = new World(0,0);

    public static World getInstance() {
        return ourInstance;
    }

    // Name: display
    // Developers: Wael Jamal Alhashemi
    // Purpose: displays a grid GUI of the world using swing.
    // Inputs: None
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void display() {
        JLabel label;
        JPanel mainPanel = new JPanel(new GridLayout(theWorld.length, theWorld[0].length));
        JPanel[][] panels = new JPanel[theWorld.length][theWorld[0].length];

        //JFrame mainFrame = new JFrame("World");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setBackground(Color.BLACK);
        for (int i = 0; i < theWorld.length; i++) {
            for (int j = 0; j < theWorld[i].length; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.white);
                panels[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                if (theWorld[i][j] != null) {
                    label = new JLabel("" + theWorld[i][j].getToken());
                    panels[i][j].add(label);
                }
                mainPanel.add(panels[i][j]);
            }
        }
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);
    }

    // Name: add
    // Developers: Wael Jamal Alhashemi
    // Purpose: adds an item to the world
    // Inputs: rows and columns. Both are int and item (movable, immovable or autonomous object)
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void add(ItemObject item, int x, int y) {
        if (theWorld[x][y] != null) throw new IllegalArgumentException("Cell is occupied");
        theWorld[x][y] = item;
    }

    // Name: step
    // Developers: Wael Jamal Alhashemi
    // Purpose: updates the position of all the Autonomous and Movable objects
    // Inputs: None
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void step() {
        int emptySpace;
        Autonomous autonomousObject;
        int randomDirection;
        //at the beginning, no autonomous items has moved yet
        for(int i=0;i< theWorld.length;i++){
            for(int j = 0;j<theWorld[i].length;j++){
                if(theWorld[i][j] != null){
                    if (theWorld[i][j].getName().equals("Autonomous")) {
                        autonomousObject = (Autonomous) theWorld[i][j];
                        autonomousObject.setMarker(false);
                    }
                }
            }
        }
        //iterate through the world and update position if its an Autonomous item
        for (int i = 0; i < theWorld.length; i++) {
            for (int j = 0; j < theWorld[i].length; j++) {
                if (theWorld[i][j] != null) {
                    if (theWorld[i][j].getName().equals("Autonomous")) {
                        autonomousObject = (Autonomous) theWorld[i][j];
                        if(autonomousObject.getMarker() == true) continue;
                        randomDirection = (int) (Math.random() * 4);
                        switch (randomDirection){
                            //north
                            case 0:
                                autonomousObject.setMarker(true);
                                if(checkVerticalUp(theWorld,theWorld[i][j].getX(),theWorld[i][j].getY())){
                                    emptySpace = findEmptySpaceVerticalUp(theWorld,theWorld[i][j].getX(),theWorld[i][j].getY());
                                    if(emptySpace != -1){
                                        for (int k = emptySpace; k < theWorld[i][j].getX(); k++) {
                                            theWorld[k+1][j].updateYUp();
                                            theWorld[k][j] = theWorld[k+1][j];
                                        }
                                        theWorld[i][j] = null;
                                    }
                                }
                                break;
                            //east
                            case 1:
                                autonomousObject.setMarker(true);
                                if(checkHorizontalRight(theWorld,theWorld[i][j].getX(),theWorld[i][j].getY())) {
                                    emptySpace = findEmptySpaceHorizontalRight(theWorld, theWorld[i][j].getX(), theWorld[i][j].getY());
                                    if (emptySpace != -1) {
                                        for (int k = emptySpace; k > theWorld[i][j].getY(); k--) {
                                            theWorld[i][k - 1].updateXRight();
                                            theWorld[i][k] = theWorld[i][k - 1];
                                        }
                                        theWorld[i][j] = null;
                                    }
                                }
                                break;
                            //south
                            case 2:
                                autonomousObject.setMarker(true);
                                if(checkVerticalDown(theWorld,theWorld[i][j].getX(),theWorld[i][j].getY())){
                                    emptySpace = findEmptySpaceVerticalDown(theWorld,theWorld[i][j].getX(),theWorld[i][j].getY());
                                    if(emptySpace != -1){
                                        for (int k = emptySpace; k > theWorld[i][j].getX(); k--) {
                                            theWorld[k-1][j].updateYDown();
                                            theWorld[k][j] = theWorld[k-1][j];
                                        }
                                        theWorld[i][j] = null;
                                    }
                                }
                                break;
                            //west
                            case 3:
                                autonomousObject.setMarker(true);
                                if(checkHorizontalLeft(theWorld,theWorld[i][j].getX(),theWorld[i][j].getY())){
                                    emptySpace = findEmptySpaceHorizontalLeft(theWorld,theWorld[i][j].getX(),theWorld[i][j].getY());
                                    if(emptySpace != -1){
                                        for (int k = emptySpace; k < theWorld[i][j].getY(); k++) {
                                            theWorld[i][k+1].updateXLeft();
                                            theWorld[i][k] = theWorld[i][k+1];
                                        }
                                        theWorld[i][j] = null;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }

    // Name: checkHorizontalRight
    // Developers: Wael Jamal Alhashemi
    // Purpose: verifies if we can shift objects horizontally to the right
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: true or false
    // Side-effects: None
    // Special notes: None
    public boolean checkHorizontalRight(ItemObject[][] world, int positionX, int positionY) {
        if (positionY == world[positionX].length - 1) return false;
        else {
            for (int i = positionY + 1; i < world[positionX].length; i++) {
                if (world[positionX][i] == null) return true;
                else if (world[positionX][i].getName().equals("Immovable")) return false;
            }
            return false;
        }
    }

    // Name: checkHorizontalLeft
    // Developers: Wael Jamal Alhashemi
    // Purpose: verifies if we can shift objects horizontally to the left
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: true or false
    // Side-effects: None
    // Special notes: None
    public boolean checkHorizontalLeft(ItemObject[][] world, int positionX, int positionY) {
        //you're at the border
        if (positionY == 0) return false;
        else {
            for (int i = positionY - 1; i >= 0; i--) {
                if (world[positionX][i] == null) return true;
                else if (world[positionX][i].getName().equals("Immovable")) return false;
            }
            //space is full
            return false;
        }
    }

    // Name: checkVerticalUp
    // Developers: Wael Jamal Alhashemi
    // Purpose: verifies if we can shift objects vertically upwards
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: true or false
    // Side-effects: None
    // Special notes: None
    public boolean checkVerticalUp(ItemObject[][] world, int positionX, int positionY) {
        if (positionX == 0) return false;
        else {
            for (int i = positionX - 1; i >= 0; i--) {
                if (world[i][positionY] == null) return true;
                else if (world[i][positionY].getName().equals("Immovable")) return false;
            }
            return false;
        }
    }

    // Name: checkVerticalDown
    // Developers: Wael Jamal Alhashemi
    // Purpose: verifies if we can shift objects vertically downwards
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: true or false
    // Side-effects: None
    // Special notes: None
    public boolean checkVerticalDown(ItemObject[][] world, int positionX, int positionY) {
        if (positionX == world.length - 1) return false;
        else {
            for (int i = positionX + 1; i < world.length; i++) {
                if (world[i][positionY] == null) return true;
                else if (world[i][positionY].getName().equals("Immovable")) return false;
            }
            return true;
        }
    }

    // Name: findEmptySpaceHorizontalRight
    // Developers: Wael Jamal Alhashemi
    // Purpose: finds the first empty cell to the right of the starting position
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: int position on grid
    // Side-effects: None
    // Special notes: None
    public int findEmptySpaceHorizontalRight(ItemObject[][] world, int positionX, int positionY) {
        for (int i = positionY; i < world[positionX].length; i++) {
            if (world[positionX][i] == null) return i;
        }
        return -1;
    }

    // Name: findEmptySpaceHorizontalLeft
    // Developers: Wael Jamal Alhashemi
    // Purpose: finds the first empty cell to the left of the starting position
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: int position on grid
    // Side-effects: None
    // Special notes: None
    public int findEmptySpaceHorizontalLeft(ItemObject[][] world, int positionX, int positionY) {
        for (int i = positionY; i >= 0; i--) {
            if (world[positionX][i] == null) return i;
        }
        return -1;
    }

    // Name: findEmptySpaceVerticalUp
    // Developers: Wael Jamal Alhashemi
    // Purpose: finds the first empty cell above the starting position
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: int position on grid
    // Side-effects: None
    // Special notes: None
    public int findEmptySpaceVerticalUp(ItemObject[][] world, int positionX, int positionY) {
        for (int i = positionX; i >= 0; i--) {
            if (world[i][positionY] == null) return i;
        }
        return -1;
    }

    // Name: findEmptySpaceVerticalDown
    // Developers: Wael Jamal Alhashemi
    // Purpose: finds the first empty cell below the starting position
    // Inputs: world (Item[][]), int x and y coordinates
    // Outputs: int position on grid
    // Side-effects: None
    // Special notes: None
    public int findEmptySpaceVerticalDown(ItemObject[][] world, int positionX, int positionY) {
        for (int i = positionX; i < world.length; i++) {
            if (world[i][positionY] == null) return i;
        }
        return -1;
    }

    // Name: setSize
    // Developers: Wael Jamal Alhashemi
    // Purpose: sets the size for the world because we cant set the size from the singleton
    // Inputs: rows and columns (both int)
    // Outputs: none
    // Side-effects: None
    // Special notes: None
    public static void setSize(int rows, int columns){
        theWorld = new ItemObject[rows][columns];
    }
}