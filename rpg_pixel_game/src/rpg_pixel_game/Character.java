package rpg_pixel_game;


public abstract class Character {

    protected String name; 
    protected int lifePoint;
    protected int armor;
    protected int speed;
    protected int strength;
    protected Weapon weapon;
    protected int level;

    Character() {}

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
            "=============ATTRIBUTES===========" + "\n" +
            "Char name: " + this.name + "\n" +
            "LP: " + this.lifePoint + ", Lvl: " + this.level + "\n" +
            "Armor: " + this.armor + ", Speed: " + this.speed + ", Strength: " + this.strength + "\n" +
            "Class: " + this.getCharClass() + ", Weapon: " + this.weapon;
    }

    public void basicAttack(Monster m) {
        int totalDmg = this.weapon.getDamage() + this.strength;
        int dmgDealed = m.beingAttack(totalDmg);
        System.out.println("Basic attack " + PlayMain.ANSI_RED + "-" + dmgDealed + PlayMain.ANSI_RESET);
    }

    public int beingAttack(int damageTaken) {
        int damageDealed = damageTaken - this.armor > 0 ? damageTaken - this.armor : 0;
        this.lifePoint -= damageDealed;
        return damageDealed;
    }

    public Boolean isDead() {
        Boolean dead = this.lifePoint <= 0 ? true : false;
        return dead;
    }

    public abstract void levelUp();

    public abstract void damageSpell(Character c);
    public abstract void effectSpell();

    public abstract String displaySpells();

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

    public int getLevel() {
        return this.level;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}
