public class Character {
    private String name;
    private int health;
    private int mana;
    private int XP;
    private String item;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.mana = 50; // Starting mana
        this.XP = 0;
        this.item = "None";
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void useMana(int amount) {
        this.mana -= amount;
        if (this.mana < 0) {
            this.mana = 0;
        }
    }

    public void addXP(int additionalXP) {
        this.XP += additionalXP;
    }

    public void restoreHealth(int amount) {
        this.health += amount;
    }

    public void restoreMana(int amount) {
        this.mana += amount;
    }

    public void fullRestore() {
        this.health = 100;
        this.mana = 50;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getXP() {
        return XP;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}