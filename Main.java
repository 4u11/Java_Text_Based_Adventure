public class Main {
    public static void main(String[] args) {
        // Create all scenes first (initialize with null for next scenes)
        Scene scene10 = new Scene(
            "Serana run and circling around the bandit village. Serana finally sees her castle in the distance! Her adventure comes to an end.",
            "Return to castle (Victory!)", null, 0, 0,
            null, null, 0, 0,
            null, null, 0, 0
        );
        
        Scene scene9 = new Scene(
            "More bandits emerge from the village houses! Serana is surrounded!",
            "Fight with magic (-50HP, -40MP, +45XP)", scene10, 50, 45,
            "Fight with dagger (-60HP, +50XP)", scene10, 60, 50,
            "Try to negotiate (Game Over)", null, 0, 0
        );
        
        Scene scene8 = new Scene(
            "Serana stumbles upon what appears to be a bandit village!",
            "Attack with fireballs and lightning (-50HP, -40MP, +45XP)", scene9, 50, 45,
            "Attack with Elven dagger (-60HP, +50XP)", scene9, 60, 50,
            "Run away (+10XP)", scene10, 0, 10
        );
        
        Scene scene7 = new Scene(
            "The river flows found an end. Serana now traveling to the woods. While traveling, Serana encounters dangerous wildlife!",
            "Fight a bear (-25HP, +30XP)", scene8, 25, 30,
            "Fight a warrior orc (-35HP, +40XP)", scene8, 35, 40,
            "Hunt a rabbit (+10XP, gain rabbit meat)", scene8, 0, 10
        );
        
        Scene scene6 = new Scene(
            "After the bandits were defeated, morning comes. Serana went out from the cave. Then Serana finds herself at a crossroads near a river.",
            "Follow the river downstream", scene7, 0, 0,
            "Go fishing (+10XP, gain fish)", scene7, 0, 10,
            "Go swimming (restore HP/MP)", scene7, 0, 0
        );
        
        Scene scene5 = new Scene(
            "The noises were bandits! They've found Serana's hiding place!",
            "Fight with fireballs (-25HP, -30MP, +30XP)", scene6, 25, 30,
            "Fight with dagger (-40HP, +35XP)", scene6, 40, 35,
            "Try to go back to sleep (Game Over)", null, 0, 0
        );
        
        Scene scene4 = new Scene(
            "At night, Serana hears strange noises outside her hiding spot.",
            "Investigate the noises (+10XP)", scene5, 0, 10,
            "Ignore the noises and go back to sleep", scene5, 0, 0,
            "Prepare fireball spell just in case", scene5, 0, 0
        );
        
        Scene scene3 = new Scene(
            "After escaping the bandits, Serana finds a strange-looking cave entrance.",
            "Enter the cave", scene4, 0, 0,
            "Climb a nearby tree to scout (-20HP if fall, +10XP)", scene4, 20, 10,
            "Hide and rest in the cave (Full HP/MP restore)", scene4, 0, 0
        );
        
        Scene scene2 = new Scene(
            "Suddenly, Serana is halted by a group of bandits! They demand all her belongings.",
            "Fight with Elven dagger (-30HP, +20XP)", scene3, 30, 20,
            "Run away (+10XP)", scene3, 0, 10,
            "Cast fireball (-10HP, -10MP, +15XP)", scene3, 10, 15
        );
        
        Scene scene1 = new Scene(
            "Serana is in a forest looking for berries. She finds two types: one looks safe, the other looks poisonous.",
            "Eat the safe-looking berries (+10HP)", scene2, 0, 0,
            "Risk eating the poisonous berries (-10HP)", scene2, 10, 0,
            "Don't eat any berries", scene2, 0, 0
        );

        // Create player character (Serana)
        Character serana = new Character("Serana", 100);
        serana.setItem("Elven dagger");
        
        // Create and start the story
        Story story = new Story(scene1, serana);
        story.start();
    }
}