package rpg_pixel_game;


public abstract class Character implements CharacterInterface {

    protected String name; 
    protected int lifePoint;
    protected int armor;
    protected int speed;
    protected int strength;
    protected Weapon weapon;
    protected int level;


    // Constructor
    Character(String name) {
        this.name = name;
        this.lifePoint = 20;
        this.level = 1;
    }

    public String getName() {
        return this.name;
    }

    public String getCharClass() {
        return this.getClass().getSimpleName();
    }

    public String getAttributes() {
        return 
            "Char name: " + this.name + "\n" +
            "LP: " + this.lifePoint + ", Lvl: " + this.level + "\n" +
            "Armor: " + this.armor + ", Speed: " + this.speed + "\n" +
            "Strength: " + this.strength + ", Weapon: " + this.weapon + "\n";
    }

    public void basicAttack(Monster m) {
        m.beingAttack(this.weapon.getDamage() + this.strength);
    }

    public void levelUp() {};

    public int getLifePoint() {
        return this.lifePoint;
    }

    public int getArmor() {
        return this.armor;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getStrength() {
        return this.strength;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}
