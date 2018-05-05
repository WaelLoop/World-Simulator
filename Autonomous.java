// File Name: Autonomous.java
// Developers: Wael Jamal Alhashemi
// Purpose: creates Immovable object
// Inputs: getToken: None. step: None
// step: None. display: none.
// Outputs: None
// Modifications
// ==========
// WA Apr 16th 2018
public class Autonomous extends ItemObject {
	private boolean marker;
    // Name: Autonomous
    // Developers: Wael Jamal Alhashemi
    // Purpose: constructor
    // Inputs: None
    // Outputs: Autonomous Object
    // Side-effects: None
    // Special notes: None
    public Autonomous(String name, char token, int x, int y) {
        super(name, token, x, y);
    }

    // Name: step
    // Developers: Wael Jamal Alhashemi
    // Purpose: picks a random direction and update the x and y coordinates of the object
    // Inputs: None
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void step() {
        int randomDirection = (int) Math.random() * 4;
        switch (randomDirection) {
            //north
            case 0:
                this.updateYUp();
                //east
            case 1:
                this.updateXRight();
                //south
            case 2:
                this.updateYDown();
                //west
            case 3:
                this.updateXLeft();

            default:
                break;
        }
    }

    // Name: setMarker
    // Developers: Wael Jamal Alhashemi
    // Purpose: Keep track of the autonomous object that have moved
    // Inputs: boolean
    // Outputs: None
    // Side-effects: None
    // Special notes: None
    public void setMarker(boolean bool){
    	this.marker = bool;
    }

    // Name: getMarker
    // Developers: Wael Jamal Alhashemi
    // Purpose: return whether or not the autonomous object have moved
    // Inputs: None
    // Outputs: Boolean
    // Side-effects: None
    // Special notes: None
    public boolean getMarker(){
    	return this.marker;
    }
}
