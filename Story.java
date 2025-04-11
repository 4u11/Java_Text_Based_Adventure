import java.util.Scanner;

public class Story {
    private Scene startScene;
    private Character player;
    private Scanner scanner;

    public Story(Scene startScene, Character player) {
        this.startScene = startScene;
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Serana's Adventure ===");
        System.out.println("You are " + player.getName() + ", an elven adventurer.");
        System.out.println("Starting with " + player.getHealth() + " HP and " + player.getMana() + " MP.");
        System.out.println("Equipment: " + player.getItem());
        System.out.println("Type 'INFO' at any time to check your status.");
        System.out.println("Type A, B, or C to make your choice.");
        System.out.println("Good luck!\n");
        play();
    }

    public void play() {
        Scene currentScene = startScene;
        
        while (currentScene != null) {
            // Clear screen (optional)
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            // Display current scene using the display() method
            currentScene.display();
            
            System.out.println("\nType 'INFO' to check your status");
            System.out.print("Enter your choice (A/B/C): ");
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("INFO")) {
                displayCharacterInfo();
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                continue;
            }
            
            Scene nextScene = currentScene.makeChoice(input, player);
            handleSpecialActions(currentScene, input);
            
            if (nextScene == null && !input.equalsIgnoreCase("INFO")) {
                System.out.println("\nInvalid choice. Please try again.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            } else {
                currentScene = nextScene;
                
                if (player.getHealth() <= 0) {
                    System.out.println("\nSerana has fallen in battle!");
                    System.out.println("Game Over!");
                    break;
                }
                
                if (currentScene != null && currentScene.getDescription().contains("castle")) {
                    System.out.println("\nSerana has successfully returned to her castle!");
                    System.out.println("Final Stats:");
                    displayCharacterInfo();
                    System.out.println("\n=== Adventure Complete ===");
                    break;
                }
            }
        }
        
        scanner.close();
    }
    
    private void displayCharacterInfo() {
        System.out.println("\n--- Character Info ---");
        System.out.println("Name: " + player.getName());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Mana: " + player.getMana());
        System.out.println("XP: " + player.getXP());
        System.out.println("Item: " + player.getItem());
        System.out.println("----------------------");
    }
    
    private void handleSpecialActions(Scene scene, String choice) {
        String desc = scene.getDescription().toLowerCase();
        choice = choice.toUpperCase();
        
        if (desc.contains("berry") && choice.equals("A")) {
            player.restoreHealth(10);
            System.out.println("\nSerana eats the berries and gains 10HP!");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
        
        if (desc.contains("rest") && choice.equals("C")) {
            player.fullRestore();
            System.out.println("\nSerana rests and fully recovers HP and MP!");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
        
        if (desc.contains("swim") && choice.equals("C")) {
            player.restoreHealth(30);
            player.restoreMana(20);
            System.out.println("\nThe refreshing swim restores 30HP and 20MP!");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
        
        if ((choice.equals("A") || choice.equals("C")) && 
            (desc.contains("fireball") || desc.contains("magic")) && 
            player.getMana() < 10) {
            System.out.println("\nNot enough mana for this action!");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
    }
}