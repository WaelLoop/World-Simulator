The Design Patterns I used:

1. Singleton: Since there will only be 1 World and all the objects(Autonomous, Movable and Immovable) will be in created in that world. 

2. MVC: The model and view is World.java as it holds all the objects (Immovable, Movable and Autonomous all extends ItemObject). It also has the function display that shows the GUI of the world. The controller is WorldMain.java as it builds the world and adds objects to it. 

-----------------------------
The Design techniques I used: Abstract classes, interface and inheritance

The interface has functions that give us information about the objects such as get the name, token, positions of each one. It also has the function that updates the positions of the objects.

The Abstract class implements the interface. It has 4 private attributes specifically name token and the x and y coordinate of the object. It also has functions that are implemented by the interface. The Abstract class has 3 children; Movable, Immovable and Autonomous. Autonomous has an extra private attribute called marker used to see if the object has moved during the call of World.step(). Moreover, it has a function Called step, that basically picks a random direction and updates its position based on the randomized direction. Finally it has getter and setter for the marker attribute.

-----------------------------
How to run the program:
1. In WorldMain.java, handcode your object in the function buildworld().
2. Run WorldMain.java

P.S.: if you want to change how many times the simulation runs, just change the value of the condition in the forloop.
