import java.util.Scanner;
import java.util.concurrent.TimeUnit;
// File Name: WorldMain.java
// Developers: Wael Jamal Alhashemi
// Purpose: the main program where the user hand codes the world
// Inputs: buildWorld: None.
// Outputs: buildWorld: World object
// Modifications
// ==========
// WA Apr 16th 2018
public class WorldMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput;
        World world = buildWorld();
        do {
            for (int i = 0; i < 100; i++) {
                try {
                    world.display();
                    world.step();
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (Exception e){

                }
            }
            System.out.println("Would you like to run the simulation again? Type either yes or no");
            userInput = input.nextLine();
        } while (userInput.equals("yes"));
        System.exit(0);
    }

    // Name: buildWorld
    // Developers: Wael Jamal Alhashemi
    // Purpose: creates the world
    // Inputs: None
    // Outputs: World object
    // Side-effects: None
    // Special notes: None
    private static World buildWorld() {
        World world = World.getInstance();
        World.setSize(6,6);
        world.add(new Immovable("Immovable", 'I', 0, 0), 0, 0);
        world.add(new Immovable("Immovable", 'I', 4, 4), 4, 4);
        world.add(new Immovable("Immovable", 'I', 0, 4), 0, 4);
        world.add(new Immovable("Immovable", 'I', 4, 0), 4, 0);
        world.add(new Immovable("Immovable", 'I', 2, 2), 2, 2);
        world.add(new Movable("Movable", 'M', 1, 2), 1, 2);
        world.add(new Movable("Movable", 'M', 3, 2), 3, 2);
        world.add(new Movable("Movable", 'M', 2, 3), 2, 3);
        world.add(new Autonomous("Autonomous", 'A', 1, 0), 1, 0);
        world.add(new Autonomous("Autonomous", 'A', 1, 4), 1, 4);
        return world;
    }

}
