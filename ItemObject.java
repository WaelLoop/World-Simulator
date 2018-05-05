// File Name: ItemObject.java
// Developers: Wael Jamal Alhashemi
// Purpose: an abstract class that has a name, token and x and y coordinates
// Inputs: none
// Outputs: None
// Modifications
// ==========
// WA Apr 16th 2018
public abstract class ItemObject implements Item{
    private String name;
    private char token;
    private int x,y;

    public ItemObject(String name,char token,int x,int y){
        this.name = name;
        this.token = token;
        this.x = x;
        this.y = y;
    }

    // Name: getToken
    // Developers: Wael Jamal Alhashemi
    // Purpose: return a character symbol
    // Inputs: None
    // Outputs: token char
    // Side-effects: None
    // Special notes: None
    public char getToken(){
        return this.token;
    }

    // Name: getName
    // Developers: Wael Jamal Alhashemi
    // Purpose: return the name of the item
    // Inputs: None
    // Outputs: string name
    // Side-effects: None
    // Special notes: None
    public String getName(){
        return this.name;
    }

    // Name: getX
    // Developers: Wael Jamal Alhashemi
    // Purpose: return the item's x-coordinate
    // Inputs: None
    // Outputs: items x's position (int)
    // Side-effects: None
    // Special notes: None
    public int getX(){
        return this.x;
    }

    // Name: getY
    // Developers: Wael Jamal Alhashemi
    // Purpose: return the item's y-coordinate
    // Inputs: None
    // Outputs: items y's position (int)
    // Side-effects: None
    // Special notes: None
    public int getY(){
        return this.y;
    }

    // Name: updateXRight
    // Developers: Wael Jamal Alhashemi
    // Purpose: update the x coordinate
    // Inputs: None
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void updateXRight(){
        this.y += 1;
    }

    // Name: updateXLeft
    // Developers: Wael Jamal Alhashemi
    // Purpose: update the x coordinate
    // Inputs: None
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void updateXLeft(){
        this.y -= 1;
    }

    // Name: updateYUp
    // Developers: Wael Jamal Alhashemi
    // Purpose: update the y coordinate
    // Inputs: None
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void updateYUp(){
        this.x -= 1;
    }

    // Name: updateYDown
    // Developers: Wael Jamal Alhashemi
    // Purpose: update the y coordinate
    // Inputs: None
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void updateYDown(){
        this.x += 1;
    }
}
